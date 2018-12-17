package com.example.melon.withgil;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by melon on 2018-09-30.
 */

public class LocationSettingDialog extends Dialog implements View.OnClickListener{
    private Context context;
    private String district;
    private String region;

    private Spinner spinner1;
    private Spinner spinner2;

    private LocationSettingDialogListener locationSettingDialogListener;

    public LocationSettingDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public LocationSettingDialog(@NonNull Context context, String district, String region) {
        super(context);
        this.context = context;
        this.region = region;
        this.district = district;
    }

    public void setLocationSettingDialogListener(LocationSettingDialogListener locationSettingDialogListener) {
        this.locationSettingDialogListener = locationSettingDialogListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.setting_location_select_dialog);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        Button bt_location_select = findViewById(R.id.bt_location_select);
        bt_location_select.setOnClickListener(this);

        final MapInfoDatabase mapInfoDatabase = new MapInfoDatabase(context, "mapinfo.db", null, 1);
        final DefaultRegionDatabase defaultRegionDatabase = new DefaultRegionDatabase(context, "defaultregion.db", null, 1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, View view,
                                       final int position, long id) {
                //선택시 상황
                final ArrayList<String> regions = mapInfoDatabase.getRegionName((String) parent.getItemAtPosition(position));
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_spinner_item, regions);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter);

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        defaultRegionDatabase.addDR((String) parent.getItemAtPosition(position), (String) adapterView.getItemAtPosition(i));
                        district = (String) parent.getItemAtPosition(position);
                        region = (String) adapterView.getItemAtPosition(i);
                        Log.d("location select : ", district + ", " + region);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_location_select:
                locationSettingDialogListener.onPositiveClicked(district, region);
                dismiss();
        }
    }
}
