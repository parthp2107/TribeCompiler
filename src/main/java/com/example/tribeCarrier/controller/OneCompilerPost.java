package com.example.tribeCarrier.controller;

import com.example.tribeCarrier.entity.*;
import com.example.tribeCarrier.service.TribeService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;

@RestController()
public class OneCompilerPost {

  Calendar cal = Calendar.getInstance();

  @Value("${upload.path}")
  private String uploadPath;

  @Autowired
  TribeService tribeService;

  @GetMapping("/getAllUserId")
  private List<TribeCreateUserEntity> getAllUsersId() {
    return tribeService.getAllUsersById();
  }

  @GetMapping("/getAllProblemId")
    private List<TribeProblemsEntity> getAllProblemId() {
      return tribeService.getAllProblemId();
    }

  @PostMapping("/addUser")
  private String addUser(@RequestBody TribeCreateUserEntity tribeCreateUserEntity) {
    tribeService.addUser(tribeCreateUserEntity);
    return tribeCreateUserEntity.getEmail();
  }

  @PostMapping("/addUserProblemReference")
  private Object addUserProblemRef(@RequestBody UserProblemRef userProblemRef, UserProblemEntity userProblemEntity) {
    List<Integer> problem_id = new ArrayList<>();
    List<Integer> problem_time = new ArrayList<>();
    for (int i = 0; i < userProblemRef.getProblemId().size(); i++) {
      UserProblemEntity userProblemEntity1 = new UserProblemEntity();
      userProblemEntity1.setId(userProblemEntity.getId());
      userProblemEntity1.setUser_id(userProblemRef.getUserId());
      problem_id.add((Integer) userProblemRef.getProblemId().get(i));
      userProblemEntity1.setProblem_id(problem_id.get(i));
      problem_time.add((Integer) userProblemRef.getProblemTime().get(i));
      userProblemEntity1.setProblem_time(problem_time.get(i));
      tribeService.addUserProblemRef(userProblemEntity1);
    } return problem_id;
  }

  @PostMapping("/getUserProblemDetails")
  private List<Object> getUserProblemDetails(@RequestBody UserProblemEntity userProblemEntity) {
    return tribeService.getUserProblemDetails(userProblemEntity.getUser_id(), userProblemEntity.getProblem_id());
  }

  @PostMapping("/user")
  public TribeUserLoginEntity getUserByEmail(@RequestBody TribeCheckUserEntity tribeCheckUserEntity, TribeCreateUserEntity tribeCreateUserEntity) throws Exception {
    if (Objects.equals(tribeCheckUserEntity.getEmail(), tribeService.getUserByEmail(tribeCheckUserEntity.getEmail()).getEmail()) &&
            Objects.equals(tribeCheckUserEntity.getPassword(), tribeService.getUserByEmail(tribeCheckUserEntity.getEmail()).getPassword())) {
      TribeUserLoginEntity tribeUserLogin = new TribeUserLoginEntity();
      tribeUserLogin.setEmail(tribeCheckUserEntity.getEmail());
      tribeUserLogin.setIsLoggedIn("true");
      tribeUserLogin.setSessionTime(new Timestamp(cal.getTime().getTime()));
      tribeService.saveUserLoginActivity(tribeUserLogin);
      return tribeUserLogin;
    } else {
      throw new Exception("User not present");
    }
  }

  @PostMapping("/addProblemStatement")
  private TribeProblemsEntity problemEntity(@RequestBody TribeProblemsEntity tribeProblemsEntity) throws IOException {
    tribeService.addProblemStatement(tribeProblemsEntity);
    return tribeProblemsEntity;
  }

  @GetMapping("/getProblemStatement")
  private TribeProblemsEntity getProblemStatement(@RequestBody TribeProblemStatementEntity tribeProblemStatementEntity, TribeProblemsEntity tribeProblemsEntity) throws Exception {
    if (Objects.equals(tribeProblemStatementEntity.getProblemId(), tribeService.getProblemById(tribeProblemStatementEntity.getProblemId()).getProblemId()) &&
            Objects.equals(tribeProblemStatementEntity.getCategory(), tribeService.getProblemById(tribeProblemStatementEntity.getProblemId()).getCategory()) &&
            Objects.equals(tribeProblemStatementEntity.getProblem_experience(), tribeService.getProblemById(tribeProblemStatementEntity.getProblemId()).getProblemExperience())) {
      return tribeService.getProblemStatement(tribeProblemStatementEntity.getCategory(), tribeProblemStatementEntity.getProblem_experience());
    } else {
      throw new Exception("Problem Statement not present");
    }
  }

  @PostMapping("/startTest")
  private StartTestEntity startTest(@RequestBody StartTestEntity startTestEntity) {
    StartTestEntity startTestEntity1 = new StartTestEntity();
    startTestEntity1.setUser_id(startTestEntity.getUser_id());
    startTestEntity1.setStartTime(new Timestamp(new Date().getTime()));
    startTestEntity1.setCumulative_time_minutes(startTestEntity.getCumulative_time_minutes());
    cal.add(Calendar.MINUTE, startTestEntity.getCumulative_time_minutes());
    Timestamp endTime = new Timestamp(cal.getTime().getTime());
    startTestEntity1.setEndTime(endTime);
    tribeService.startTestRecord(startTestEntity1);
    return startTestEntity1;
  }

  @PostMapping("/files")
  public String uploadFile(@RequestHeader("file") MultipartFile file) throws IOException {
    Path filePath = Paths.get(uploadPath);
    try {
      tribeService.save(file);
      return filePath.toUri() + "/" + file.getOriginalFilename();
    } catch (Exception e) {
      return "Could not upload the file: " + file.getOriginalFilename();
    }
  }

  @PostMapping("/test")
  public Object test(@RequestBody TribeEntity tribeEntity) throws IOException {
	  List<String> output = new ArrayList<String>();
    for (int i=0; i < tribeEntity.getStdInString().size(); i++) {
      HttpClient httpClient = HttpClientBuilder.create().build();
      HttpPost request = new HttpPost("https://onecompiler.com/api/code/exec");
      StringEntity javascriptParam = new StringEntity("{\"name\":\"JavaScript\",\"title\":\"JavaScript Hello World\",\"version\":\"ES6\",\"mode\":\"javascript\",\"description\":null,\"extension\":\"js\",\"languageType\":\"programming\",\"active\":true,\"properties\":{\"language\":\"javascript\",\"docs\":true,\"tutorials\":true,\"cheatsheets\":true,\"filesEditable\":true,\"filesDeletable\":true,\"files\":[{\"name\":\"HelloWorld.js\",\"content\":\"console.log(\\\"Hello, World!\\\");\"}],\"newFileOptions\":[{\"helpText\":\"New JS file\",\"name\":\"script${i}.js\",\"content\":\"/**\\n *  In main file\\n *  let script${i} = require('./script${i}');\\n *  console.log(script${i}.sum(1, 2));\\n */\\n\\nfunction sum(a, b) {\\n    return a + b;\\n}\\n\\nmodule.exports = { sum };\"},{\"helpText\":\"Add Dependencies\",\"name\":\"package.json\",\"content\":\"{\\n  \\\"name\\\": \\\"main_app\\\",\\n  \\\"version\\\": \\\"1.0.0\\\",\\n  \\\"description\\\": \\\"\\\",\\n  \\\"main\\\": \\\"HelloWorld.js\\\",\\n  \\\"dependencies\\\": {\\n    \\\"lodash\\\": \\\"^4.17.21\\\"\\n  }\\n}\"}],\"result\":{\"success\":true,\"output\":\"Hello, World!\\n\"},\"stdin\":\"" + tribeEntity.getStdInString().get(i) + "\"},\"visibility\":\"public\"}");
      StringEntity java = new StringEntity("{\"name\":\"Java\",\"title\":\"3xx5fvngn\",\"version\":\"11\",\"mode\":\"java\",\"description\":null,\"extension\":\"java\",\"concurrentJobs\":2,\"languageType\":\"programming\",\"active\":true,\"properties\":{\"language\":\"java\",\"docs\":true,\"tutorials\":false,\"cheatsheets\":true,\"filesEditable\":true,\"filesDeletable\":true,\"files\":[{\"name\":\"Main.java\",\"content\":\"" + tribeEntity.getCodeString()+ "\"}],\"newFileOptions\":[{\"helpText\":\"New Java file\",\"name\":\"NewClass${i}.java\",\"content\":\"public class NewClass${i} {\\n\\n  public String sayHelloFromNewClass(){\\n    return \\\"Hello from New Class\\\";\\n  }\\n\\n}\"},{\"helpText\":\"Add Dependencies\",\"name\":\"build.gradle\",\"content\":\"apply plugin:'application'\\nmainClassName = 'HelloWorld'\\n\\nrun { standardInput = System.in }\\nsourceSets { main { java { srcDir './' } } }\\n\\nrepositories {\\n    jcenter()\\n}\\n\\ndependencies {\\n    // add dependencies here like following\\n    // compile group: 'org.apache.commons', name: 'commons-lang3', version: '3.9'\\n}\"}],\"stdin\":\"" + tribeEntity.getStdInString().get(i) + "\"},\"_id\":\"3xx5fvngn\",\"user\":null,\"idToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjN4eDVmdm5nbiIsImlhdCI6MTY0ODE5MzAyMn0.jbfAqnj_vte2RWScaz9GVFzFHhjgF1d16iWC3o1SoGw\",\"visibility\":\"public\"}");
      request.addHeader("content-type", "application/json");
      request.setEntity(javascriptParam);
      HttpResponse response = httpClient.execute(request);
      String responseAsString = EntityUtils.toString(response.getEntity());
      System.out.println(responseAsString);
      JSONObject jsonObject = new JSONObject(responseAsString);
      output.add(jsonObject.get("stdout").toString());
    } return output;
  }
}
