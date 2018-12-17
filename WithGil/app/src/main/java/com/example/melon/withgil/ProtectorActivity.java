package com.example.melon.withgil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProtectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setTitle("보호자 연락");
        setContentView(R.layout.activity_protector);
    }

    public void OnclickButton(View v){
        Toast.makeText(this, "저장 완료", Toast.LENGTH_LONG).show();
        EditText parentNum = (EditText) findViewById(R.id.ParentNum) ;
        String num = parentNum.getText().toString() ;
        //EditText messageCon = (EditText) findViewById(R.id.MessageCon) ;
        //String message = messageCon.getText().toString() ;
        UserInfoDatabase userInfoDatabase = new UserInfoDatabase(this, "userinfo.db", null, 1);
        userInfoDatabase.addUser(num);
        Log.d("Log : phoneNum", num.toString());
        finish();
    }
}
