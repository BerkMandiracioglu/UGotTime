package com.ugottime;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.TabHost;
        import android.widget.Toast;
public class HelpPage extends AppCompatActivity {

    private TabHost tabHost;
    private TabHost.TabSpec aboutUsProperty;
    private TabHost.TabSpec termsConditionsProperty;
    private TabHost.TabSpec howToSignUpProperty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);
        try {

            tabHost = (TabHost) findViewById(R.id.tabhost);
            tabHost.setup();
            aboutUsProperty = tabHost.newTabSpec("AboutUs");
            aboutUsProperty.setContent(R.id.AboutUs);
            aboutUsProperty.setIndicator("About Us");
            tabHost.addTab(aboutUsProperty);
            termsConditionsProperty = tabHost.newTabSpec("TermsConditions");
            termsConditionsProperty.setContent(R.id.TermsConditions);
            termsConditionsProperty.setIndicator("Terms Conditions");
            tabHost.addTab(termsConditionsProperty);
            howToSignUpProperty = tabHost.newTabSpec("HowToSignUp");
            howToSignUpProperty.setContent(R.id.HowToSignUp);
            howToSignUpProperty.setIndicator("How To Sign Up");
            tabHost.addTab(howToSignUpProperty);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
