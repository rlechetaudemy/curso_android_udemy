package com.example.helloandroidstudio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = findViewById(R.id.btLogin);
        btLogin.setOnClickListener(v -> onClickLogin());
    }

    private void onClickLogin() {
        TextView tLogin = findViewById(R.id.tLogin);
        TextView tSenha = findViewById(R.id.tSenha);

        String login = tLogin.getText().toString();
        String senha = tSenha.getText().toString();

        if(login.equals("ricardo") && senha.equals("123")) {
            Log.d("udemy","Login efetuado com sucesso");

            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra("nome","Ricardo R Lecheta");
            startActivity(intent);

        } else {
            Log.d("udemy","Login incorreto");

            alert(R.string.msg_erro_login);
        }
    }

    private void alert(int msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage(msg);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
