package com.example.entregable_magali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvSurname;
    TextView tvWeb;
    TextView tvPhone;
    TextView tvCounter;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvName = findViewById(R.id.name);
        tvSurname = findViewById(R.id.surname);
        tvWeb = findViewById(R.id.web);
        tvPhone = findViewById(R.id.phone);
        tvCounter = findViewById(R.id.counter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Formulario");


        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        String web = getIntent().getStringExtra("web");
        int phone = getIntent().getIntExtra("phone", 0);

        tvName.setText(name);
        tvSurname.setText(surname);
        tvWeb.setText(web);
        tvPhone.setText(String.valueOf(phone));

        updateCounter();

    }


    public void clickOnWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String web = tvWeb.getText().toString();
        intent.setData(Uri.parse(web));
        startActivity(intent);
    }

    public void clickOnPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String phone = tvPhone.getText().toString();
        intent.setData(Uri.parse("tel:" + phone));

        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void setText() {

    }

    private void updateCounter() {
        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int counter = prefs.getInt("counter", 0);
        counter++;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("counter", counter);
        editor.commit();
        tvCounter.setText(String.valueOf(prefs.getInt("counter", 0)));
    }
}


