package com.example.appcolorpicker13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    TextView mTvHex,mTvRBG;
    SeekBar mSkB,mSkR,mSkA,mSkG;
    ImageView mImage;
    int mRed,mGreen,mBlue,mAlpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHex = findViewById(R.id.textViewHex);
        mTvRBG = findViewById(R.id.textViewRGB);
        mSkA = findViewById(R.id.seekbarAlpha);
        mSkR = findViewById(R.id.seekbarRed);
        mSkG = findViewById(R.id.seekbarGreen);
        mSkB = findViewById(R.id.seekbarBlue);
        mImage = findViewById(R.id.imageview);

        mRed = mGreen = mBlue = mAlpha = 0;
        mSkA.setMax(255);
        mSkR.setMax(255);
        mSkG.setMax(255);
        mSkB.setMax(255);

        mSkA.setOnSeekBarChangeListener(this);
        mSkR.setOnSeekBarChangeListener(this);
        mSkG.setOnSeekBarChangeListener(this);
        mSkB.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekbarAlpha :
                mAlpha = progress;
                break;
            case R.id.seekbarRed :
                mRed = progress;
                break;
            case R.id.seekbarGreen :
                mGreen = progress;
                break;
            case R.id.seekbarBlue :
                mBlue = progress;
                break;
        }
//        mAlpha = seekBar.getId() == R.id.seekbarAlpha ? mAlpha = progress : (seekBar.getId() == R.id.seekbarRed) ? mRed = progress : (seekBar.getId() == R.id.seekbarGreen) ? mGreen = progress : (seekBar.getId() == R.id.seekbarBlue) ? mBlue = progress : mBlue;
        mImage.setBackgroundColor(Color.argb(mAlpha,mRed,mGreen,mBlue));
        mTvRBG.setText(String.format("RBG 255 %d %d %d",mRed,mGreen,mBlue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}