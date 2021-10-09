package com.example.demoOnlineProductDeliveryManagement.entity;

public class UserInput {
    public UserInput(String firstName ,String lastName,String userName,String pass){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=pass;
    }
    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
