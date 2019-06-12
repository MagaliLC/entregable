package com.example.entregable_magali;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        etWeb = findViewById(R.id.web);
    }

    public void showButtonPressed(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String web = etWeb.getText().toString();
        int phone = Integer.parseInt(etPhone.getText().toString());
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("web", web);
        intent.putExtra("phone", phone);
        startActivity(intent);
    }


    public void openDialog(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(getString(R.string.app_name));

        alertDialogBuilder.setMessage(getString(R.string.deleteAllFields)).setCancelable(false)
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int d) {

                        etName.setText("");
                        etSurname.setText("");
                        etPhone.setText("");
                        etWeb.setText("");
                    }
                })

                .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }


    public void sendButtonPressed(View view) {


        if (etName.getText().toString().trim().equalsIgnoreCase("")) {
            etName.setError(getString(R.string.empty));
        } else if (etSurname.getText().toString().trim().equalsIgnoreCase("")) {
            etSurname.setError(getString(R.string.empty));
        } else if (etPhone.getText().toString().trim().equalsIgnoreCase("")) {
            etPhone.setError(getString(R.string.empty));
        } else if (etWeb.getText().toString().trim().equalsIgnoreCase("")) {
            etWeb.setError(getString(R.string.empty));

        } else {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String name = etName.getText().toString();
            String surname = etSurname.getText().toString();
            String web = etWeb.getText().toString();
            int phone = Integer.parseInt(etPhone.getText().toString());
            intent.putExtra("name", name);
            intent.putExtra("surname", surname);
            intent.putExtra("web", web);
            intent.putExtra("phone", phone);
            startActivity(intent);
        }

    }


}
