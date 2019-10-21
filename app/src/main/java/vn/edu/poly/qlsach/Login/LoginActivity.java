package vn.edu.poly.qlsach.Login;


import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.HomeActivity;
import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;
import vn.edu.poly.qlsach.R;

public class LoginActivity extends BaseActivity {

    private TextInputEditText edtuser, edtpass;
    private String userName, passWord;

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    private MySqliteOpenHelper mySqliteOpenHelper;

    @Override
    public void initView() {
        mySqliteOpenHelper = new MySqliteOpenHelper(this);
        mySqliteOpenHelper.createDataBase();
        edtpass = findViewById(R.id.edtpassWord);
        edtuser = findViewById(R.id.edtuserName);

    }

    public void openForgotPass(View view) {
        openActivity(ForgorPaswordActivity.class);
    }

    public void openSignup(View view) {
        openActivity(SignupActivity.class);
    }

    public void openHome(View view) {
        userName = edtuser.getText().toString();
        passWord = edtpass.getText().toString();
        if (userName.equals("admin") && passWord.equals("admin")) {
            openActivity(HomeActivity.class);
        } else {
            Toast.makeText(this, "Nhập tài khoản với vai trò người quản lý", Toast.LENGTH_SHORT).show();
        }
    }
}
