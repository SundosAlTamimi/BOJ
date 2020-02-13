package com.falconssoft.boj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout indicator;

    List<Integer> color;
    List<String> colorName;

    ArrayList<String> picforbar, pic2;
    LinearLayout documentCredite,DraftTransfer,Warranty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        indicator=(TabLayout)findViewById(R.id.indicator);

        DraftTransfer=(LinearLayout) findViewById(  R.id.DraftTransfer);
       Warranty=(LinearLayout) findViewById(R.id.Warranty);
        documentCredite=(LinearLayout) findViewById(R.id.documentCredite);
        documentCredite.setOnClickListener(onClickLinear);
        DraftTransfer.setOnClickListener(onClickLinear);
        Warranty.setOnClickListener(onClickLinear);

        color = new ArrayList<>();
        color.add(R.drawable.img1);
        color.add(R.drawable.bank2);
        color.add(R.drawable.img3);
        color.add(R.drawable.img4);
        color.add(R.drawable.img5);
        picforbar = new ArrayList<>();
        pic2 = new ArrayList<>();

        colorName = new ArrayList<>();
        colorName.add("RED");
        colorName.add("GREEN");
        colorName.add("BLUE");

        viewPager.setAdapter(new SliderAdapter(this, color, colorName));
        indicator.setupWithViewPager(viewPager, true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);




    }

    View.OnClickListener onClickLinear=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.documentCredite:

                    Intent intentDocument=new Intent(MainActivity.this,documentCredit.class);
                    startActivity(intentDocument);
                    break;

                case R.id.DraftTransfer:

                    Intent intentDraft=new Intent(MainActivity.this,DraftTransfer.class);
                    startActivity(intentDraft);
                    break;

                case R.id.Warranty:

                    Intent intentWarrant=new Intent(MainActivity.this,Warranty.class);
                    startActivity(intentWarrant);
                    break;
            }

        }
    };

    public void fillBarList(){

        //        picforbar.add("My Reward");
        picforbar.add("My Profile");
        picforbar.add("Documentary Credits");//Application For Opening a
        picforbar.add("AR/EN");
//        picforbar.add("Bar code");
//        picforbar.add("Branch");
//        picforbar.add("Add New");

//        pic2.add("rewardimg");
        pic2.add("ic_person_white_24dp");
        pic2.add("ic_call_white_48dp");
        pic2.add("ic_translate_white_24dp");
//        pic2.add("barcode");
//        pic2.add("branch");
//        pic2.add("plus_sign");
    }

    public int getImage(String imageName) {

        int drawableResourceId = MainActivity.this.getResources().getIdentifier(imageName, "drawable", MainActivity.this.getPackageName());
        return drawableResourceId;
    }




    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < color.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}