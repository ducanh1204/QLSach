package vn.edu.poly.qlsach.Login;

import android.view.View;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class SignupActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_signup;
    }

    @Override
    public void initView() {

    }
    public void backScreen(View view){
        openActivity(LoginActivity.class);
    }
}
