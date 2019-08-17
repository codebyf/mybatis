package com.byf.domain;


import java.util.List;

public class QueryVO {
    private User user;
    private List<Integer> ids;


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

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
