package com.mycompany.chatapp;

import java.util.regex.Pattern;

public class Register {

    private String username;
    private String password;
    private String cellphoneNumber;
    private String firstName;
    private String lastName;

    public Register(String firstName, String lastName, String username, String password, String cellphoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellphoneNumber = cellphoneNumber;
    }

    public boolean checkUsername() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellphoneNumber() {
      if (cellphoneNumber.startsWith("0") && cellphoneNumber.length() == 10) {
          cellphoneNumber = "+27" + cellphoneNumber.substring(1);
      }
      
      if (cellphoneNumber.matches ("\\+27\\d{9}")) {
          this.cellphoneNumber = cellphoneNumber;
          return true;
      }
      return false;
    }

    public String registerUser() {
        if (!checkUsername()) {
            return "Invalid username.";
        }
        if (!checkPasswordComplexity()) {
            return "Incorrect password.";
        }
        if (!checkCellphoneNumber()) {
            return "Invalid cellphone number.";
        }
        return "User successfully registered!";
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}