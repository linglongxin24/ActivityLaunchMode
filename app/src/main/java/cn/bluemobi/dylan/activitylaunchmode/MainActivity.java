package cn.bluemobi.dylan.activitylaunchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.bluemobi.dylan.activitylaunchmode.singleinstance.SingleInstanceActivity;
import cn.bluemobi.dylan.activitylaunchmode.singletask.SingleTaskActivity;
import cn.bluemobi.dylan.activitylaunchmode.singletop.SingleTopActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

    }

    public void onClick(View view) {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    public void onClick2(View view) {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    public void onClick3(View view) {
        startActivity(new Intent(this, SingleInstanceActivity.class));
    }
}
