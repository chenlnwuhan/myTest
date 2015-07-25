package com.sales.realestate.android.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.sales.realestate.android.GlobalVarible;
import com.sales.realestate.android.R;
import com.sales.realestate.android.bean.CustomInfo;
import com.sales.realestate.android.view.adapter.ListAdapterCustom;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;

/**
 * Created by cc on 2015/7/23.
 */
public class AddresListAty extends KJActivity {

    @BindView(id = R.id.title_image_left, click = true)
    private ImageView titleImageLeft;
    @BindView(id = R.id.listview_mail)
    PullToRefreshExpandableListView mListView;
    @BindView(id = R.id.title_name)
    public TextView textViewTitle;

    public ArrayList<CustomInfo> listViewCustomList = new ArrayList<CustomInfo>();
    public ListAdapterCustom adapterCustomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.CUSTOMTITILE);
        setTitileResId(R.layout.view_title_simple);
        setRootViewResId(R.layout.aty_addres_list);
        setmBottomNavigation(BottomNavigation.NOBOTTOM);
        super.onCreate(savedInstanceState);
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

    @Override
    public void initData() {
        super.initData();

        listViewCustomList = GlobalVarible.getCUSTOM_ANALYSE_LIST();
        adapterCustomList = new ListAdapterCustom(listViewCustomList);
        adapterCustomList.adapterType = 0;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        textViewTitle.setText("通讯录");
        initListView();

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
                Toast.makeText(AddresListAty.this, "onPullDownToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterCustomList.notifyDataSetChanged();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                Toast.makeText(AddresListAty.this, "onPullUpToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterCustomList.notifyDataSetChanged();

            }
        });

        mListView.setAdapter(adapterCustomList);
    }
}
