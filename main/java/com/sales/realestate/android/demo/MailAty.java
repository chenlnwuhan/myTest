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
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sales.realestate.android.GlobalVarible;
import com.sales.realestate.android.R;
import com.sales.realestate.android.bean.MailInfo;
import com.sales.realestate.android.bean.SpinnerItemInfo;
import com.sales.realestate.android.view.adapter.ActionBarSpinnerAdapter;
import com.sales.realestate.android.view.adapter.ListAdapterMail;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;

/**
 * Created by chenlin on 2015/7/20.
 */
public class MailAty extends KJActivity {

    @BindView(id = R.id.title_image_left, click = true)
    private ImageView titleImageLeft;
    @BindView(id = R.id.listview_mail)
    PullToRefreshListView mListView;
    @BindView(id = R.id.title_name)
    public TextView textViewTitle;

    @BindView(id = R.id.title_linerlayout, click = true)
    LinearLayout linearLayoutTitle;

    @BindView(id = R.id.title_center_location)
    LinearLayout linearLayoutTitleCenterLocation;

    private PopupWindow popupTitleDropDown = null;
    private ListView listViewPopupTitle;
    public ArrayList<MailInfo> listViewMailList = new ArrayList<MailInfo>();
    public ArrayList<SpinnerItemInfo> listViewTitleList = new ArrayList<SpinnerItemInfo>();

    public ListAdapterMail adapterMailList;
    public ActionBarSpinnerAdapter adapterTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.CUSTOMTITILE);
        setTitileResId(R.layout.view_title_left_button);
        setRootViewResId(R.layout.aty_mail);
        setmBottomNavigation(BottomNavigation.NOBOTTOM);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.title_linerlayout:
                adapterTitleList.notifyDataSetChanged();
                popupTitleDropDown.showAsDropDown(linearLayoutTitleCenterLocation, 0, -5);
                break;
            case R.id.title_image_left:
                onBackPressed();
                break;
        }
    }

    @Override
    public void initData() {
        super.initData();

        listViewMailList = GlobalVarible.getMAIL_LIST();
        adapterMailList = new ListAdapterMail(listViewMailList);

        listViewTitleList = GlobalVarible.getTITLE_MAIL_LIST();
        adapterTitleList = new ActionBarSpinnerAdapter(listViewTitleList);
        GlobalVarible.initTitleListFocus(listViewTitleList, -1, 0);
    }

    public void initTitle(int pozition) {
        textViewTitle.setText(listViewTitleList.get(pozition).getName());
    }

    @Override
    public void initWidget() {
        super.initWidget();
        initTitle(0);
        initListView();
        initTitlePopup();

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
        
        mListView.setOnRefreshListener(new OnRefreshListener2() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                Toast.makeText(MailAty.this, "onPullDownToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterMailList.notifyDataSetChanged();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                Toast.makeText(MailAty.this, "onPullUpToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterMailList.notifyDataSetChanged();

            }
        });

        mListView.setAdapter(adapterMailList);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                if((position-1)>0)position--;
                bundle.putString("mailId", listViewMailList.get(position).id);
                MailAty.this.showActivity(MailAty.this, MailDetailAty.class, bundle);
            }
        });
    }

    public void initTitlePopup() {
        listViewPopupTitle = new ListView(this);
        listViewPopupTitle.setDivider(null);
        listViewPopupTitle.setSelector(new ColorDrawable(Color.TRANSPARENT));
        listViewPopupTitle.setCacheColorHint(Color.TRANSPARENT);
        listViewPopupTitle.setDividerHeight(1);
        listViewPopupTitle.setVerticalScrollBarEnabled(false);
        listViewPopupTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                initTitle(position);
                GlobalVarible.initTitleListFocus(listViewTitleList, -1, position);
                popupTitleDropDown.dismiss();
            }
        });
        listViewPopupTitle.setAdapter(adapterTitleList);
        popupTitleDropDown = new PopupWindow(listViewPopupTitle, (int) getResources().getDimension(R.dimen.title_spinner_item_width), ActionBar.LayoutParams.WRAP_CONTENT, true);
        popupTitleDropDown.setBackgroundDrawable(new BitmapDrawable());
        popupTitleDropDown.setOutsideTouchable(true);
    }
}
