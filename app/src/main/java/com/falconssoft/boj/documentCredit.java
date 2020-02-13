package com.falconssoft.boj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class documentCredit extends AppCompatActivity {

    ScrollView lin1,lin2,lin3,lin5,lin6,lin7;
    List<Integer> ListOfLinerShow;
    Button Previously,next;
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_issuing_bank_of_jordan);
        ListOfLinerShow=new ArrayList<>();
        ListOfLinerShow.add(R.id.lin1);
        ListOfLinerShow.add(R.id.lin2);
        ListOfLinerShow.add(R.id.lin3);
        ListOfLinerShow.add(R.id.lin5);
        ListOfLinerShow.add(R.id.lin6);
        ListOfLinerShow.add(R.id.lin7);

        Previously=findViewById(R.id.Previously);
        next=findViewById(R.id.next);

        lin1=(ScrollView)findViewById(R.id.lin1);
        lin2=(ScrollView)findViewById(R.id.lin2);
        lin3=(ScrollView)findViewById(R.id.lin3);
        lin5=(ScrollView)findViewById(R.id.lin5);
        lin6=(ScrollView)findViewById(R.id.lin6);
        lin7=(ScrollView)findViewById(R.id.lin7);
        GoneAllLin();
        ViewLin(0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if(index<ListOfLinerShow.size()) {
                    GoneAllLin();
                    ViewLin(index);
                }else{
                    index=ListOfLinerShow.size()-1;
                }

            }
        });


        Previously.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                if(index>=0) {
                    GoneAllLin();
                    ViewLin(index);

                }else {
                    index=0;
                }
            }
        });

    }

    void GoneAllLin (){
        for(int i=0;i<ListOfLinerShow.size();i++){
            View v=findViewById(ListOfLinerShow.get(i));
            v.setVisibility(View.GONE);
        }


    }

    void ViewLin (int position){
        View v=findViewById(ListOfLinerShow.get(position));
        v.setVisibility(View.VISIBLE);

    }




}
