package com.example.tribeCarrier.controller;

import com.example.tribeCarrier.entity.TribeCheckUserEntity;
import com.example.tribeCarrier.entity.TribeUserLoginEntity;
import com.example.tribeCarrier.service.TribeService;
import com.example.tribeCarrier.entity.TribeCreateUserEntity;
import com.example.tribeCarrier.entity.TribeEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController()
public class OneCompilerPost {

  @Autowired
  TribeService tribeService;

  @PostMapping("/addUser")
  private String getUserById(@RequestBody TribeCreateUserEntity tribeCreateUserEntity) {
    tribeService.addUser(tribeCreateUserEntity);
    return tribeCreateUserEntity.getEmail();
  }

  @PostMapping("/user")
  public TribeUserLoginEntity getUserByEmail(@RequestBody TribeCheckUserEntity tribeCheckUserEntity, TribeCreateUserEntity tribeCreateUserEntity) throws Exception {
    if (Objects.equals(tribeCheckUserEntity.getEmail(), tribeService.getUserByEmail(tribeCheckUserEntity.getEmail()).getEmail()) &&
            Objects.equals(tribeCheckUserEntity.getPassword(), tribeService.getUserByEmail(tribeCheckUserEntity.getEmail()).getPassword())) {
      TribeUserLoginEntity tribeUserLogin = new TribeUserLoginEntity();
      tribeUserLogin.setEmail(tribeCheckUserEntity.getEmail());
      tribeUserLogin.setIsLoggedIn("true");
      tribeUserLogin.setSession("Date");
      return tribeUserLogin;
    } else {
      throw new Exception("User not present");
    }
  }

  @PostMapping("/test")
  public Object test(@RequestBody TribeEntity tribeEntity) throws IOException {
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost request = new HttpPost("https://onecompiler.com/api/code/exec");
    StringEntity javascriptParam = new StringEntity("{\"name\":\"JavaScript\",\"title\":\"JavaScript Hello World\",\"version\":\"ES6\",\"mode\":\"javascript\",\"description\":null,\"extension\":\"js\",\"languageType\":\"programming\",\"active\":true,\"properties\":{\"language\":\"javascript\",\"docs\":true,\"tutorials\":true,\"cheatsheets\":true,\"filesEditable\":true,\"filesDeletable\":true,\"files\":[{\"name\":\"HelloWorld.js\",\"content\":\"" + tribeEntity.getCodeString() + "\"}],\"newFileOptions\":[{\"helpText\":\"New JS file\",\"name\":\"script${i}.js\",\"content\":\"/**\\n *  In main file\\n *  let script${i} = require('./script${i}');\\n *  console.log(script${i}.sum(1, 2));\\n */\\n\\nfunction sum(a, b) {\\n    return a + b;\\n}\\n\\nmodule.exports = { sum };\"},{\"helpText\":\"Add Dependencies\",\"name\":\"package.json\",\"content\":\"{\\n  \\\"name\\\": \\\"main_app\\\",\\n  \\\"version\\\": \\\"1.0.0\\\",\\n  \\\"description\\\": \\\"\\\",\\n  \\\"main\\\": \\\"HelloWorld.js\\\",\\n  \\\"dependencies\\\": {\\n    \\\"lodash\\\": \\\"^4.17.21\\\"\\n  }\\n}\"}]},\"visibility\":\"public\"}");
//    StringEntity javaParam = new StringEntity("{\"name\":\"Java\",\"title\":\"3xwvmse79\",\"version\":\"11\",\"mode\":\"java\",\"description\":null,\"extension\":\"java\",\"concurrentJobs\":2,\"languageType\":\"programming\",\"active\":true,\"properties\":{\"language\":\"java\",\"docs\":true,\"tutorials\":false,\"cheatsheets\":true,\"filesEditable\":true,\"filesDeletable\":true,\"files\":[{\"name\":\"Main.java\",\"content\":\""+ tribeEntity.getCodeString() +"\"}],\"newFileOptions\":[{\"helpText\":\"New Java file\",\"name\":\"NewClass${i}.java\",\"content\":\"public class NewClass${i} {\\n\\n  public String sayHelloFromNewClass(){\\n    return \\\"Hello from New Class\\\";\\n  }\\n\\n}\"},{\"helpText\":\"Add Dependencies\",\"name\":\"build.gradle\",\"content\":\"apply plugin:'application'\\nmainClassName = 'HelloWorld'\\n\\nrun { standardInput = System.in }\\nsourceSets { main { java { srcDir './' } } }\\n\\nrepositories {\\n    jcenter()\\n}\\n\\ndependencies {\\n    // add dependencies here like following\\n    // compile group: 'org.apache.commons', name: 'commons-lang3', version: '3.9'\\n}\"}]},\"_id\":\"3xwvmse79\",\"user\":null,\"idToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjN4d3Ztc2U3OSIsImlhdCI6MTY0Nzk2ODUxMH0.M1JeNfXnHdKANw5pybZKnyNDEG_c8UW1FUfVBd1PGFk\",\"visibility\":\"public\"}");
    request.addHeader("content-type", "application/json");
    request.setEntity(javascriptParam);
    HttpResponse response = httpClient.execute(request);
    String responseAsString = EntityUtils.toString(response.getEntity());
    System.out.println(responseAsString);
    JSONObject jsonObject = new JSONObject(responseAsString);
    return jsonObject.get("stdout");
  }
}

//  @GetMapping("/test")
//  public Object test(String code) throws IOException {
//    code = "console.log(\\\"Hello, World!\\\");";
//    HttpClient httpClient = HttpClientBuilder.create().build();
//    HttpPost request = new HttpPost("https://onecompiler.com/api/code/exec");
//    StringEntity params = new StringEntity("{\"name\":\"JavaScript\",\"title\":\"JavaScript Hello World\",\"version\":\"ES6\",\"mode\":\"javascript\",\"description\":null,\"extension\":\"js\",\"languageType\":\"programming\",\"active\":true,\"properties\":{\"language\":\"javascript\",\"docs\":true,\"tutorials\":true,\"cheatsheets\":true,\"filesEditable\":true,\"filesDeletable\":true,\"files\":[{\"name\":\"HelloWorld.js\",\"content\":\"" + code + "\"}],\"newFileOptions\":[{\"helpText\":\"New JS file\",\"name\":\"script${i}.js\",\"content\":\"/**\\n *  In main file\\n *  let script${i} = require('./script${i}');\\n *  console.log(script${i}.sum(1, 2));\\n */\\n\\nfunction sum(a, b) {\\n    return a + b;\\n}\\n\\nmodule.exports = { sum };\"},{\"helpText\":\"Add Dependencies\",\"name\":\"package.json\",\"content\":\"{\\n  \\\"name\\\": \\\"main_app\\\",\\n  \\\"version\\\": \\\"1.0.0\\\",\\n  \\\"description\\\": \\\"\\\",\\n  \\\"main\\\": \\\"HelloWorld.js\\\",\\n  \\\"dependencies\\\": {\\n    \\\"lodash\\\": \\\"^4.17.21\\\"\\n  }\\n}\"}]},\"visibility\":\"public\"}");
//    request.addHeader("content-type", "application/json");
//    request.setEntity(params);
//    HttpResponse response = httpClient.execute(request);
//    String responseAsString = EntityUtils.toString(response.getEntity());
//    JSONObject jsonObject = new JSONObject(responseAsString);
//    return jsonObject.get("stdout");
//  }


  /*@GetMapping("/users")
  private List<TribeCreateUserEntity> getUser() {
    return tribeService.getLoggedInUser();
  }

  @GetMapping("/users/{id}")
  public TribeCreateUserEntity getUserById(@PathVariable("id") int id) {
    return tribeService.getUserById(id);
  }*/
