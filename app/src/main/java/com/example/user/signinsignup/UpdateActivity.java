package com.example.user.signinsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputEmail;
    private EditText inputMobile;
    private EditText inputPassword;

    private Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        inputName=(EditText)findViewById(R.id.name);
        inputMobile=(EditText)findViewById(R.id.mobile);
        inputEmail=(EditText)findViewById(R.id.email);
        inputPassword=(EditText)findViewById(R.id.password);
        update = (Button)findViewById(R.id.updateBtn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateUser();
            }
        });



    }

    private void updateUser() {

        String name = inputName.getText().toString().trim();
        String mobile = inputMobile.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        Service service = ApiClient.getRetrofit().create(Service.class);
        Call<UpdatePojo> updatePojoCall =service.updateUser(name,mobile,email,password);

        updatePojoCall.enqueue(new Callback<UpdatePojo>() {
            @Override
            public void onResponse(Call<UpdatePojo> call, Response<UpdatePojo> response) {

                UpdatePojo updatePojo = response.body();

                assert updatePojo != null;

                if(updatePojo.getCode().equals("1")){
                    Toast.makeText(UpdateActivity.this, updatePojo.getMsg(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(UpdateActivity.this, updatePojo.getMsg(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<UpdatePojo> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Fail", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
