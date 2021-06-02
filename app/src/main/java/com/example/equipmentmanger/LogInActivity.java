package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private static final String TAG = LogInActivity.class.getSimpleName();
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String USER_EMAIL = "userEmail";

    private Button logInButton;
    private TextView signUpButton;
    private EditText mUserEmail;
    private EditText mUserPassword;

    String userEmail;
    String userPassword;

    public String mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        mUserEmail = findViewById(R.id.logIn_userMail);
        mUserPassword = findViewById(R.id.logIn_userPassword);

        logInButton = findViewById(R.id.logIn_button);
        signUpButton = findViewById(R.id.logIn_signUp_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userEmail=mUserEmail.getText().toString();
                userPassword=mUserPassword.getText().toString();
                if(userEmail.isEmpty()) {
                    mUserEmail.setError("Please Enter the email");
                    mUserEmail.requestFocus();
                }
                else if(userPassword.isEmpty()) {
                    mUserPassword.setError("Please Enter the Password");
                    mUserPassword.requestFocus();
                }
                else if(userPassword.isEmpty()&&userEmail.isEmpty())
                {
                    Toast.makeText(LogInActivity.this,"fill all the fields",Toast.LENGTH_SHORT).show();
                }

                else
                {
                    getLoginStatus();
                }

            }
        });

    }

    // Authenticate the user by sending request
    private void getLoginStatus() {


    }

    @Override
    protected void onStart() {
        super.onStart();

        loadUserEmail();
        //   Toast.makeText(this, mCurrentUser, Toast.LENGTH_SHORT).show();

        if(mCurrentUser!=null)
        {
            finish();
        }

    }

    public void loadUserEmail()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        mCurrentUser = sharedPreferences.getString(USER_EMAIL, null);
    }

}