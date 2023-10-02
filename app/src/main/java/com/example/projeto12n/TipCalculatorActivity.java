package com.example.projeto12n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText editTextValor;
    private SeekBar seekBar;
    private TextView textViewValor;
    private TextView textViewGorjeta;
    private TextView textViewTotal;
    private TextView textViewPct;
    private Double porcentagem = 0.0;
    private Double valor = 0.0;
    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat =
            NumberFormat.getPercentInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        editTextValor = findViewById(R.id.editTextValor);
        seekBar = findViewById(R.id.seekBar);
        textViewValor = findViewById(R.id.textViewValor);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewPct = findViewById(R.id.textViewPct);
        editTextValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int valorInt;
                try {
                    valorInt = Integer.parseInt(editTextValor.getText().toString());
                } catch( NumberFormatException e ) {
                    valorInt = 0;
                }
                valor = valorInt/100.0;
                atualizarValores();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress/100.0;
                atualizarValores();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void atualizarValores() {
        textViewValor.setText(currencyFormat.format(valor));
        textViewPct.setText(percentFormat.format(porcentagem));
        double gorjeta = valor * porcentagem;
        textViewGorjeta.setText(currencyFormat.format(gorjeta));
        double total = valor + gorjeta;
        textViewTotal.setText(currencyFormat.format(total));
    }
}




