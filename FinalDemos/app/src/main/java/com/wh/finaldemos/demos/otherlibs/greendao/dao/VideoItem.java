package com.wh.finaldemos.demos.otherlibs.greendao.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;

/**
 * Created by wanghui on 16-12-15.
 */

@Entity
public class VideoItem {

    private String director;

    @Transient
    private ArrayList<String> actors;

    @org.greenrobot.greendao.annotation.Id
    private Long Id;

    private String name;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Generated(hash = 807201864)
    public VideoItem(String director, Long Id, String name) {
        this.director = director;
        this.Id = Id;
        this.name = name;
    }

    @Generated(hash = 1427854055)
    public VideoItem() {
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

}
