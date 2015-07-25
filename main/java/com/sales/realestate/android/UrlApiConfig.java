package com.sales.realestate.android;

import org.kymjs.kjframe.http.HttpParams;

/**
 * Url API 拼接相关方法
 *
 * @author chenlin
 */
public class UrlApiConfig {

    public final static String URL_START = "http://127.0.0.1/";
    public final static String URL_END = "";

    //用户登录Url
    public static String URL_USER_LOGIN = URL_START + "/user/login" + URL_END;
    //用户登出
    public static String URL_USER_LOGINOUT = URL_START + "/user/logout" + URL_END;
    //用户修改密码
    public static String URL_USER_CHANGEPASSWORD = URL_START + "/user/changepassword" + URL_END;
    //客户列表
    public static String URL_CLIENTS_LIST = URL_START + "/clients/list" + URL_END;
    //客户详细
    public static String URL_CLIENTS_DETAIL = URL_START + "/clients/detail" + URL_END;
    //某个楼盘有效/无效客户统计信息
    public static String URL_CLIENTS_VALIDATIONBRIEF = URL_START + "/clients/validationbrief" + URL_END;
    //某个楼盘客户列表信息
    public static String URL_CLIENTS_VALIDATIONLIST = URL_START + "/clients/validationlist" + URL_END;
    //分配给客户置业顾问
    public static String URL_CLIENTS_ALLOCATE = URL_START + "/clients/allocate" + URL_END;
    //提交认筹申请
    public static String URL_CLIENTS_PREORDERREQUEST = URL_START + "/clients/preorder_request" + URL_END;
    //批准认筹申请
    public static String URL_CLIENTS_PREORDERAPPROVE = URL_START + "/clients/preorder_approve" + URL_END;
    //客户退筹申请
    public static String URL_CLIENTS_PREORDERREJECT = URL_START + "/clients/preorder_reject" + URL_END;
    //提交认购申请
    public static String URL_CLIENTS_ORDERREQUEST = URL_START + "/clients/order_request" + URL_END;
    //批准认购
    public static String URL_CLIENTS_ORDERAPPROVE = URL_START + "/clients/order_approve" + URL_END;
    //退购
    public static String URL_CLIENTS_ORDERREJECT = URL_START + "/clients/order_reject" + URL_END;
    //提交成交申请
    public static String URL_CLIENTS_DELREQUEST = URL_START + "/clients/deal_request" + URL_END;
    //批准成交
    public static String URL_CLIENTS_DELAPPROVE = URL_START + "/clients/deal_approve" + URL_END;
    //跟进客户信息
    public static String URL_CLIENTS_FOLLOWUP = URL_START + "/clients/followup" + URL_END;
    //楼盘置业顾问销售统计报表
    public static String URL_REPORTS = URL_START + "/reports" + URL_END;
    //楼盘销控表
    public static String URL_SALES_LIST = URL_START + "/sales/list" + URL_END;
    //楼盘销控细节
    public static String URL_SALES_DETAIL = URL_START + "/sales/detail" + URL_END;
    //ANDROID最新版本
    public static String URL_ANDROID_VERSION = URL_START + "/android/version" + URL_END;
    //ANDROID最新版本下载地址
    public static String URL_ANDROID_FILEURL = URL_START + "/android/" + URL_END;
    //新闻公告列表
    public static String URL_NOTICES_LIST = URL_START + "/notices/list" + URL_END;
    //新闻公告列表
    public static String URL_NOTICES_DETAIL = URL_START + "/notices/detail" + URL_END;
    //房屋成交详情
    public static String URL_STATISTICS_LIST = URL_START + "/statistics/list" + URL_END;
    //客户访问详情
    public static String URL_VISITS_LIST = URL_START + "/statistics/list" + URL_END;
    //延迟盘未定义客户列表
    public static String URL_DELAY_LIST = URL_START + "/delay/list" + URL_END;
    //延迟盘的客户确定为有效
    public static String URL_DELAY_IDENTIFY = URL_START + "/delay/identify" + URL_END;
    //用户的邮件列表
    public static String URL_MESSAGES_LIST = URL_START + "/messages/list" + URL_END;
    //用户的通讯录
    public static String URL_CONTACTS_LIST = URL_START + "/contacts/list" + URL_END;


    public final static void reflashUrl() {
        URL_USER_LOGIN = URL_START + "/user/login" + URL_END;
    }


    public final static HttpParams getUrlUserLoginParams(String userid, String password) {
        HttpParams params = new HttpParams();
        params.put("userid", userid);
        params.put("password", password);
        return params;
    }


    public final static HttpParams getUrlUserLoginOutParams() {
        HttpParams params = getNewHttpParams();
        return params;
    }

    public final static HttpParams getUrlUserChangepasswordParams(String newpass) {
        HttpParams params = getNewHttpParams();
        params.put("password", GlobalVarible.USER_PASSWORD);
        params.put("password", newpass);
        return params;
    }

    public final static HttpParams getUrlClientsListParams(String builidingid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        return params;
    }

    public final static HttpParams getUrlClientsDetailParams(String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsValidationbriefParams(String builidingid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        return params;
    }

    public final static HttpParams getUrlClientsValidationListParams(String builidingid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        return params;
    }

    public final static HttpParams getUrlClientsAllocateParams(String builidingid, String consultantid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        params.put("consultantid", consultantid);
        return params;
    }

    public final static HttpParams getUrlClientsPreorderRequestParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsPreorderApproveParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsPreorderRejectParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsOrderRequestParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsOrderApproveParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsOrderRejectParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsDealRequestParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsDealApproveParams(String builidingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlClientsFollowupParams(String builidingid, String followupinfo, String followuptype, String newlevel) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("followupinfo", followupinfo);
        params.put("followuptype", followuptype);
        params.put("newlevel", newlevel);
        return params;
    }

    public final static HttpParams getUrlReportsParams(String builidingid, String startdate, String enddate) {
        HttpParams params = getNewHttpParams();
        params.put("builidingid", builidingid);
        params.put("startdate", startdate);
        params.put("enddate", enddate);
        return params;
    }

    public final static HttpParams getUrlSalesListParams(String buildingid, String blockid, String cellid) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        params.put("blockid", blockid);
        params.put("cellid", cellid);
        return params;
    }

    public final static HttpParams getUrlSalesDetailParams(String buildingid, String blockid, String cellid, String roomId) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        params.put("blockid", blockid);
        params.put("cellid", cellid);
        params.put("roomId", roomId);
        return params;
    }

    public final static HttpParams getUrlNoticesListParams(String buildingid) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        return params;
    }

    public final static HttpParams getUrlNoticesDetailParams(String buildingid, String noticeid) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        params.put("noticeid", noticeid);
        return params;
    }

    public final static HttpParams getUrlStatisticsListParams(String buildingid, String type, String begindate, String enddate) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        params.put("type", type);
        params.put("begindate", begindate);
        params.put("enddate", enddate);
        return params;
    }

    public final static HttpParams getUrlVisitsListParams(String buildingid, String type, String begindate, String enddate) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        params.put("type", type);
        params.put("begindate", begindate);
        params.put("enddate", enddate);
        return params;
    }

    public final static HttpParams getUrlDelayListParams(String buildingid) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        return params;
    }

    public final static HttpParams getUrlDelayIdentifyParams(String buildingid, String clientid) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        params.put("clientid", clientid);
        return params;
    }

    public final static HttpParams getUrlMessageListParams(String buildingid) {
        HttpParams params = getNewHttpParams();
        params.put("buildingid", buildingid);
        return params;
    }

    public final static HttpParams getUrlContactsListParams(String buildingid) {
        HttpParams params = getNewHttpParams();
        return params;
    }


    private static synchronized HttpParams getNewHttpParams() {
        HttpParams params = new HttpParams();
        params.put("userid", GlobalVarible.USER_ID);
        params.put("userid", GlobalVarible.ROLE_ID);
        return params;
    }
}
