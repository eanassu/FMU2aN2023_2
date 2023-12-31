package com.example.projeto12n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText;
    private EditText editTextText2;
    private EditText editTextText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
    }

    public void click( View view ) {
        int x, y, soma;
        x = Integer.parseInt(editTextText.getText().toString());
        y = Integer.parseInt(editTextText2.getText().toString());
        soma = x + y;
        editTextText3.setText(Integer.toString(soma));
    }

    public void abrirOutraJanela(View view ) {
        int x, y, soma;
        x = Integer.parseInt(editTextText.getText().toString());
        y = Integer.parseInt(editTextText2.getText().toString());
        soma = x + y;
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("soma", soma);
        startActivity(intent);
    }

    public void abrirTipCalculator(View view) {
        Intent intent = new Intent(this,TipCalculatorActivity.class);
        startActivity(intent);
    }

    public void abrirDesenho(View view) {
        Intent intent = new Intent(this, DesenhoActivity.class);
        startActivity(intent);
    }

    public void abrirDatabase( View view ) {
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }

    public void abrirSensores( View view ) {
        Intent intent = new Intent(this, SensorActivity.class);
        startActivity(intent);
    }

    public void abrirHttp( View view ) {
        Intent intent = new Intent(this, HttpActivity.class);
        startActivity(intent);
    }
}