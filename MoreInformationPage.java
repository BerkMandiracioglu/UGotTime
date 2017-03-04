package com.ugottime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ugottime.LocalStore.UserLocalStore;

public class MoreInformationPage extends AppCompatActivity {
    //Variables
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information_page);

        //Get the user's information to the more information page
        //by  calling the local store
        //which contains the sharedPreferences
        userLocalStore = new UserLocalStore(this);

        //We can define user as a final since it would not change in this table
        final User user = userLocalStore.getLoggedInUser();

        //Now it is time to find the TextViews
        final TextView mName = (TextView)findViewById(R.id.mName);
        final TextView mSurname = (TextView)findViewById(R.id.fSurname);
        final TextView mDepartment = (TextView)findViewById(R.id.fDp);
        final TextView mEmail = (TextView)findViewById(R.id.fEmail);
        final TextView uRank = (TextView)findViewById(R.id.userRank);

        //We find the TextView now we will get the user's data from localDataStore

        final String name = user.getName();
        final String surname = user.getSurname();
        final String department = user.getDepartment();
        final String email = user.getEmail();
        final String userRank = user.getId();

        //Now we can set the Texts

        mName.setText(name);
        mSurname.setText(surname);
        mDepartment.setText(department);
        mEmail.setText(email);
        uRank.setText("User Rank : " + userRank);
    }
}
