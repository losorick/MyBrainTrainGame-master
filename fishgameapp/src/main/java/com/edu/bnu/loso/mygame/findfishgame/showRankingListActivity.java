package com.edu.bnu.loso.mygame.findfishgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.edu.bnu.loso.mygame.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class showRankingListActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_show_ranking_list);
        destoryActivity("Game");
        destoryActivity("ResultActivity");

        int score;
        Intent intent = getIntent();
        score = (int) intent.getSerializableExtra("score");
        TextView Rank3 = (TextView)findViewById(R.id.Rank3);
        Rank3.setText("3.\t\t" + score);

        TextView currentCountView = (TextView)findViewById(R.id.currentCountView);
        currentCountView.setText("" + (int)(score/100) + "条");

        final Button nextGameButton = (Button) findViewById(R.id.nextGameView);     //这里是测试，应该推荐到下一个游戏，并在并传递一个Intent的值，
        nextGameButton.setOnClickListener(new View.OnClickListener() {              //看看是不是要关闭这个activity
            public void onClick(View v) {
                finish();
            }
        });

        final TextView replayView = (TextView) findViewById(R.id.replayView);
        replayView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }



}
