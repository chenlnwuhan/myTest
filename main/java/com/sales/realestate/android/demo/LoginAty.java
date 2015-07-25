package com.sales.realestate.android.demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sales.realestate.android.R;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

/**
 * Created by chenlin on 2015/7/20.
 */
public class LoginAty extends KJActivity {

    @BindView(id = R.id.view_toast_login_err)
    public LinearLayout toastLoginErr;

    @BindView(id = R.id.text_login_name)
    public EditText editTextLoginName;

    @BindView(id = R.id.text_login_password)
    public EditText editTextLoginPassword;

    @BindView(id = R.id.text_login_verifycode)
    public EditText editTextLoginVeryfycode;

    @BindView(id = R.id.view_verifycode)
    public LinearLayout linearLayoutVerifycode;

    @BindView(id = R.id.img_verifycode)
    public ImageView imageViewVerifycode;

    @BindView(id = R.id.button_login)
    public Button buttonLogin;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActivityActionMode(ActionBarMode.NOTITLE);
        setRootViewResId(R.layout.aty_login);
        super.onCreate(savedInstanceState);
    }

}
