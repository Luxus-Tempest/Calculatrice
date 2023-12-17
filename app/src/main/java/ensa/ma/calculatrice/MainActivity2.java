package ensa.ma.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ensa.ma.calculatrice.data.MyDataBaseHelper;

public class MainActivity2 extends AppCompatActivity {

    EditText email;
    EditText username;
    EditText password;
    Button loginButton;
    Intent intent ;
    TextView signin_link ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.email);
        //username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signin_link = findViewById(R.id.signupText);

        /*loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Login Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });*/

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = email.getText().toString().trim();
                String passwordValue = password.getText().toString().trim();

                MyDataBaseHelper myDB = new MyDataBaseHelper(MainActivity2.this);

                if (myDB.checkUser(emailValue, passwordValue)) {
                    Toast.makeText(MainActivity2.this, "Welcome to your Calculator !", Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signin_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

    }
}