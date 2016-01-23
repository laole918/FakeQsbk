package com.laole918.fakeqsbk.widget;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.laole918.fakeqsbk.R;
import com.laole918.fakeqsbk.model.Article;
import com.laole918.fakeqsbk.model.User;
import com.laole918.fakeqsbk.utils.ImageLoaderUtils;
import com.laole918.fakeqsbk.utils.ImageUtils;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by laole918 on 2016/1/2.
 */
@EViewGroup(R.layout.layout_article_item)
public class ArticleItemView extends LinearLayout {

    @ViewById
    ImageView icon;
    @ViewById
    TextView login, content;

    public ArticleItemView(Context context) {
        super(context);
    }

    public void bindData(Article a) {
        User u = a.getUser();
        if(u != null) {
            String name = u.getLogin();
            login.setText(name);
            String uri = ImageUtils.getUserIconUri(u);
            ImageLoaderUtils.displayImage(uri, icon);
        }
        String text = a.getContent();
        content.setText(text);
    }
}
