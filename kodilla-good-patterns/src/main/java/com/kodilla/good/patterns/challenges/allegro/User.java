package com.kodilla.good.patterns.challenges.allegro;

import java.util.Objects;

public class User {

    private String firstName;
    private String surname;
    private String userName;
    private String email;

    public User(String firstName, String surname, String userName, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.userName = userName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, userName, email);
    }
}