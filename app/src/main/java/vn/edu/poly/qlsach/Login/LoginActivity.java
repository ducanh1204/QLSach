package vn.edu.poly.qlsach.Login;


import android.view.View;

import vn.edu.poly.qlsach.Home.HomeActivity;
import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;
import vn.edu.poly.qlsach.R;

public class LoginActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    private MySqliteOpenHelper mySqliteOpenHelper;

    @Override
    public void initView() {
        mySqliteOpenHelper = new MySqliteOpenHelper(this);
        mySqliteOpenHelper.createDataBase();
    }

    public void openForgotPass(View view) {
        openActivity(ForgorPaswordActivity.class);
    }

    public void openSignup(View view) {
        openActivity(SignupActivity.class);
    }

    public void openHome(View view) {
        openActivity(HomeActivity.class);
    }
}
