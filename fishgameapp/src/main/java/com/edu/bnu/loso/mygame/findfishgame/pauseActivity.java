package com.edu.bnu.loso.mygame.findfishgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edu.bnu.loso.mygame.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class pauseActivity extends Activity {
    private static Map<String,Activity> destoryMap = new HashMap<>();

    public static void addDestoryActivity(Activity activity,String activityName) {
        destoryMap.put(activityName,activity);
    }
    /**
     *销毁指定Activity
     */
    public static void destoryActivity(String activityName) {
        Set<String> keySet=destoryMap.keySet();
        for (String key:keySet){
            destoryMap.get(key).finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);

        final Button button = (Button) findViewById(R.id.buttonExit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                destoryActivity("Game");
                finish();
            }
        });

        final Button button1 = (Button) findViewById(R.id.buttonGoOn);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
            }
        });
    }
}
