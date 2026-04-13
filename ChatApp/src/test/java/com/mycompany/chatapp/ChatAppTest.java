package com.mycompany.chatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChatAppTest {

    // TEST USERNAME VALIDATION
    @Test
    public void testValidUsername() {
        Register user = new Register("John", "Doe", "john_doe", "Pass123!", "+27123456789");
        assertTrue(user.checkUsername());
    }

    @Test
    public void testInvalidUsername() {
        Register user = new Register("John", "Doe", "johndoe", "Pass123!", "+27123456789");
        assertFalse(user.checkUsername());
    }

    // TEST PASSWORD VALIDATION
    @Test
    public void testValidPassword() {
        Register user = new Register("John", "Doe", "john_doe", "Pass123!", "+27123456789");
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPassword() {
        Register user = new Register("John", "Doe", "john_doe", "pass", "+27123456789");
        assertFalse(user.checkPasswordComplexity());
    }

    // TEST CELLPHONE VALIDATION
    @Test
    public void testValidCellphone() {
        Register user = new Register("John", "Doe", "john_doe", "Pass123!", "+27123456789");
        assertTrue(user.checkCellphoneNumber());
    }

    @Test
    public void testInvalidCellphone() {
        Register user = new Register("John", "Doe", "john_doe", "Pass123!", "0123456789");
        assertFalse(user.checkCellphoneNumber());
    }

    // TEST REGISTRATION
    @Test
    public void testSuccessfulRegistration() {
        Register user = new Register("John", "Doe", "john_doe", "Pass123!", "+27123456789");
        String result = user.registerUser();
        assertEquals("User successfully registered!", result);
    }

    // TEST LOGIN SUCCESS
    @Test
    public void testLoginSuccess() {
        Register user = new Register("John", "Doe", "john_doe", "Pass123!", "+27123456789");
        user.registerUser();

        Login login = new Login(user);
        String result = login.returnLoginStatus("john_doe", "Pass123!");

        assertTrue(result.contains("Welcome"));
    }

    // TEST LOGIN FAILURE
    @Test
    public void testLoginFailure() {
        Register user = new Register("John", "Doe", "john_doe", "Pass123!", "+27123456789");
        user.registerUser();

        Login login = new Login(user);
        String result = login.returnLoginStatus("john_doe", "wrongPass");

        assertFalse(result.contains("Welcome"));
    }
}