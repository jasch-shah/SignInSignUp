package com.example.user.signinsignup;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AfterLogin extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        text = (TextView)findViewById(R.id.afterLogin);

        String fontPath = "fonts\\grand.otf";

        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);

        text.setTypeface(tf);
    }
}
