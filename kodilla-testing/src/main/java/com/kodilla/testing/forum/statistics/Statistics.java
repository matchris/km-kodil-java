package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    List<String> userNames(); //list of users names
    int postCount();
    int commentsCount();
}
