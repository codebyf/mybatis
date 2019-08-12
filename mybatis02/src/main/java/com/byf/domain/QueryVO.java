package com.byf.domain;


public class QueryVO {
    private User user;

    public User getUser() {
        /*try {
            return (User) user.deepClone();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
