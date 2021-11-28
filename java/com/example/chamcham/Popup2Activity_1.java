package com.example.chamcham;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class Popup2Activity_1 extends Activity {

    TextView btn1;
    TextView color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity2_popup_1);
        btn1 = (TextView) findViewById(R.id.btn1_1);

        String str = "4호차 1A자리가\n예약되었습니다.";
        color = (TextView) findViewById(R.id.atdContentTv_v);

        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#8fc8ff")), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        color.setText(ssb);

        final Intent intent1 = new Intent(this, MainActivity_2.class);
        final Intent intent = new Intent(this, MainActivity_3.class);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_border_1, (ViewGroup)findViewById(R.id.toast_layout_root));

                TextView text = (TextView) layout.findViewById(R.id.text);
                if(Number.mag == 1) text.setText("자리 예약시, 좌석에 있는\n 전자석의 높이를 맞춰주세요");
                else text.setText("좌석 탑승시, 좌석에 있는\n 안전벨트를 이용해 주세요");

                Toast toast = new Toast(getApplicationContext());
                int offsetX = 0;
                int offsetY = 0;
                toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                toast.setDuration(Toast.LENGTH_SHORT);
                //toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                toast.setView(layout);
                toast.show();
                finish();

                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable()  {
                    public void run() {
                        // 시간 지난 후 실행할 코딩
                        Number.save = 3;
                        if(Number.mag == 1) startActivity(intent1);
                        else startActivity(intent);
                    }
                }, 2000); // 2초후
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