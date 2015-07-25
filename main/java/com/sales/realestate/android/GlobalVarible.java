package com.sales.realestate.android;

import com.sales.realestate.android.bean.CustomInfo;
import com.sales.realestate.android.bean.MailInfo;
import com.sales.realestate.android.bean.PropertyConsultant;
import com.sales.realestate.android.bean.SpinnerItemInfo;
import com.sales.realestate.android.bean.ToDoListInfo;

import java.util.ArrayList;

/**
 * Created by chenlin on 2015/7/8.
 */
public class GlobalVarible {
    public static String IP = "";
    public static String VERSION_ID = "";

    public static String USER_ID = "";
    public static String USER_PASSWORD = "";
    public static String ROLE_ID = "";

    public static boolean IS_LOGIN = false ;


    private static ArrayList<MailInfo> MAIL_LIST = new ArrayList<MailInfo>();
    private static ArrayList<CustomInfo> CUSTOM_ANALYSE_LIST = new ArrayList<CustomInfo>();
    private static ArrayList<PropertyConsultant> PROPERTY_CONSULTANT_LIST = new ArrayList<PropertyConsultant>();
    private static ArrayList<ToDoListInfo> TODO_INFO_LIST = new ArrayList<ToDoListInfo>();

    private static ArrayList<SpinnerItemInfo> TITLE_MAIL_LIST = new ArrayList<SpinnerItemInfo>();
    private static ArrayList<SpinnerItemInfo> TITLE_HOME_LIST = new ArrayList<SpinnerItemInfo>();
    private static ArrayList<SpinnerItemInfo> TITLE_CUSTOM_ANALYSE_LIST = new ArrayList<SpinnerItemInfo>();
    private static ArrayList<SpinnerItemInfo> TITLE_CUSTOM_LIST = new ArrayList<SpinnerItemInfo>();
    private static ArrayList<SpinnerItemInfo> TITLE_TODO_LIST = new ArrayList<SpinnerItemInfo>();

    public static ArrayList<ToDoListInfo> getTODO_INFO_LIST(String typeId){
        TODO_INFO_LIST.clear();
        int tId = Integer.valueOf(typeId);
        for(int i=0;i<6;i++){
            ToDoListInfo mToDoListInfo = new ToDoListInfo();
            mToDoListInfo.id = String.valueOf(i);
            mToDoListInfo.todoListType = typeId;
            if(i%3==0){
                mToDoListInfo.isRead = true ;
            }
            /**
             * 0 客户界定
             * 1 带看申请
             * 2 认筹申请
             * 3 认购申请
             * 4 成交申请
             * 5 销控认筹
             * 6 销控认购
             * 7 销控成交
             */
            switch (tId){
                case 0:
                    mToDoListInfo.title = "客户界定";
                    break;
                case 1:
                    mToDoListInfo.title = "带看申请";
                    break;
                case 2:
                    mToDoListInfo.title = "认筹申请";
                    break;
                case 3:
                    mToDoListInfo.title = "认购申请";
                    break;
                case 4:
                    mToDoListInfo.title = "成交申请";
                    break;
                case 5:
                    mToDoListInfo.title = "销控认筹";
                    break;
                case 6:
                    mToDoListInfo.title = "销控认购";
                    break;
                case 7:
                    mToDoListInfo.title = "销控成交";
                    break;
            }
            TODO_INFO_LIST.add(mToDoListInfo);
        }
        return TODO_INFO_LIST;
    }
    public static ArrayList<SpinnerItemInfo> getTITLE_TODO_LIST() {
        if(TITLE_TODO_LIST.size()==0){
            SpinnerItemInfo mSpinnerItemInfo = new SpinnerItemInfo();
            mSpinnerItemInfo.setId("0");
            mSpinnerItemInfo.setName("客户界定");
            mSpinnerItemInfo.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo);

            SpinnerItemInfo mSpinnerItemInfo1 = new SpinnerItemInfo();
            mSpinnerItemInfo1.setId("1");
            mSpinnerItemInfo1.setName("带看申请");
            mSpinnerItemInfo1.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo1);

            SpinnerItemInfo mSpinnerItemInfo2 = new SpinnerItemInfo();
            mSpinnerItemInfo2.setId("2");
            mSpinnerItemInfo2.setName("认筹申请");
            mSpinnerItemInfo2.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo2);

            SpinnerItemInfo mSpinnerItemInfo3 = new SpinnerItemInfo();
            mSpinnerItemInfo3.setId("3");
            mSpinnerItemInfo3.setName("认购申请");
            mSpinnerItemInfo3.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo3);

            SpinnerItemInfo mSpinnerItemInfo4= new SpinnerItemInfo();
            mSpinnerItemInfo4.setId("4");
            mSpinnerItemInfo4.setName("成交申请");
            mSpinnerItemInfo4.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo4);

            SpinnerItemInfo mSpinnerItemInfo5= new SpinnerItemInfo();
            mSpinnerItemInfo5.setId("5");
            mSpinnerItemInfo5.setName("销控认筹");
            mSpinnerItemInfo5.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo5);

            SpinnerItemInfo mSpinnerItemInfo6= new SpinnerItemInfo();
            mSpinnerItemInfo6.setId("6");
            mSpinnerItemInfo6.setName("销控认购");
            mSpinnerItemInfo6.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo6);

            SpinnerItemInfo mSpinnerItemInfo7= new SpinnerItemInfo();
            mSpinnerItemInfo7.setId("7");
            mSpinnerItemInfo7.setName("销控成交");
            mSpinnerItemInfo7.setIsCurrent(false);
            TITLE_TODO_LIST.add(mSpinnerItemInfo7);
        }

        return TITLE_TODO_LIST;
    }

    public static ArrayList<PropertyConsultant> getPROPERTY_CONSULTANT_LIST(){
        if(PROPERTY_CONSULTANT_LIST.size()==0){
            PropertyConsultant mPropertyConsultant = new PropertyConsultant();
            mPropertyConsultant.id = "0";
            mPropertyConsultant.name = "张雪赢";
            PROPERTY_CONSULTANT_LIST.add(mPropertyConsultant);

            PropertyConsultant mPropertyConsultant1 = new PropertyConsultant();
            mPropertyConsultant1.id = "1";
            mPropertyConsultant1.name = "张雪赢";
            PROPERTY_CONSULTANT_LIST.add(mPropertyConsultant1);

            PropertyConsultant mPropertyConsultant2 = new PropertyConsultant();
            mPropertyConsultant2.id = "2";
            mPropertyConsultant2.name = "张雪赢";
            PROPERTY_CONSULTANT_LIST.add(mPropertyConsultant2);

            PropertyConsultant mPropertyConsultant3 = new PropertyConsultant();
            mPropertyConsultant3.id = "3";
            mPropertyConsultant3.name = "张雪赢";
            PROPERTY_CONSULTANT_LIST.add(mPropertyConsultant3);

            PropertyConsultant mPropertyConsultant4 = new PropertyConsultant();
            mPropertyConsultant4.id = "0";
            mPropertyConsultant4.name = "张雪赢";
            PROPERTY_CONSULTANT_LIST.add(mPropertyConsultant4);

            PropertyConsultant mPropertyConsultant5 = new PropertyConsultant();
            mPropertyConsultant5.id = "0";
            mPropertyConsultant5.name = "张雪赢";
            PROPERTY_CONSULTANT_LIST.add(mPropertyConsultant5);

        }
        return PROPERTY_CONSULTANT_LIST;
    }

    public static ArrayList<SpinnerItemInfo> getTITLE_CUSTOM_LIST() {
        if(TITLE_CUSTOM_LIST.size()==0){
            SpinnerItemInfo mSpinnerItemInfo = new SpinnerItemInfo();
            mSpinnerItemInfo.setId("0");
            mSpinnerItemInfo.setName("来电客户(5)");
            mSpinnerItemInfo.setIsCurrent(false);
            TITLE_CUSTOM_LIST.add(mSpinnerItemInfo);

            SpinnerItemInfo mSpinnerItemInfo1 = new SpinnerItemInfo();
            mSpinnerItemInfo1.setId("1");
            mSpinnerItemInfo1.setName("来访客户(5)");
            mSpinnerItemInfo1.setIsCurrent(false);
            TITLE_CUSTOM_LIST.add(mSpinnerItemInfo1);

            SpinnerItemInfo mSpinnerItemInfo2 = new SpinnerItemInfo();
            mSpinnerItemInfo2.setId("2");
            mSpinnerItemInfo2.setName("微客户(5)");
            mSpinnerItemInfo2.setIsCurrent(false);
            TITLE_CUSTOM_LIST.add(mSpinnerItemInfo2);

            SpinnerItemInfo mSpinnerItemInfo3 = new SpinnerItemInfo();
            mSpinnerItemInfo3.setId("3");
            mSpinnerItemInfo3.setName("报备客户(5)");
            mSpinnerItemInfo3.setIsCurrent(false);
            TITLE_CUSTOM_LIST.add(mSpinnerItemInfo3);
            SpinnerItemInfo mSpinnerItemInfo4= new SpinnerItemInfo();
            mSpinnerItemInfo4.setId("4");
            mSpinnerItemInfo4.setName("所有客户(20)");
            mSpinnerItemInfo4.setIsCurrent(false);
            TITLE_CUSTOM_LIST.add(mSpinnerItemInfo4);
        }

        return TITLE_CUSTOM_LIST;
    }

    public static ArrayList<CustomInfo> getCUSTOM_ANALYSE_LIST(){
        if(CUSTOM_ANALYSE_LIST.size()==0){
            CustomInfo mCustomInfo = new CustomInfo();
            mCustomInfo.id = "0";
            mCustomInfo.name = "张雪赢";
            mCustomInfo.phoneNumber = "188787878";
            mCustomInfo.type = "A";
            mCustomInfo.propertyConsultant = "刘学东" ;
            mCustomInfo.lastFllowUp = "2015-7-12";
            mCustomInfo.validateTime =  mCustomInfo.lastFllowUp;
            mCustomInfo.validatePeople = "纪晓岚";
            CUSTOM_ANALYSE_LIST.add(mCustomInfo);

            CustomInfo mCustomInfo1 = new CustomInfo();
            mCustomInfo1.name = "晨曦";
            mCustomInfo1.phoneNumber = "188787878";
            mCustomInfo1.type = "B";
            mCustomInfo1.propertyConsultant = "郭德纲" ;
            mCustomInfo1.lastFllowUp = "2015-7-12";
            mCustomInfo1.id = "1";
            mCustomInfo1.validateTime =  mCustomInfo1.lastFllowUp;
            mCustomInfo1.validatePeople = "王刚";
            CUSTOM_ANALYSE_LIST.add(mCustomInfo1);

            CustomInfo mCustomInfo2 = new CustomInfo();
            mCustomInfo2.name = "陈晓东";
            mCustomInfo2.phoneNumber = "188787878";
            mCustomInfo2.type = "A";
            mCustomInfo2.propertyConsultant = "刘学东" ;
            mCustomInfo2.lastFllowUp = "2015-7-12";
            mCustomInfo2.validateTime =  mCustomInfo2.lastFllowUp;
            mCustomInfo2.id = "2";
            mCustomInfo2.validatePeople = "集中天";
            CUSTOM_ANALYSE_LIST.add(mCustomInfo2);

            CustomInfo mCustomInfo3 = new CustomInfo();
            mCustomInfo3.name = "王元过";
            mCustomInfo3.phoneNumber = "188787878";
            mCustomInfo3.propertyConsultant = "刘学东" ;
            mCustomInfo3.type = "A";
            mCustomInfo3.id = "3";
            mCustomInfo3.lastFllowUp = "2015-7-13";
            mCustomInfo3.validateTime =  mCustomInfo3.lastFllowUp;
            mCustomInfo3.validatePeople = "罗仲旭";
            CUSTOM_ANALYSE_LIST.add(mCustomInfo3);
        }
        return CUSTOM_ANALYSE_LIST;
    }

    public static ArrayList<MailInfo> getMAIL_LIST(){
        if(MAIL_LIST.size()==0){
            MailInfo mMailInfo = new MailInfo();
            mMailInfo.title = "有一个新的邮件，需要你带领去只";
            mMailInfo.mailTime = "2015-12-12";
            mMailInfo.isRead = true ;
            MAIL_LIST.add(mMailInfo);

            MailInfo mMailInfo1 = new MailInfo();
            mMailInfo1.title = "有一个新的邮件，需要您去分配任务";
            mMailInfo1.mailTime = "2015-12-12";
            mMailInfo1.isRead = false ;
            MAIL_LIST.add(mMailInfo1);

            MailInfo mMailInfo2 = new MailInfo();
            mMailInfo2.title = "有一个新的邮件，需要您去分配任务";
            mMailInfo2.mailTime = "2015-12-12";
            mMailInfo2.isRead = true ;
            MAIL_LIST.add(mMailInfo2);
        }
        return MAIL_LIST;
    }

    public static ArrayList<SpinnerItemInfo> getTITLE_CUSTOM_ANALYSE_LIST() {
        if(TITLE_CUSTOM_ANALYSE_LIST.size()==0){
            SpinnerItemInfo mSpinnerItemInfo = new SpinnerItemInfo();
            mSpinnerItemInfo.setId("0");
            mSpinnerItemInfo.setName("有效客户");
            mSpinnerItemInfo.setIsCurrent(false);
            TITLE_CUSTOM_ANALYSE_LIST.add(mSpinnerItemInfo);

            SpinnerItemInfo mSpinnerItemInfo1 = new SpinnerItemInfo();
            mSpinnerItemInfo1.setId("1");
            mSpinnerItemInfo1.setName("无效客户");
            mSpinnerItemInfo1.setIsCurrent(false);
            TITLE_CUSTOM_ANALYSE_LIST.add(mSpinnerItemInfo1);

            SpinnerItemInfo mSpinnerItemInfo2 = new SpinnerItemInfo();
            mSpinnerItemInfo2.setId("2");
            mSpinnerItemInfo2.setName("到访客户");
            mSpinnerItemInfo2.setIsCurrent(false);
            TITLE_CUSTOM_ANALYSE_LIST.add(mSpinnerItemInfo2);

            SpinnerItemInfo mSpinnerItemInfo3 = new SpinnerItemInfo();
            mSpinnerItemInfo3.setId("3");
            mSpinnerItemInfo3.setName("流失客户");
            mSpinnerItemInfo3.setIsCurrent(false);
            TITLE_CUSTOM_ANALYSE_LIST.add(mSpinnerItemInfo3);
        }

        return TITLE_CUSTOM_ANALYSE_LIST;
    }

    public static MailInfo findMailById(String mailId){
        MailInfo mMainInfo = new MailInfo();
        mMainInfo.mailTime = "07-07   03:20";
        mMainInfo.title = "近日深圳房价狂涨引起全民关注,而在房价暴涨的背后,是房地产税悄悄走近的步伐。近日房地产税初稿成型,有哪些亮点值得注意?据说房地产税具体税率或由... ";
        return mMainInfo;
    }
    public static ArrayList<SpinnerItemInfo> getTITLE_HOME_LIST() {
        if(TITLE_HOME_LIST.size()==0){
            SpinnerItemInfo mSpinnerItemInfo = new SpinnerItemInfo();
            mSpinnerItemInfo.setId("0");
            mSpinnerItemInfo.setName("万科魅力之城");
            mSpinnerItemInfo.setIsCurrent(false);
            TITLE_HOME_LIST.add(mSpinnerItemInfo);

            SpinnerItemInfo mSpinnerItemInfo1 = new SpinnerItemInfo();
            mSpinnerItemInfo1.setId("1");
            mSpinnerItemInfo1.setName("当代国际花园");
            mSpinnerItemInfo1.setIsCurrent(false);
            TITLE_HOME_LIST.add(mSpinnerItemInfo1);

            SpinnerItemInfo mSpinnerItemInfo2 = new SpinnerItemInfo();
            mSpinnerItemInfo2.setId("2");
            mSpinnerItemInfo2.setName("百步亭花园");
            mSpinnerItemInfo2.setIsCurrent(false);
            TITLE_HOME_LIST.add(mSpinnerItemInfo2);
        }
        return TITLE_HOME_LIST;
    }

    public static ArrayList<SpinnerItemInfo> getTITLE_MAIL_LIST() {
        if(TITLE_MAIL_LIST.size()==0){
            SpinnerItemInfo mSpinnerItemInfo = new SpinnerItemInfo();
            mSpinnerItemInfo.setId("0");
            mSpinnerItemInfo.setName("本周邮件");
            mSpinnerItemInfo.setIsCurrent(false);
            TITLE_MAIL_LIST.add(mSpinnerItemInfo);

            SpinnerItemInfo mSpinnerItemInfo1 = new SpinnerItemInfo();
            mSpinnerItemInfo1.setId("1");
            mSpinnerItemInfo1.setName("全部邮件");
            mSpinnerItemInfo1.setIsCurrent(false);
            TITLE_MAIL_LIST.add(mSpinnerItemInfo1);
        }
        return TITLE_MAIL_LIST;
    }

    public static ArrayList<SpinnerItemInfo> initTitleListFocus(ArrayList<SpinnerItemInfo> mTitilList,int oldPosition,int newPosition){
        if(oldPosition>-1){
            mTitilList.get(oldPosition).setIsCurrent(false);
            mTitilList.get(newPosition).setIsCurrent(true);
        }else{
            for(int i=0;i<mTitilList.size();i++){
                if(i==newPosition){
                    mTitilList.get(i).setIsCurrent(true);
                }else{
                    mTitilList.get(i).setIsCurrent(false);
                }
            }
        }
        return mTitilList;
    }
}
