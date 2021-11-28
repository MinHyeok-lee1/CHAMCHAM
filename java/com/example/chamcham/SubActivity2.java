package com.example.chamcham;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    Button bt_tram;
    Button bt_info;
    Button bt_home;
    Button bt_card;


    View Line;
    TextView TramL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pink2);
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled = ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        if (isImmersiveModeEnabled) {
            Log.i("Is on?", "Turning immersive mode mode off. ");
        } else {
            Log.i("Is on?", "Turning immersive mode mode on.");
        }
// 몰입 모드
        newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);


        bt_tram = (Button) findViewById(R.id.btnTramp);
        bt_card = (Button) findViewById(R.id.btnCard);
        bt_home = (Button) findViewById(R.id.btnHomep);
        bt_info = (Button) findViewById(R.id.btnInfop);

        TramL = (TextView) findViewById(R.id.TramL);
        Line = (View) findViewById(R.id.line);

        final Intent intent0 = new Intent(this, MainActivity1.class);
        final Intent intent1 = new Intent(this, MainActivity2.class);
        final Intent intent2 = new Intent(this, SubActivity2.class);
        final Intent intent3 = new Intent(this, SubActivity3.class);
        final Intent intent4 = new Intent(this, SubActivity4.class);


        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Number.save == 0) startActivity(intent0);
                else startActivity(intent1);
            }
        });
        bt_tram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
        bt_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });
        bt_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}