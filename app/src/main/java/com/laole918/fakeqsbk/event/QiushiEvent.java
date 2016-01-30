package com.laole918.fakeqsbk.event;

import com.laole918.fakeqsbk.model.Article;

import java.util.List;

/**
 * Created by laole918 on 2016/1/30.
 */
public class QiushiEvent {

    public static class Event {

        private String errorMsg;
        private List<Article> as;

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public boolean isError() {
            if(as == null) {
                return true;
            }
            return false;
        }

        public void setAs(List<Article> as) {
            this.as = as;
        }

        public List<Article> getAs() {
            return as;
        }
    }



    public static class SuggestEvent extends Event  {

    }
}
