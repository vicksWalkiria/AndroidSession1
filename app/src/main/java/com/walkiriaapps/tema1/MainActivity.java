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
    private int ACTIVITY_THREE =2;
    private Button button;
    private TextView textLabel;
    private Button button2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY_TWO && resultCode == Activity.RESULT_OK)
        {
            textLabel.setText("Has clicado " + data.getIntExtra("result", -1) +" veces");
        }
        if(requestCode == ACTIVITY_THREE && resultCode == Activity.RESULT_OK)
        {
            textLabel.setText("Aux. 2. El resultado es: " + data.getIntExtra("result", -1) +" veces");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textLabel = findViewById(R.id.label);
        button2 = findViewById(R.id.button2);



        button.setText("Ir al contador");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AuxiliarActivity.class);
                startActivityForResult(i, ACTIVITY_TWO);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AuxiliarActivity2.class);
                startActivityForResult(i, ACTIVITY_THREE);
            }
        });
    }


}