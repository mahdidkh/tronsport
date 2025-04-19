package com.gestion.tronsport.dto;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // For backward compatibility
    public String getFullName() {
        return name;
    }

    public void setFullName(String fullName) {
        this.name = fullName;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + (password != null ? "[PROTECTED]" : "null") + '\'' +
                ", confirmPassword='" + (confirmPassword != null ? "[PROTECTED]" : "null") + '\'' +
                '}';
    }
}
