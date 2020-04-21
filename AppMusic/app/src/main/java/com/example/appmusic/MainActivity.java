package com.example.appmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmusic.Database.User;
import com.example.appmusic.Database.UserData;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin, btnRes;
    private EditText txtUserName, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Intent intent = new Intent(this,Main2Activity.class);
        final Intent Resintent = new Intent(this,ResActivity.class);
        final UserData userData = new UserData(this);



        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRes = (Button) findViewById(R.id.btnRes);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUserName.getText().length() <= 0)
                {
                    Toast.makeText(getApplicationContext(),"Username không được bỏ trống" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if (txtPassword.getText().length() <= 0)
                {
                    Toast.makeText(getApplicationContext(),"Password không được bỏ trống" , Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean ckUser = userData.checkUserExist(txtUserName.getText().toString(),txtPassword.getText().toString());
                if (ckUser == true)
                {
                    Toast.makeText(getApplicationContext(),"Username và Password hợp lệ" , Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Username hoặc Password không hợp lệ" , Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Resintent);
            }
        });
    }
}
