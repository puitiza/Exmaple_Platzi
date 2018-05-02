package pe.anthony.platzi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.anthony.platzi.view.ContainerActivity;
import pe.anthony.platzi.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    TextView txt_create_Account;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_create_Account = (TextView) findViewById(R.id.txt_CreateHere);
        txt_create_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        btn_login= (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ContainerActivity.class);
                startActivity(intent);
            }
        });
    }
}
