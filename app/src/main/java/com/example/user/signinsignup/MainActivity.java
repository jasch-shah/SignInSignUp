package com.example.user.signinsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView welcome;
    private Button register;
    private Button login;
    private Button update;
    private Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = (Button)findViewById(R.id.register);
        login = (Button)findViewById(R.id.login);
        delete = (Button)findViewById(R.id.delete);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedLogin();
            }
        });

        update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedUpdate();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedDelete();
            }
        });

    }

    private void clickedDelete() {

        Intent intent = new Intent(this,DeleteActivity.class);
        startActivity(intent);
    }

    private void clickedUpdate() {
        Intent intent = new Intent(this,UpdateActivity.class);
        startActivity(intent);
    }

    private void clickedLogin() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void clickedRegister(View view){
        Intent intent = new Intent(this,RegistrationActivity.class);
        startActivity(intent);
    }

}
