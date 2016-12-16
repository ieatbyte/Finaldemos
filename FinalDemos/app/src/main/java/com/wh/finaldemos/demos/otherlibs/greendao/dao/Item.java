package com.wh.finaldemos.demos.otherlibs.greendao.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wanghui on 16-12-15.
 */

@Entity
public class Item {

    @org.greenrobot.greendao.annotation.Id
    private long Id;

    private String name;

    @Generated(hash = 2124040349)
    public Item(long Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    @Generated(hash = 1470900980)
    public Item() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
