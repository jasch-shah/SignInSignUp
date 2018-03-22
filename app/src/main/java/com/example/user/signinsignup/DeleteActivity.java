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

public class DeleteActivity extends AppCompatActivity {

    private EditText inputName;
    private Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        inputName=(EditText)findViewById(R.id.name);
        delete = (Button)findViewById(R.id.deleteBtn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser();
            }
        });
    }

    private void deleteUser() {

        String name = inputName.getText().toString().trim();

        Service service = ApiClient.getRetrofit().create(Service.class);
        Call<DeletePojo> deletePojoCall =service.deleteUser(name);

        deletePojoCall.enqueue(new Callback<DeletePojo>() {
            @Override
            public void onResponse(Call<DeletePojo> call, Response<DeletePojo> response) {

                DeletePojo deletePojo = response.body();

                assert deletePojo != null;

                if(deletePojo.getCode().equals("1")){
                    Toast.makeText(DeleteActivity.this, deletePojo.getMsg(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(DeleteActivity.this, deletePojo.getMsg(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<DeletePojo> call, Throwable t) {
                Toast.makeText(DeleteActivity.this, "Fail", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
