package cn.bluemobi.dylan.activitylaunchmode.singletask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.bluemobi.dylan.activitylaunchmode.NotificationUtil;
import cn.bluemobi.dylan.activitylaunchmode.R;
import cn.bluemobi.dylan.activitylaunchmode.singletop.LoginSuccessActivity;
import cn.bluemobi.dylan.activitylaunchmode.singletop.SingleTopActivity;

/**
 * Created by yuandl on 2016-11-17.
 */

public class SingleTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("0主界面，某些功能需要登陆-->需要点击登陆");
        setContentView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingleTaskActivity.this, LoginActivity.class));
            }
        });
    }

}
