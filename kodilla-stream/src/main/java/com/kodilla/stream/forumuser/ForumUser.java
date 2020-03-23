package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final char gender;
    private final LocalDate birthDate;
    private final int postsCount;

    public ForumUser(int userId, char gender, LocalDate birthDate, int postsCount) {
        this.userId = userId;
        this.gender = gender;
        this.birthDate = birthDate;
        this.postsCount = postsCount;
    }

    public int getUserId() {
        return userId;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", postsCount=" + postsCount +
                '}';
    }
}

