package com.mycompany.login;

import java.util.Map;

public class LoginController {

  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  private static final String VALID = "Login successful";
  private static final String INVALID = "Username or password invalid";
  private static final Map<String, String> NAME_TO_PASSWORD = 
      Map.of("paul", "12345");

  private String username;
  private String password;

  public LoginController(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public LoginResult validateCredentials() {
    // Object username = payload.get(USERNAME);
    // Object password = payload.get(PASSWORD);
    
    if (password.equals(NAME_TO_PASSWORD.get(username))) {
        return LoginResult.VALID_RESULT;
    }
    return LoginResult.INVALID_RESULT;
  }

  public static class LoginResult {
    private static final LoginResult VALID_RESULT = new LoginResult(VALID);
    private static final LoginResult INVALID_RESULT = new LoginResult(INVALID);
   
    private String result;
    
    public LoginResult(String validity) {
      this.result = validity;
    }

    // Getter required for Spring Boot to convert POJO to JSON for HTTP response
    public String getResult() {
      return result;
    }
  }
}
