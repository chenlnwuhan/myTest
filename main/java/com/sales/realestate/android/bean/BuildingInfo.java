package com.sales.realestate.android.bean;

import org.kymjs.kjframe.database.annotate.Id;

/**
 * Created by chenlin on 2015/7/12.
 */
public class BuildingInfo {

    @Id()
    private String id;
    private String name;
    private String others;

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {

        return id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }


}
