package com.ugottime;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.ugottime.Request.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.ugottime.LocalStore.UserLocalStore;

public class LoginActivity extends AppCompatActivity{

    private Button goLog;
    private Button goSign;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailText = (EditText) findViewById(R.id.login_mail);
        final EditText passwordText = (EditText) findViewById(R.id.login_pw);
        goLog = (Button)findViewById(R.id.loginButton);
        goSign =(Button)findViewById(R.id.log_sign_up_button);
        userLocalStore = new UserLocalStore(this);

        goLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String u_email = emailText.getText().toString();
                assert passwordText != null;
                final String u_pw = passwordText.getText().toString();


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    String u_id = jsonResponse.getString("u_id");
                                    String name = jsonResponse.getString("u_name");
                                    String surname = jsonResponse.getString("u_lname");
                                    String email = jsonResponse.getString("u_email");
                                    String password = jsonResponse.getString("u_pw");
                                    String department = jsonResponse.getString("u_dp");


                                    Intent intent = new Intent(LoginActivity.this, MainUserPage.class);

                                    User user = new User(u_id, name, surname, email, password, department);
                                    userLocalStore.storeUserData(user);
                                    userLocalStore.setUserLoggedIn(true);

                                    LoginActivity.this.startActivity(intent);
                                    finish();
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("Login Failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    LoginRequest loginRequest = new LoginRequest(u_email, u_pw, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);

                }

        });
        goSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignIn.class);
                startActivity(intent);
                finish();
            }

        });



}
}