package com.laole918.fakeqsbk.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.widget.ArticleItemView;
import com.laole918.fakeqsbk.widget.ArticleItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by laole918 on 2016/1/2.
 */
@EBean
public class ArticleAdapter extends BaseAdapter {

    @RootContext
    Context mContext;

    private List<Article> as = new ArrayList<Article>();

    public void add(Article a) {
        as.add(a);
    }

    public void addAll(Collection<Article> as) {
        this.as.addAll(as);
    }

    public void clear() {
        as.clear();
    }

    @Override
    public int getCount() {
        return as.size();
    }

    @Override
    public Article getItem(int position) {
        return as.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArticleItemView itemView;
        if(convertView == null) {
            itemView = ArticleItemView_.build(mContext);
        } else {
            itemView = (ArticleItemView) convertView;
        }
        Article a = getItem(position);
        itemView.bindData(a);
        return itemView;
    }

}
