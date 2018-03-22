package com.example.user.signinsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;
    private Button login;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = (EditText)findViewById(R.id.email);
        inputPassword = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setProgress(100);
                loginUser();
            }
        });



    }

    private void loginUser() {

        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        Service service = ApiClient.getRetrofit().create(Service.class);
        Call<LoginPojo> loginPojoCall =service.loginUser(email,password);

        loginPojoCall.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {

                LoginPojo loginPojo = response.body();

                assert loginPojo != null;


                if(loginPojo.getCode().equals("1")){
                    Toast.makeText(LoginActivity.this, loginPojo.getMsg(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(LoginActivity.this, loginPojo.getMsg(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Fail", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
