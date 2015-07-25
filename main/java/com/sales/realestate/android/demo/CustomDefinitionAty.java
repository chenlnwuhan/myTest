package com.sales.realestate.android.demo;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sales.realestate.android.GlobalVarible;
import com.sales.realestate.android.R;
import com.sales.realestate.android.bean.CustomInfo;
import com.sales.realestate.android.bean.SpinnerItemInfo;
import com.sales.realestate.android.bean.ToDoListInfo;
import com.sales.realestate.android.view.adapter.ActionBarSpinnerAdapter;
import com.sales.realestate.android.view.adapter.ListAdapterCustomDefinition;
import com.sales.realestate.android.view.adapter.ListAdapterTodoList;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.utils.StringUtils;

import java.util.ArrayList;

/**
 * Created by cc on 2015/7/24.
 */
public class CustomDefinitionAty extends KJActivity {
    @BindView(id = R.id.title_image_left, click = true)
    private ImageView titleImageLeft;
    @BindView(id = R.id.listview_mail)
    PullToRefreshListView mListView;
    @BindView(id = R.id.title_name)
    public TextView textViewTitle;


    public ArrayList<CustomInfo> listViewList = new ArrayList<CustomInfo>();

    public ListAdapterCustomDefinition adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.CUSTOMTITILE);
        setTitileResId(R.layout.view_title_simple);
        setRootViewResId(R.layout.aty_custom_definition);
        setmBottomNavigation(BottomNavigation.NOBOTTOM);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initData() {
        super.initData();

        listViewList = GlobalVarible.getCUSTOM_ANALYSE_LIST();
        adapterList = new ListAdapterCustomDefinition(listViewList);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        textViewTitle.setText("客户界定");
        initListView();
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.title_image_left:
                onBackPressed();
                break;
        }
    }

    private class FinishRefresh extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mListView.onRefreshComplete();
        }
    }

    public void initListView() {
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                Toast.makeText(CustomDefinitionAty.this, "onPullDownToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterList.notifyDataSetChanged();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                Toast.makeText(CustomDefinitionAty.this, "onPullUpToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterList.notifyDataSetChanged();

            }
        });

        mListView.setAdapter(adapterList);
    }
}
