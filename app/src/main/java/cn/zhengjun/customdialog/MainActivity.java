package cn.zhengjun.customdialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.zhengjun.customdialogaar.CustomDialog;

public class MainActivity extends AppCompatActivity {

    private int intent_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View pView){
        new CustomDialog(this, getString(R.string.ocard_resume_confirm),null,  "确定重启吗？", getString(R.string.cancel), getString(R.string.confirm), new CustomDialog.DialogClickListener() {
            @Override
            public void onNegtiveClick() {

            }

            @SuppressLint("WrongConstant")
            @Override
            public void onPositiveClick(String manualContent) {
                Toast.makeText(MainActivity.this, "Got it!", Toast.LENGTH_SHORT).show();
            }
        }, CustomDialog.MODE_OKLINE2).show();
    }
}
