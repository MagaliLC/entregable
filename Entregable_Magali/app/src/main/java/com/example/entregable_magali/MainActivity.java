package com.example.entregable_magali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etSurname;
    EditText etPhone;
    EditText etWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         etName = findViewById(R.id.name);
         etSurname = findViewById(R.id.surname);
         etPhone = findViewById(R.id.phone);
         etWeb= findViewById(R.id.web);
    }

    public void showButtonPressed(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String web = etWeb.getText().toString();
        int phone = Integer.parseInt(etPhone.getText().toString());
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("web", web);
        intent.putExtra("phone",phone);
        startActivity(intent);
    }

}
