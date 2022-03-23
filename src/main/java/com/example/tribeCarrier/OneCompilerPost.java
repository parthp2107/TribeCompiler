package com.example.tribeCarrier;

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
import java.util.List;

@RestController()
public class OneCompilerPost {

  @Autowired
  TribeService tribeService;

  @GetMapping("/users")
  private List<TribeUserLogin> getUser() {
    return tribeService.getLoggedInUser();
  }

  @GetMapping("/users/{id}")
  private TribeUserLogin getUserById(@PathVariable("id") int id)
  {
    return tribeService.getUserById(id);
  }

  @PostMapping("/addUser")
  private int getUserById(@RequestBody TribeUserLogin tribeUserLogin) throws Exception {
      tribeService.addUser(tribeUserLogin);
      return tribeUserLogin.getUserId();
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
