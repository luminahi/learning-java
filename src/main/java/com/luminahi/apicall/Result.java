package com.luminahi.apicall;

public class Result {
    InnerResult result;

    public class InnerResult {
        
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private int courseId; 

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public int getCourseId() {
            return courseId;
        }

    }
}
