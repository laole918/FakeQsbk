package com.laole918.fakeqsbk.http;

/**
 * Created by laole918 on 2016/1/3.
 */
public class Page {

    private int page = 0;
    private int count = 30;

    protected void nextPage() {
        this.page ++;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
