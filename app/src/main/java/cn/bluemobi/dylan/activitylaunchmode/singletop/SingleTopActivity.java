package cn.bluemobi.dylan.activitylaunchmode.singletop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.bluemobi.dylan.activitylaunchmode.NotificationUtil;
import cn.bluemobi.dylan.activitylaunchmode.R;

/**
 * Created by yuandl on 2016-11-17.
 */

public class SingleTopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_singletop);
    }

    public void onClick1(View v) {
        NotificationUtil.showNotification(this);
    }
    public void onClick2(View v) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(SingleTopActivity.this,LoginSuccessActivity.class));
            }
        }.start();
    }
}
