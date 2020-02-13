package com.falconssoft.boj;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DraftTransfer extends AppCompatActivity {

    TextView t1, t2, t3, t4;
    ScrollView l1, l2, l3, l4;
    Button save;
    RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draft_transfer);

        init();
    }

    View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.back:
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l4.setVisibility(View.GONE);
                    l1.setVisibility(View.GONE);
                    break;

                case R.id.t1:
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l4.setVisibility(View.GONE);
                    l1.setVisibility(View.VISIBLE);
                    break;

                case R.id.t2:
                    l1.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l4.setVisibility(View.GONE);
                    l2.setVisibility(View.VISIBLE);
                    break;

                case R.id.t3:
                    l1.setVisibility(View.GONE);
                    l2.setVisibility(View.GONE);
                    l4.setVisibility(View.GONE);
                    l3.setVisibility(View.VISIBLE);
                    break;

                case R.id.t4:
                    l1.setVisibility(View.GONE);
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l4.setVisibility(View.VISIBLE);
                    break;

                case R.id.save:
                    draftDialog();
                    break;

            }
        }
    };

    public void draftDialog() {
        final Dialog dialog = new Dialog(DraftTransfer.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.draft);
        dialog.setCanceledOnTouchOutside(true);

        TextView body = dialog.findViewById(R.id.body);
        Button next = dialog.findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transfersDialog();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void transfersDialog() {
        final Dialog dialog = new Dialog(DraftTransfer.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.transfer);
        dialog.setCanceledOnTouchOutside(true);

//        TextView body = dialog.findViewById(R.id.body);
        Button save = dialog.findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    void init(){

        back = findViewById(R.id.back);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        
        save = findViewById(R.id.save);

        back.setOnClickListener(OnClickListener);
        t1.setOnClickListener(OnClickListener);
        t2.setOnClickListener(OnClickListener);
        t3.setOnClickListener(OnClickListener);
        t4.setOnClickListener(OnClickListener);
        save.setOnClickListener(OnClickListener);
    }
}
