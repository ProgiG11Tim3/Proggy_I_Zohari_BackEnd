package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Parent;

public class AdminToolParentEntry {
    private Parent parent;
    private String data_link;
    private String edit_link;
    private String delete_link;
    private int user_id;

    public AdminToolParentEntry(Parent parent, String data_link, String edit_link, String delete_link, int user_id) {
        this.parent = parent;
        this.data_link = data_link;
        this.edit_link = edit_link;
        this.delete_link = delete_link;
        this.user_id = user_id;
    }

    public AdminToolParentEntry() {
    }

    public Parent getParent() {
        return parent;
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

           public void setParent(Parent parent) {
                this.parent = parent;
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

        public String toJsonIDs() {
            // build a json with parent.tojsonid
            return "{\"parent\":" + parent.toJsonIDs() + ",\"data_link\":\"" + data_link + "\",\"edit_link\":\"" + edit_link + "\",\"delete_link\":\"" + delete_link + "\",\"user_id\":" + user_id + "}";
        }
}
