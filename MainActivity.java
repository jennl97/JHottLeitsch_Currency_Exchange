package com.example.jenniferhott_leitsch.jhott_leitsch_currency_exchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 1.16;
    double currencyEntered = 0.00;
    double convertedCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText measure = (EditText) findViewById(R.id.currencyText);
        final RadioButton dollarsToEuro = (RadioButton) findViewById(R.id.radDollars);
        final RadioButton eurosToDollars = (RadioButton) findViewById(R.id.radEuros);
        final TextView results = (TextView) findViewById(R.id.textResult);
        Button convert = (Button) findViewById(R.id.convertButton);

        convert.setOnClickListener((View view) -> {
            currencyEntered = Double.parseDouble(measure.getText().toString());
            DecimalFormat tenth = new DecimalFormat("#.##");
            if (dollarsToEuro.isChecked()) {
                if (currencyEntered >0){
                convertedCurrency = currencyEntered / conversionRate;
                results.setText(tenth.format(convertedCurrency) + " Euros");
            } else {
                Toast.makeText(MainActivity.this, "Please enter a value greater than 0", Toast.LENGTH_LONG).show();
                }
            }

            if (eurosToDollars.isChecked()) {
                if (currencyEntered >0){
                    convertedCurrency = conversionRate * currencyEntered;
                    results.setText(tenth.format(convertedCurrency) + " Dollars");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a value greater than 0", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

