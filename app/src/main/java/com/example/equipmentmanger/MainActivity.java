package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   // public String mCurrentUser;
  //  public int userId;

   // private static final String SHARED_PREFS = "sharedPrefs";
  //  private static final String USER_EMAIL = "userEmail";
  //  private static final String TAG = MainActivity.class.getSimpleName();

   // Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   logOutButton.findViewById(R.id.logOut_button);

   /*     logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });*/

    }

   /* public void loadUserEmail()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        mCurrentUser = sharedPreferences.getString(USER_EMAIL, null);
    }*/


    @Override
    protected void onStart() {
        super.onStart();
     //   loadUserEmail();


        sendUserToLogIn();


    }

    private void sendUserToLogIn() {
        Intent intent = new Intent(MainActivity.this,LogInActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        finish();
    }
}