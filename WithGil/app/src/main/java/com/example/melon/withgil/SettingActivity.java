package com.example.melon.withgil;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Set;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private String district;
    private String region;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTitle("환경 설정");
        setContentView(R.layout.activity_setting);

        ImageView imageViewGuardian = findViewById(R.id.iv_guardian);
        ImageView imageViewLocation = findViewById(R.id.iv_location_select);
        ImageView imageViewHelp = findViewById(R.id.iv_help);
        ImageView imageViewAppInfo = findViewById(R.id.iv_app_info);
        imageViewGuardian.setOnClickListener(this);
        imageViewLocation.setOnClickListener(this);
        imageViewHelp.setOnClickListener(this);
        imageViewAppInfo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        //Log.d("Click Log", String.valueOf(view.getId()));
        switch (view.getId()){
            case R.id.iv_guardian:
                Intent protectorIntent = new Intent(SettingActivity.this, ProtectorActivity.class);
                startActivity(protectorIntent);
                break;

            case R.id.iv_location_select:
                LocationSettingDialog locationSettingDialog = new LocationSettingDialog(SettingActivity.this, district, region);
                locationSettingDialog.setLocationSettingDialogListener(new LocationSettingDialogListener() {
                    @Override
                    public void onPositiveClicked(String district, String region) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("district", district);
                        resultIntent.putExtra("region", region);
                        Log.d("location result : ", district + ", " + region);
                        setResult(RESULT_OK, resultIntent);
                    }

                    @Override
                    public void onNegativeClicked() {

                    }
                });

                Window window = locationSettingDialog.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                locationSettingDialog.show();

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int x = (int)(size.x * 0.9f);
                int y = (int)(size.y * 0.5f);
                window.setLayout(x, y);



                break;
            case R.id.iv_help:
                Intent intentHelp = new Intent(SettingActivity.this, HelpActivity.class);
                startActivity(intentHelp);
                break;

            case R.id.iv_app_info:
                Intent intentAppInfo = new Intent(SettingActivity.this, AppInfoActivity.class);
                startActivity(intentAppInfo);
                break;
        }

    }
}
