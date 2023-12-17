package ensa.ma.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ensa.ma.calculatrice.data.MyDataBaseHelper;

public class MainActivity3 extends AppCompatActivity {

    TextView login_link;

    EditText nom;
    EditText prenom;
    EditText password;
    EditText email;
    Button register_button;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        login_link = findViewById(R.id.login_link);

        nom = findViewById(R.id.lastname);
        prenom = findViewById(R.id.firstname);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        register_button = findViewById(R.id.registerButton);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDataBaseHelper myDB = new MyDataBaseHelper(MainActivity3.this);
                myDB.addUser(
                        nom.getText().toString().trim(),
                        prenom.getText().toString().trim(),
                        email.getText().toString().trim(),
                        password.getText().toString().trim()
                );
            }
        });

        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}