package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1, 'M', LocalDate.of(1975, 4, 21), 12));
        forumUserList.add(new ForumUser(2, 'F', LocalDate.of(1981, 12, 11), 32));
        forumUserList.add(new ForumUser(3, 'M', LocalDate.of(1992, 11, 14), 0));
        forumUserList.add(new ForumUser(4, 'F', LocalDate.of(1989, 7, 16), 0));
        forumUserList.add(new ForumUser(5, 'M', LocalDate.of(1999, 2, 26), 9));
        forumUserList.add(new ForumUser(6, 'F', LocalDate.of(2000, 5, 17), 54));
        forumUserList.add(new ForumUser(7, 'M', LocalDate.of(2001, 10, 1), 0));
        forumUserList.add(new ForumUser(8, 'F', LocalDate.of(2004, 7, 6), 0));
        forumUserList.add(new ForumUser(9, 'M', LocalDate.of(1968, 6, 14), 22));
        forumUserList.add(new ForumUser(10, 'F', LocalDate.of(1995, 3, 11), 66));
        forumUserList.add(new ForumUser(11, 'M', LocalDate.of(1999, 9, 9), 12));

    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }
}
