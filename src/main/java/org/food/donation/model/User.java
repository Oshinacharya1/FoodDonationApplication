package org.food.donation.model;

public class User {
        private String address;
        private String name;
        private String contactNumber;


        public User( String address, String name, String contactNumber){
            this.address = address;
            this.name = name;
            this.contactNumber = contactNumber;
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

        public void setContactNumber(String email) {
            this.contactNumber = contactNumber;
        }

    @Override
    public String toString() {
        return "User: " + name + ", Contact: " + contactNumber;
    }
}
