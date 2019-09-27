package vn.edu.poly.qlsach.Activity;

import android.view.View;

import vn.edu.poly.qlsach.BaseActivity;
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
