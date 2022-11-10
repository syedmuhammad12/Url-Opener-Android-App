package com.example.urlopener;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button) findViewById(R.id.button);
        EditText ent_url = (EditText) findViewById(R.id.editTextTextPersonName);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = ent_url.getText().toString();
                if (url.startsWith("http")){
                    try {
                        Uri web = Uri.parse(url);
                        Intent intent = new Intent(Intent.ACTION_VIEW, web);
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Enter valid url", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter valid url", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}