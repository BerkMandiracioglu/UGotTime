package com.ugottime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ugottime.LocalStore.UserLocalStore;

public class SearchedUserMoreInformationPage extends AppCompatActivity {
    //Variables
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_user_more_information_page);

        //Get the extras from the intent
        final Intent intent = getIntent();


        //Now it is time to find the TextViews
        final TextView fName = (TextView)findViewById(R.id.fName);
        final TextView fSurname = (TextView)findViewById(R.id.fSurname);
        final TextView fDepartment = (TextView)findViewById(R.id.fDp);
        final TextView fEmail = (TextView)findViewById(R.id.fEmail);
        final TextView fRank = (TextView)findViewById(R.id.fRank);

        //We find the TextView now we will get the user's data from intent

        final String name = intent.getStringExtra("fName");
        final String surname = intent.getStringExtra("fSurname");
        final String department = intent.getStringExtra("fDp");
        final String email = intent.getStringExtra("fEmail");
        final String userRank = intent.getStringExtra("fId");

        //Now we can set the Texts

        fName.setText(name);
        fSurname.setText(surname);
        fDepartment.setText(department);
        fEmail.setText(email);
        fRank.setText("User Rank : " + userRank);
    }
}
