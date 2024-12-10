package org.food.donation.model;

public class NGO {
    private int id;
    private String name;
    private String address;
    private String contact;
    private String username; // For login
    private String password; // For login

    public NGO(int id, String name, String address, String contact, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.username = username;
        this.password = password;
    }

    public NGO(String number, String texasHelpCenter, String texas, String texasHelp, String pass123) {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(int id) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String name) {
        this.contact = contact;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String name) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String name) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NGO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", username='" + password + '\'' +
                '}';
    }
}



