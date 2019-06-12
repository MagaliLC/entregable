package com.example.entregable_magali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvSurname;
    TextView tvWeb;
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        String web = getIntent().getStringExtra("web");
        int phone = getIntent().getIntExtra("phone",0);

        tvName.setText(name);
        tvSurname.setText(surname);
        tvWeb.setText(web);
        tvPhone.setText(phone);
    }
}
