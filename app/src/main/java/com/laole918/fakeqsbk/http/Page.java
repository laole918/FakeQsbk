package com.laole918.fakeqsbk.http;

/**
 * Created by laole918 on 2016/1/3.
 */
public class Page {

    private boolean isDropdown = false;
    private boolean isHasNext = true;

    private int page = 0;
    private int count = 30;

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

    public boolean isDropdown() {
        return isDropdown;
    }

    public void setDropdown(boolean dropdown) {
        isDropdown = dropdown;
    }

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.isHasNext = hasNext;
    }
}
