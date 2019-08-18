package com.mycompany.login;

import java.util.Map;

public class LoginController {

  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  private static final String RESULT = "result";
  private static final String VALID = "Login successful";
  private static final String INVALID = "Username or password invalid";
  private static final Map<String, String> NAME_TO_PASSWORD = 
      Map.of("paul", "12345");

  public static Map<String, String> validateCredentials(Map<String, Object> payload) {
    Object username = payload.get(USERNAME);
    Object password = payload.get(PASSWORD);
    
    if (password.equals(NAME_TO_PASSWORD.get(username))) {
        return Map.of(RESULT, VALID);
    }
    return Map.of(RESULT, INVALID);
  }
}
