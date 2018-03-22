package com.example.user.signinsignup;

import android.app.ProgressDialog;
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

public class RegistrationActivity extends AppCompatActivity {

        private static final String TAG = RegistrationActivity.class.getSimpleName();
        private Button register ;
        private EditText inputName;
        private EditText inputMobile;
        private EditText inputEmail;
        //private EditText inputUsername;
        private EditText inputPassword;
  //      private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        inputName = (EditText)findViewById(R.id.name);
        inputEmail = (EditText)findViewById(R.id.email);
        inputMobile = (EditText)findViewById(R.id.mobile);
        //inputUsername = (EditText)findViewById(R.id.username);
        inputPassword = (EditText)findViewById(R.id.password);
        register = (Button)findViewById(R.id.registerBtn);





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             registerUser();
            }
        });



    }

    private void registerUser() {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString().trim();
        String mobile = inputMobile.getText().toString().trim();



        Service service = ApiClient.getRetrofit().create(Service.class);
        Call<RegisterPojo> registerPojoCall =service.registerUser(name,email,password,mobile);
        registerPojoCall.enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {

                RegisterPojo registerPojo = response.body();
                Toast.makeText(RegistrationActivity.this, "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, "Fail", Toast.LENGTH_SHORT).show();

            }
        });
    }


      /* String name = inputName.getText().toString().trim();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString().trim();


                if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    registerUser(name,email,password);
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter your details..", Toast.LENGTH_LONG).show();
                }*/
}
