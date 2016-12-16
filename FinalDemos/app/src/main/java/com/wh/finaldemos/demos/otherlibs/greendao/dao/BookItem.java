package com.wh.finaldemos.demos.otherlibs.greendao.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wanghui on 16-12-15.
 */

@Entity(nameInDb = "book_items")
public class BookItem {

    private String publisher;

    private String UUcode;

    @org.greenrobot.greendao.annotation.Id
    private Long Id;

    private String name;

    private String coverUrl;

    private String description;

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


    @Generated(hash = 547731123)
    public BookItem() {
    }

    @Generated(hash = 1163953218)
    public BookItem(String publisher, String UUcode, Long Id, String name,
            String coverUrl, String description) {
        this.publisher = publisher;
        this.UUcode = UUcode;
        this.Id = Id;
        this.name = name;
        this.coverUrl = coverUrl;
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUUcode() {
        return UUcode;
    }

    public void setUUcode(String UUcode) {
        this.UUcode = UUcode;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "publisher='" + publisher + '\'' +
                ", UUcode='" + UUcode + '\'' +
                ", Id=" + Id +
                ", name='" + name + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
