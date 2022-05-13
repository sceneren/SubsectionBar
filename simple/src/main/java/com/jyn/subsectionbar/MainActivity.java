package com.jyn.subsectionbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.jyn.subsectionseekbar.OnSubsectionSeekBarChangeListener;
import com.jyn.subsectionseekbar.SectionBean;
import com.jyn.subsectionseekbar.SubsectionSeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSeekBar();
    }


    private void initSeekBar() {
        final SubsectionSeekBar bmpSeekBar = findViewById(R.id.seek_bar_bmp);
        final TextView seekbarTx = findViewById(R.id.seekbar_tx);
        bmpSeekBar.setProgress(250);
        bmpSeekBar.setOnSubsectionSeekBarChangeListener(new OnSubsectionSeekBarChangeListener() {
            public void onProgressChanged(View view, int progress, boolean fromUser) {

                if (progress < 200) {
                    bmpSeekBar.setProgress(200);
                }
                seekbarTx.setText("progress: " + progress);
            }

            @Override
            public void onKeyTouch(int person, float x) {
                super.onKeyTouch(person, x);
            }
        });

        bmpSeekBar.setSectionBeans(getBmpSeekBars());
        SubsectionSeekBar seekBar = findViewById(R.id.seek_bar);
        final TextView seekbarTx2 = findViewById(R.id.seekbar_tx2);

        seekBar.setSectionBeans(getSeekBars());
        seekBar.setKayBars(getKeyBar());

        seekBar.setOnSubsectionSeekBarChangeListener(new OnSubsectionSeekBarChangeListener() {
            public void onProgressChanged(View view, int progress, boolean fromUser) {
                seekbarTx2.setText("progress: " + progress);
            }

            @Override
            public void onKeyTouch(int person, float x) {
                Log.i("main", "person: " + person + "; x:" + x);
            }
        });

        SeekBar seekBar1 = findViewById(R.id.native_seek_bar);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn.setText("获取（" + bmpSeekBar.getProgress() + "）");
            }
        });

        SubsectionSeekBar seek_bar_bmp_2 = findViewById(R.id.seek_bar_bmp_2);
        seek_bar_bmp_2.setProgress(200);
    }

    public List<SectionBean> getBmpSeekBars() {
        List<SectionBean> sectionBeans = new ArrayList<>();
        sectionBeans.add(new SectionBean(Color.parseColor("#666666"),
                0, 200, true));

        return sectionBeans;
    }


    public List<Integer> getKeyBar() {
        List<Integer> keybar = new ArrayList<>();
        keybar.add(400);
        keybar.add(800);
        return keybar;
    }

    public List<SectionBean> getSeekBars() {
        List<SectionBean> sectionBeans = new ArrayList<>();
        sectionBeans.add(new SectionBean(ContextCompat.getColor(this, R.color.blue1),
                300, 400, false));
        sectionBeans.add(new SectionBean(ContextCompat.getColor(this, R.color.red1),
                500, 800, false));
        return sectionBeans;
    }
}
