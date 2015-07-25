package com.sales.realestate.android.demo;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sales.realestate.android.GlobalVarible;
import com.sales.realestate.android.R;
import com.sales.realestate.android.bean.SpinnerItemInfo;
import com.sales.realestate.android.view.adapter.ActionBarSpinnerAdapter;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;

public class MainActivity extends KJActivity {


    /**
     * 顶部菜单布局文件初始化
     */
    @BindView(id = R.id.title_image_left, click = true)
    private ImageView titleImageLeft;
    @BindView(id = R.id.title_name)
    public TextView textViewTitle;
    @BindView(id = R.id.title_linerlayout, click = true)
    LinearLayout linearLayoutTitle;
    @BindView(id = R.id.title_center_location)
    LinearLayout linearLayoutTitleCenterLocation;

    /**
     * 顶部下拉菜单初始化数据
     */
    private PopupWindow popupTitleDropDown = null;
    private ListView listViewPopupTitle;
    public ArrayList<SpinnerItemInfo> listViewTitleList = new ArrayList<SpinnerItemInfo>();
    public ActionBarSpinnerAdapter adapterTitleList;

    @BindView(id = R.id.home_banner_volume)
    private TextView homeBannerTextView;


    /**
     * 通讯录跳转
     */
    @BindView(id = R.id.linnearlayout_home_addreslist,click = true)
    public LinearLayout linnearlayout_home_addreslist ;

    /**
     * 3个图片跳转
     * 1 客户界定
     * 2 客户分析
     * 3 代办事项
     */
    @BindView(id = R.id.see_analyse_pic, click = true)
    private ImageView imageViewSeeCustomAnalyse;
    @BindView(id = R.id.see_todo_pic, click = true)
    private ImageView see_todo_pic;
    @BindView(id = R.id.see_jieding_pic, click = true)
    private ImageView see_jieding_pic;

    /**
     * 底部导航栏
     */
    @BindView(id = R.id.bottom_menu_layout_home,click = true)
    public LinearLayout navigationHome ;
    @BindView(id = R.id.bottom_menu_layout_custom,click = true)
    public LinearLayout navigationCustom ;
    @BindView(id = R.id.bottom_menu_layout_sale,click = true)
    public LinearLayout navigationSale ;
    @BindView(id = R.id.bottom_menu_layout_table,click = true)
    public LinearLayout navigationTable ;
    @BindView(id = R.id.bottom_menu_layout_more,click = true)
    public LinearLayout navigationMore ;
    /**
     * 导航栏需要高亮的元素
     */
    @BindView(id = R.id.bottom_menu_img_home)
    public ImageView navagationImgHome ;
    @BindView(id = R.id.bottom_menu_text_home)
    public TextView navagationTextHome ;


    /**
     *  4个跳转到客户的layout
     *  1 到访客户
     *  2 来电客户
     *  3 微客户
     *  3 报备客户
     */
    @BindView(id = R.id.see_comming_relativeLayout,click = true)
    public RelativeLayout see_comming_relativeLayout ;
    @BindView(id = R.id.see_phone_relativeLayout,click = true)
    public RelativeLayout see_phone_relativeLayout ;
    @BindView(id = R.id.see_wei_relativeLayout,click = true)
    public RelativeLayout see_wei_relativeLayout ;
    @BindView(id = R.id.see_baobei_relativeLayout,click = true)
    public RelativeLayout see_baobei_relativeLayout ;

    @Override
    public void setRootView() {
        super.setRootView();

//        if (!"org.kymjs.kjframe.demo".equals(getApplication().getPackageName())) {
//            KJActivityStack.create().AppExit(aty);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.CUSTOMTITILE);
        setTitileResId(R.layout.view_title_home);
        setRootViewResId(R.layout.aty_home);
        setmBottomNavigation(BottomNavigation.HOME);

        super.onCreate(savedInstanceState);
    }

    @Override
    public void initBottomNavagation() {
        navagationImgHome.setImageResource(R.drawable.pic_bottom_home_foucs);
        navagationTextHome.setTextColor(this.getResources().getColor(R.color.bottom_navigation_text_color_foucs));
    }

    @Override
    public void initWidget() {
        super.initWidget();
        String w = "成交量   5999  套";
        int start = w.indexOf("5999");
        int end = w.indexOf("5999") + "5999".length();
        Spannable word = new SpannableString(w);
        word.setSpan(new AbsoluteSizeSpan(50), start, end,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        word.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        homeBannerTextView.setText(word);

        initTitle(0);
        initTitlePopup();

    }

    @Override
    public void initData() {
        super.initData();

        listViewTitleList = GlobalVarible.getTITLE_HOME_LIST();
        adapterTitleList = new ActionBarSpinnerAdapter(listViewTitleList);
        GlobalVarible.initTitleListFocus(listViewTitleList, -1, 0);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.title_linerlayout:
                adapterTitleList.notifyDataSetChanged();
                popupTitleDropDown.showAsDropDown(linearLayoutTitleCenterLocation, 0, -5);
                break;
            case R.id.title_image_left:
                showActivity(this, MailAty.class);
                break;
            case R.id.see_analyse_pic:
                showActivity(this,CustomAnalyseAty.class);
                break;
            case R.id.bottom_menu_layout_custom:
                showActivity(this,CustomAty.class);
                break;
            case R.id.linnearlayout_home_addreslist:
                showActivity(this, AddresListAty.class);
                break;
            case R.id.see_comming_relativeLayout:
                bundle.putString("customType", "1");
                this.showActivity(this, CustomAty.class, bundle);
                break;
            case R.id.see_phone_relativeLayout:
                bundle.putString("customType", "0");
                this.showActivity(this, CustomAty.class, bundle);
                break;
            case R.id.see_wei_relativeLayout:
                bundle.putString("customType", "2");
                this.showActivity(this, CustomAty.class, bundle);
                break;
            case R.id.see_baobei_relativeLayout:
                bundle.putString("customType", "3");
                this.showActivity(this, CustomAty.class, bundle);
                break;
            case R.id.see_todo_pic:
                this.showActivity(this, ToDoListAty.class);
                break;
            case R.id.see_jieding_pic:
                this.showActivity(this, CustomDefinitionAty.class);
                break;
        }
    }

    public void initTitle(int pozition) {
        textViewTitle.setText(listViewTitleList.get(pozition).getName());
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
