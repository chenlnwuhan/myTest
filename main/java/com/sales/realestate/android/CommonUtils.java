package com.sales.realestate.android;

import org.kymjs.kjframe.utils.StringUtils;

import android.content.Context;

import com.sales.realestate.android.utils.AppUtils;
import com.sales.realestate.android.utils.SPUtils;

/**
 * Created by chenlin on 2015/7/8.
 */
public class CommonUtils {
	/**
	 * 程序初始化时，初始化用户信息
	 * @param mContext
	 */
    public static void AppInit(Context mContext){
        GlobalVarible.VERSION_ID = String.valueOf(AppUtils.getVersionCode(mContext));
        GlobalVarible.IP = "";
        GlobalVarible.USER_ID = (String) SPUtils.get(mContext,CommomKey.PERFERENCE_USERID,"");
        if(StringUtils.isEmpty(GlobalVarible.USER_ID)){
        	GlobalVarible.IS_LOGIN = false ;
        	return ;
        }
        GlobalVarible.USER_PASSWORD = (String) SPUtils.get(mContext,CommomKey.PERFERENCE_USERPASSWORD,"");
        GlobalVarible.ROLE_ID = (String) SPUtils.get(mContext,CommomKey.PERFERENCE_ROLEID,"");
        
    }
    
    

}
