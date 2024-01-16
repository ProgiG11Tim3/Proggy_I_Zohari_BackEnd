package com.progiizohari.ozdravi.domain;

public class AdminToolUserEntity {
    private String userJson;
    private String data_link;
    private String edit_link;
    private String delete_link;
    private int user_id;

    public AdminToolUserEntity(String userJson, String data_link, String edit_link, String delete_link, int user_id) {
        this.userJson = userJson;
        this.data_link = data_link;
        this.edit_link = edit_link;
        this.delete_link = delete_link;
        this.user_id = user_id;
    }

    public AdminToolUserEntity() {
    }

    public String getUserJson() {
        return userJson;
    }

    public String getData_link() {
        return data_link;
    }

    public String getEdit_link() {
        return edit_link;
    }

    public String getDelete_link() {
        return delete_link;
    }

    public void setUserJson(String userJson) {
        this.userJson = userJson;
    }

    public void setData_link(String data_link) {
        this.data_link = data_link;
    }

    public void setEdit_link(String edit_link) {
        this.edit_link = edit_link;
    }

    public void setDelete_link(String delete_link) {
        this.delete_link = delete_link;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
