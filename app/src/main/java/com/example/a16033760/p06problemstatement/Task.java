package com.example.a16033760.p06problemstatement;

import java.io.Serializable;

public class Task implements Serializable {

    int id;
    String tname;
    String desc;

    public Task(int id, String tname, String desc) {
        this.id = id;
        this.tname = tname;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
