package com.sales.realestate.android.view.popupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.sales.realestate.android.GlobalVarible;
import com.sales.realestate.android.R;
import com.sales.realestate.android.bean.CustomInfo;
import com.sales.realestate.android.bean.PropertyConsultant;
import com.sales.realestate.android.view.adapter.GridViewAdapterCustom;

import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;

/**
 * Created by cc on 2015/7/23.
 */
public class CustomDistributionPW extends PopupWindow {
    private View conentView;

    public CustomDistributionPW(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.popup_custom_distribution, null);
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);

        initPopUpWindows();
        initView();

        // 刷新状态
        this.update();
    }

    public void initPopUpWindows(){
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);

        //在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        this.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    public void initView(){
        PullToRefreshGridView gridview_custom = (PullToRefreshGridView) conentView.findViewById(R.id.gridview_custom);
        ArrayList<PropertyConsultant> mPropertyConsultantList = new ArrayList<PropertyConsultant>();
        mPropertyConsultantList = GlobalVarible.getPROPERTY_CONSULTANT_LIST();
        GridViewAdapterCustom mGridViewAdapterCustom = new GridViewAdapterCustom(mPropertyConsultantList);
        gridview_custom.setMode(PullToRefreshBase.Mode.BOTH);
        gridview_custom.setAdapter(mGridViewAdapterCustom);
        gridview_custom.getRefreshableView().setNumColumns(4);
        TextView textview_custom_distribution_cancel = (TextView) conentView.findViewById(R.id.textview_custom_distribution_cancel);
        TextView textview_custom_distribution_ok = (TextView) conentView.findViewById(R.id.textview_custom_distribution_ok);
        textview_custom_distribution_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDistributionPW.this.dismiss();
            }
        });
        textview_custom_distribution_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDistributionPW.this.dismiss();
            }
        });
    }
}
