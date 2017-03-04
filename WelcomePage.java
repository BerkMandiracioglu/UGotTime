package com.ugottime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;

public class WelcomePage extends AppCompatActivity implements OnClickListener{


    private Button goLog;
    private Button goSign;
    private Button goHelp;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        goLog = (Button)findViewById(R.id.welcome_login_button);
        goSign = (Button)findViewById(R.id.welcome_sign_in_button);
        goHelp = (Button)findViewById(R.id.help_button);
        imageView = (ImageView)findViewById(R.id.logo);
        imageView.setImageResource(R.drawable.ugt_logo);
        goLog.setOnClickListener(this);
        goSign.setOnClickListener(this);
        goHelp.setOnClickListener(this);

            }

    @Override
    public void onClick(View view) {
        if(view == goLog) {
            Intent intent = new Intent(WelcomePage.this, LoginActivity.class);
            startActivity(intent);
        }
        else if(view == goSign) {
                Intent intent = new Intent(WelcomePage.this, SignIn.class);
                startActivity(intent);
        }

        }

    }










