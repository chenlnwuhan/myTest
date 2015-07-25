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
 * Created by chenlin on 2015/7/21.
 */
public class CustomAnalyseAty extends KJActivity {

    @BindView(id = R.id.title_image_left, click = true)
    private ImageView titleImageLeft;
    @BindView(id = R.id.title_name)
    public TextView textViewTitle;

    @BindView(id = R.id.textview_custom_analysic_youxiao)
    public TextView textview_custom_analysic_youxiao;
    @BindView(id = R.id.textview_custom_analysic_wuxiao)
    public TextView textview_custom_analysic_wuxiao;
    @BindView(id = R.id.textview_custom_analysic_daofang)
    public TextView textview_custom_analysic_daodang;
    @BindView(id = R.id.textview_custom_analysic_liushi)
    public TextView textview_custom_analysic_liushi;

    @BindView(id = R.id.img_custom_analysic_youxiao_next, click = true)
    private RelativeLayout img_custom_analysic_youxiao_next;
    @BindView(id = R.id.img_custom_analysic_wuxiao_next, click = true)
    private RelativeLayout img_custom_analysic_wuxiao_next;
    @BindView(id = R.id.img_custom_analysic_daofang_next, click = true)
    private RelativeLayout img_custom_analysic_daofang_next;
    @BindView(id = R.id.img_custom_analysic_liushi_next, click = true)
    private RelativeLayout img_custom_analysic_liushi_next;

    private String numberYouXiao;
    private String numberWuXiao;
    private String numberDaoFang;
    private String numberLiuSHI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.CUSTOMTITILE);
        setTitileResId(R.layout.view_title_simple);
        setRootViewResId(R.layout.aty_custom_analysis);
        setmBottomNavigation(BottomNavigation.NOBOTTOM);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.img_custom_analysic_youxiao_next:
                bundle.putString("customType", "0");
                this.showActivity(this, CustomAnalyseDetailAty.class, bundle);
                break;
            case R.id.img_custom_analysic_wuxiao_next:
                bundle.putString("customType", "1");
                this.showActivity(this, CustomAnalyseDetailAty.class, bundle);
                break;
            case R.id.img_custom_analysic_daofang_next:
                bundle.putString("customType", "2");
                this.showActivity(this, CustomAnalyseDetailAty.class, bundle);
                break;
            case R.id.img_custom_analysic_liushi_next:
                bundle.putString("customType", "3");
                this.showActivity(this, CustomAnalyseDetailAty.class, bundle);
                break;
            case R.id.title_image_left:
                onBackPressed();
                break;
        }
    }

    @Override
    public void initData() {
        super.initData();

        numberYouXiao = "123/568";
        numberWuXiao = "123/568";
        numberDaoFang = "123/568";
        numberLiuSHI = "123/568";
    }

    @Override
    public void initWidget() {
        super.initWidget();
        textViewTitle.setText("客户分析");

    }
}
