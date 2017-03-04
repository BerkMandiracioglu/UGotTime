        package com.ugottime;


        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.content.Intent;

        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import android.widget.EditText;

        import com.android.volley.toolbox.Volley;
        import com.ugottime.Request.SignUpRequest;

        import org.json.JSONException;
        import org.json.JSONObject;

        public class SignIn extends AppCompatActivity{

            private Button signButton;
            private EditText name_field;
            private EditText surname_field;
            private EditText email_field;
            private EditText password_field;
            private EditText re_enter_pass_field;
            private EditText department_field;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_sign_in);


                name_field = (EditText) findViewById(R.id.name_field);
                surname_field = (EditText) findViewById(R.id.surname_field);
                email_field = (EditText) findViewById(R.id.email_field);
                password_field = (EditText) findViewById(R.id.password_field);
                re_enter_pass_field = (EditText) findViewById(R.id.re_enter_pass_field);
                department_field = (EditText) findViewById(R.id.department_field);
                signButton = (Button)findViewById(R.id.sign_in_confirm);
                signButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String name = name_field.getText().toString();
                        final String surname = surname_field.getText().toString();
                        final String email = email_field.getText().toString();
                        final String password = password_field.getText().toString();
                        final String dp = department_field.getText().toString();


                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");
                                    if (success) {

                                        Intent intent = new Intent(SignIn.this, LoginActivity.class);
                                        SignIn.this.startActivity(intent);
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(SignIn.this);
                                        builder.setMessage("Register Failed")
                                                .setNegativeButton("Retry", null)
                                                .create()
                                                .show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };

                        SignUpRequest signUpRequest = new SignUpRequest(name, surname, email, password,dp, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SignIn.this);
                        queue.add(signUpRequest);
                    }

                });
            }





        }





