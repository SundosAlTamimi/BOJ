package com.falconssoft.boj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Warranty extends AppCompatActivity {

    TextView t1, t2, t3;
    ScrollView l1, l2, l3;
    Button save;
    RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warranty);

        init();

    }

    View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.back:
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l1.setVisibility(View.GONE);
                    break;

                case R.id.t1:
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l1.setVisibility(View.VISIBLE);
                    break;

                case R.id.t2:
                    l1.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l2.setVisibility(View.VISIBLE);
                    break;

                case R.id.t3:
                    l1.setVisibility(View.GONE);
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.VISIBLE);
                    break;

                case R.id.save:
                    break;

            }
        }
    };

    void init(){

        back = findViewById(R.id.back);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);

        save = findViewById(R.id.save);

        back.setOnClickListener(OnClickListener);
        t1.setOnClickListener(OnClickListener);
        t2.setOnClickListener(OnClickListener);
        t3.setOnClickListener(OnClickListener);
        save.setOnClickListener(OnClickListener);
    }
}
