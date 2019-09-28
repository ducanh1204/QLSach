package vn.edu.poly.qlsach.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    public abstract int setLayout();
    public abstract void initView();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
    }

    public void openActivity(Class aClass){
        Intent intent = new Intent(this,aClass);
        startActivity(intent);
    }
}
