package com.laole918.fakeqsbk.model;

import java.util.List;

public class Article {

    private String content;
    private String low_url;
    private int published_at;
    private String format;
    private int id;
    private String high_url;
    private String state;
    private int share_count;
    private int created_at;
    private String type;
    private ImageSize image_size;
    private User user;
    private boolean allow_comment;
    private String pic_url;
    private int comments_count;
    private int loop;
    private List<Integer> pic_sizes;
    private String image;
    private Vote votes;
    private String tag;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLow_url() {
        return low_url;
    }

    public void setLow_url(String low_url) {
        this.low_url = low_url;
    }

    public int getPublished_at() {
        return published_at;
    }

    public void setPublished_at(int published_at) {
        this.published_at = published_at;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHigh_url() {
        return high_url;
    }

    public void setHigh_url(String high_url) {
        this.high_url = high_url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImageSize getImage_size() {
        return image_size;
    }

    public void setImage_size(ImageSize image_size) {
        this.image_size = image_size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAllow_comment() {
        return allow_comment;
    }

    public void setAllow_comment(boolean allow_comment) {
        this.allow_comment = allow_comment;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public List<Integer> getPic_sizes() {
        return pic_sizes;
    }

    public void setPic_sizes(List<Integer> pic_sizes) {
        this.pic_sizes = pic_sizes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Vote getVotes() {
        return votes;
    }

    public void setVotes(Vote votes) {
        this.votes = votes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}