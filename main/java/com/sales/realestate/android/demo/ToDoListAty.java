package com.sales.realestate.android.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sales.realestate.android.R;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

/**
 * Created by cc on 2015/7/24.
 */
public class ToDoListAty extends KJActivity {
    @BindView(id = R.id.title_image_left, click = true)
    private ImageView titleImageLeft;
    @BindView(id = R.id.title_name)
    public TextView textViewTitle;

    /**
     * 代办跳转控件表
     */
    @BindView(id = R.id.img_todolist_customdistribution_next, click = true)
    private RelativeLayout img_todolist_customdistribution_next;
    @BindView(id = R.id.img_todolist_customseeapply_next, click = true)
    private RelativeLayout img_todolist_customseeapply_next;
    @BindView(id = R.id.img_todolist_customform_next, click = true)
    private RelativeLayout img_todolist_customform_next;
    @BindView(id = R.id.img_todolist_custombuy_next, click = true)
    private RelativeLayout img_todolist_custombuy_next;
    @BindView(id = R.id.img_todolist_customdone_next, click = true)
    private RelativeLayout img_todolist_customdone_next;
    @BindView(id = R.id.img_todolist_saleform_next, click = true)
    private RelativeLayout img_todolist_saleform_next;
    @BindView(id = R.id.img_todolist_salebuy_next, click = true)
    private RelativeLayout img_todolist_salebuy_next;
    @BindView(id = R.id.img_todolist_saledone_next, click = true)
    private RelativeLayout img_todolist_saledone_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.CUSTOMTITILE);
        setTitileResId(R.layout.view_title_simple);
        setRootViewResId(R.layout.aty_todolist);
        setmBottomNavigation(BottomNavigation.NOBOTTOM);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initWidget() {
        super.initWidget();
        textViewTitle.setText("代办事项");
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.img_todolist_customdistribution_next:
                bundle.putString("todoListType", "0");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.img_todolist_customseeapply_next:
                bundle.putString("todoListType", "1");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.img_todolist_customform_next:
                bundle.putString("todoListType", "2");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.img_todolist_custombuy_next:
                bundle.putString("todoListType", "3");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.img_todolist_customdone_next:
                bundle.putString("todoListType", "4");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.img_todolist_saleform_next:
                bundle.putString("todoListType", "5");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.img_todolist_salebuy_next:
                bundle.putString("todoListType", "6");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.img_todolist_saledone_next:
                bundle.putString("todoListType", "7");
                this.showActivity(this, ToDoListDetailAty.class, bundle);
                break;
            case R.id.title_image_left:
                onBackPressed();
                break;

        }
    }
}
