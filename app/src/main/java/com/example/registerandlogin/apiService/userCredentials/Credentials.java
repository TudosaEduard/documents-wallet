package com.example.registerandlogin.apiService.userCredentials;

public class Credentials {
    private static Long userId;
    private static String firstName;

    public static Long getUserId() {
        return userId;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setUserId(Long userId) {
        Credentials.userId = userId;
    }

    public static void setFirstName(String firstName) {
        Credentials.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    }
}
