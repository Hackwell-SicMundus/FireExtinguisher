package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    private static final String TAG = LogInActivity.class.getSimpleName();
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
        Call<List<LoginResponse>> loginDetail = ApiClient.getInventoryService().getLoginDetail(userEmail,userPassword);

        loginDetail.enqueue(new Callback<List<LoginResponse>>() {
            @Override
            public void onResponse(Call<List<LoginResponse>> call, Response<List<LoginResponse>> response) {
                List<LoginResponse> RolesDetails = response.body();
                LoginResponse LoginResponse = RolesDetails.get(0);

                Toast.makeText(LogInActivity.this,  " "+LoginResponse.getRole(), Toast.LENGTH_SHORT).show();

                String Role=LoginResponse.getRole();
                Log.d(TAG,"onSuccess "+Role);

                if(Role.equals("User"))
                {
                    Intent intent = new Intent(LogInActivity.this,UserReportActivity.class);
                    intent.putExtra("userId",LoginResponse.getId());
                    startActivity(intent);
                }
                else if(Role.equals("Worker"))
                {
                    Intent intent = new Intent(LogInActivity.this,ManagementActivity.class);
                    intent.putExtra("userId",LoginResponse.getId());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LogInActivity.this, "not classified user", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<LoginResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: api not working "+t);
            }
        });



    }



    @Override
    protected void onStart() {
        super.onStart();


    }


}