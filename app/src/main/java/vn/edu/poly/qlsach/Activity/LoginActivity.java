package vn.edu.poly.qlsach.Activity;


import android.view.View;
import android.widget.EditText;

import vn.edu.poly.qlsach.BaseActivity;
import vn.edu.poly.qlsach.R;

public class LoginActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {


    }

    public void openForgotPass(View view) {
        openActivity(ForgorPaswordActivity.class);
    }
    public void openSignup(View view) {
        openActivity(SignupActivity.class);
    }
    public void openHome(View view){
        openActivity(HomeActivity.class);
    }
}
