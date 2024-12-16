package org.food.donation.model;

public class User {
    private String address;
    private String name;
    private String contactNumber;
    private String password;


    public User( String address, String name, String contactNumber, String password){
        this.address = address;
        this.name = name;
        this.contactNumber = contactNumber;
        this.password = password;
    }

    public User() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(int id) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User: " + name + ", Contact: " + contactNumber + ", Password: " + password;
    }
}