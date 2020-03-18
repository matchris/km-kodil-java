package com.kodilla.testing.forum.statistics;

public class AdvForumStatistics {
    Statistics statistics;
    private double usersNumber;
    private double postsNumber;
    private double commentsNumber;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public double getUsersNumber() {
        return usersNumber;
    }

    public double getPostsNumber() {
        return postsNumber;
    }

    public double getCommentsNumber() {
        return commentsNumber;
    }

    void calculateAdvStatistics(Statistics statistics) {
        this.usersNumber = statistics.userNames().size();
        this.postsNumber = statistics.postCount();
        this.commentsNumber = statistics.commentsCount();

        if (usersNumber == 0) {
            this.avgPostsPerUser = 0;
            this.avgCommentsPerUser = 0;

        } else {
            avgPostsPerUser = postsNumber / usersNumber;
            avgCommentsPerUser = commentsNumber / usersNumber;
        }

        if (postsNumber == 0) {
            avgCommentsPerPost = 0;
        } else {
            avgCommentsPerPost = commentsNumber / postsNumber;
        }
    }

    public void showStatistics() {
        System.out.println("Forum advanced statistics: \n" + "Users number: " + usersNumber + "\nPosts number: " +
                postsNumber + "\nComments number: " + commentsNumber + "\nAverage posts per user: " + avgPostsPerUser +
                "\nAverage comments per user: " + avgCommentsPerUser + "\nAverage comments per post: " +
                avgCommentsPerPost);
    }

}
