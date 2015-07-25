package com.sales.realestate.android.demo;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sales.realestate.android.GlobalVarible;
import com.sales.realestate.android.R;
import com.sales.realestate.android.bean.CustomInfo;
import com.sales.realestate.android.bean.SpinnerItemInfo;
import com.sales.realestate.android.ifs.GroupViewIFS;
import com.sales.realestate.android.view.adapter.ActionBarSpinnerAdapter;
import com.sales.realestate.android.view.adapter.ListAdapterCustom;
import com.sales.realestate.android.view.popupwindow.CustomDistributionPW;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.utils.StringUtils;

import java.util.ArrayList;

/**
 * Created by chenlin on 2015/7/20.
 */
public class CustomAty extends KJActivity {
    @BindView(id = R.id.tilte_image_right, click = true)
    private ImageView titleImageRight;
    @BindView(id = R.id.title_name)
    public TextView textViewTitle;
    @BindView(id = R.id.title_linerlayout, click = true)
    LinearLayout linearLayoutTitle;
    @BindView(id = R.id.title_center_location)
    LinearLayout linearLayoutTitleCenterLocation;





    @BindView(id = R.id.textview_custom_selectnum)
    public TextView textview_custom_selectnum;

    @BindView(id = R.id.listview_mail)
    PullToRefreshListView mListView;

    private PopupWindow popupTitleDropDown = null;
    private ListView listViewPopupTitle;

    public ArrayList<CustomInfo> listViewCustomList = new ArrayList<CustomInfo>();
    public ArrayList<SpinnerItemInfo> listViewTitleList = new ArrayList<SpinnerItemInfo>();
    public ActionBarSpinnerAdapter adapterTitleList;
    public ListAdapterCustom adapterCustomList;

    public CustomDistributionPW mCustomDistributionPW ;
    @BindView(id = R.id.textview_custom_first, click = true)
    public TextView textview_custom_first;


    @BindView(id = R.id.bottom_menu_layout_home, click = true)
    public LinearLayout navigationHome;
    @BindView(id = R.id.bottom_menu_layout_custom, click = true)
    public LinearLayout navigationCustom;
    @BindView(id = R.id.bottom_menu_layout_sale, click = true)
    public LinearLayout navigationSale;
    @BindView(id = R.id.bottom_menu_layout_table, click = true)
    public LinearLayout navigationTable;
    @BindView(id = R.id.bottom_menu_layout_more, click = true)
    public LinearLayout navigationMore;
    @BindView(id = R.id.bottom_menu_img_custom)
    public ImageView navagationImgCustom;
    @BindView(id = R.id.bottom_menu_text_custom)
    public TextView navagationTextCustom;

    public ArrayList<String> selectCustomIds = new ArrayList<String>();

    public GroupViewIFS mGroupViewIFS = new GroupViewIFS() {
        @Override
        public void itemOnCheck(int Position) {
            String checkId = listViewCustomList.get(Position).id;

            selectCustomIds.add(checkId);
            textview_custom_selectnum.setText("已选:" + selectCustomIds.size() + "人");

        }

        @Override
        public void itemUnCheck(int Position) {
            String unCheckId = listViewCustomList.get(Position).id;
            for(int i=0;i<selectCustomIds.size();i++){
                if(unCheckId.equals(selectCustomIds.get(i))){
                    selectCustomIds.remove(i);
                    i--;
                }
            }
            textview_custom_selectnum.setText("已选:" + selectCustomIds.size()+"人");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.CUSTOMTITILE);
        setTitileResId(R.layout.view_title_right_button);
        setRootViewResId(R.layout.aty_custom);
        setmBottomNavigation(BottomNavigation.NOSCROLL);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initBottomNavagation() {
        navagationImgCustom.setImageResource(R.drawable.pic_bottom_custom_foucs);
        navagationTextCustom.setTextColor(this.getResources().getColor(R.color.bottom_navigation_text_color_foucs));
    }

    @Override
    public void initWidget() {
        super.initWidget();

        initListView();
        initTitle(0);
        initTitlePopup();
    }

    @Override
    public void initData() {
        super.initData();

        listViewCustomList = GlobalVarible.getCUSTOM_ANALYSE_LIST();
        adapterCustomList = new ListAdapterCustom(listViewCustomList);
        adapterCustomList.adapterType = 0 ;
        adapterCustomList.mGroupViewIFS = mGroupViewIFS;

        listViewTitleList = GlobalVarible.getTITLE_CUSTOM_LIST();
        adapterTitleList = new ActionBarSpinnerAdapter(listViewTitleList);
        GlobalVarible.initTitleListFocus(listViewTitleList, -1, 0);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.title_linerlayout:
                adapterTitleList.notifyDataSetChanged();
                popupTitleDropDown.showAsDropDown(linearLayoutTitleCenterLocation, 0, -5);
                break;
            case R.id.bottom_menu_layout_home:
                showActivity(this, MainActivity.class);
                break;
            case R.id.textview_custom_first:
                if(mCustomDistributionPW == null){
                    mCustomDistributionPW = new CustomDistributionPW(this);
                }
                mCustomDistributionPW.showAtLocation(this.getCurrentFocus(), Gravity.CENTER, 0, 0);


                mCustomDistributionPW.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                    }
                });
                break;


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String data = bundle.getString("customType");
            if(!StringUtils.isEmpty(data)){
                int type =  Integer.valueOf(data);
                initTitle(type);
                GlobalVarible.initTitleListFocus(listViewTitleList, -1, type);
            }
        }

    }

    public void initTitle(int pozition) {
        textViewTitle.setText(listViewTitleList.get(pozition).getName());
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
                Toast.makeText(CustomAty.this, "onPullDownToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterCustomList.notifyDataSetChanged();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                Toast.makeText(CustomAty.this, "onPullUpToRefresh", Toast.LENGTH_LONG).show();
                new FinishRefresh().execute();
                adapterCustomList.notifyDataSetChanged();

            }
        });

        mListView.setAdapter(adapterCustomList);
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
