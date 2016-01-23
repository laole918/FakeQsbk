package com.laole918.fakeqsbk.model;

public class User{

    private String icon;
    private String role;
    private int last_visited_at;
    private int avatar_updated_at;
    private int id;
    private String state;
    private String last_device;
    private int created_at;
    private String login;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getLast_visited_at() {
        return last_visited_at;
    }

    public void setLast_visited_at(int last_visited_at) {
        this.last_visited_at = last_visited_at;
    }

    public int getAvatar_updated_at() {
        return avatar_updated_at;
    }

    public void setAvatar_updated_at(int avatar_updated_at) {
        this.avatar_updated_at = avatar_updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLast_device() {
        return last_device;
    }

    public void setLast_device(String last_device) {
        this.last_device = last_device;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}