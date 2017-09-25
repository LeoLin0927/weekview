package com.asus.leo.weekview.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.asus.leo.weekview.R;
import com.asus.leo.weekview.common.WeekViewData;
import com.asus.leo.weekview.fragment.YoyoFragment;
import com.asus.leo.weekview.fragment.MomoFragment;
import com.asus.leo.weekview.fragment.DisneyFragment;

import java.util.ArrayList;

public class EditContentActivity extends AppCompatActivity {

    private String [] mIntentData;
    private ArrayList<WeekViewData> mYoyoData = new ArrayList<WeekViewData>();
    private ArrayList<WeekViewData> mMomoData = new ArrayList<WeekViewData>();
    private ArrayList<WeekViewData> mDisneyData = new ArrayList<WeekViewData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcontent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditContentActivity.this.finish();
            }
        });


        FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        //Get Intent Data
        Intent intent = getIntent();
        mIntentData = intent.getStringExtra("content").split("\n");

        // add tab and add data
        for(int i=0 ; i<mIntentData.length ; i++){
            if(mIntentData[i].trim().equals("東森幼幼台")){
                tabHost.addTab(tabHost.newTabSpec(mIntentData[i].trim()).setIndicator(mIntentData[i].trim()),YoyoFragment.class,null);
                setCartoonData(mIntentData[i].trim());
            }else if(mIntentData[i].trim().equals("momo親子台")){
                tabHost.addTab(tabHost.newTabSpec(mIntentData[i].trim()).setIndicator(mIntentData[i].trim()),MomoFragment.class,null);
                setCartoonData(mIntentData[i].trim());
            }else if(mIntentData[i].trim().equals("迪士尼")){
                tabHost.addTab(tabHost.newTabSpec(mIntentData[i].trim()).setIndicator(mIntentData[i].trim()),DisneyFragment.class,null);
                setCartoonData(mIntentData[i].trim());
            }
        }

    }

    public void setCartoonData(String name){

        if(name.equals("東森幼幼台")){
            String [] cartoonNameYoyo = new String[]{"Dora","粉紅豬小妹","Poli波力"};
            Drawable [] cartoonYoyoImage = new Drawable[]{ getResources().getDrawable(R.drawable.dora),
                    getResources().getDrawable(R.drawable.peppa_pig),getResources().getDrawable(R.drawable.poli)};
            for(int j=0 ; j<cartoonNameYoyo.length ; j++){
                WeekViewData dataInfo = new WeekViewData();
                dataInfo.setContent(cartoonNameYoyo[j]);
                dataInfo.setImage(cartoonYoyoImage[j]);
                mYoyoData.add(dataInfo);
            }
        }else if(name.equals("momo親子台")){
            String [] cartoonNameMomo = new String[]{"櫻桃小丸子","湯瑪士小火車","樂比悠悠"};
            Drawable [] cartoonMomoImage = new Drawable[]{ getResources().getDrawable(R.drawable.chibi_maruko),
                    getResources().getDrawable(R.drawable.thomas),getResources().getDrawable(R.drawable.lebi)};
            for(int j=0 ; j<cartoonNameMomo.length ; j++){
                WeekViewData dataInfo = new WeekViewData();
                dataInfo.setContent(cartoonNameMomo[j]);
                dataInfo.setImage(cartoonMomoImage[j]);
                mMomoData.add(dataInfo);
            }
        }else if(name.equals("迪士尼")){
            String [] cartoonNameDisney = new String[]{"小熊維尼與跳跳虎","亨利小怪獸","小醫師大玩偶"};
            Drawable [] cartoonDisneyImage = new Drawable[]{ getResources().getDrawable(R.drawable.winnie),
                    getResources().getDrawable(R.drawable.henry),getResources().getDrawable(R.drawable.doc)};
            for(int j=0 ; j<cartoonNameDisney.length ; j++){
                WeekViewData dataInfo = new WeekViewData();
                dataInfo.setContent(cartoonNameDisney[j]);
                dataInfo.setImage(cartoonDisneyImage[j]);
                mDisneyData.add(dataInfo);
            }
        }
    }

    public ArrayList<WeekViewData> getYoyoData(){
        return mYoyoData;
    }

    public ArrayList<WeekViewData> getMomoData(){
        return mMomoData;
    }

    public ArrayList<WeekViewData> getDisneyData(){
        return mDisneyData;
    }

}
