package com.walkiriaapps.tema1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int ACTIVITY_TWO = 1;
    private Button button;
    private TextView textLabel;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY_TWO && resultCode == Activity.RESULT_OK)
        {
            textLabel.setText("Has clicado " + data.getIntExtra("result", 0) +" veces");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textLabel = findViewById(R.id.label);

        button.setText("Ir al contador");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AuxiliarActivity.class);
                startActivityForResult(i, ACTIVITY_TWO);
            }
        });
    }


}