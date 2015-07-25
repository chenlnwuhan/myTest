package com.sales.realestate.android.bean;

/**
 * Created by chenlin on 2015/7/12.
 */
public class SpinnerItemInfo {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isCurrent = false;

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    private String id ;
        private String name ;
}
