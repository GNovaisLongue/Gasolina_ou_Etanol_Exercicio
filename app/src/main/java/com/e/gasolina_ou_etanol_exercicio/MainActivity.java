
package com.e.gasolina_ou_etanol_exercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private TextView gasValueTextView;
    private TextView ethanolValueTextView;
    private double gasValue = 1.09;
    private double ethanol = 0.95;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TxtView
        gasValueTextView = findViewById(R.id.gasValueTextView);
        ethanolValueTextView = findViewById(R.id.ethanolValueTextView);
        //seekBar
        SeekBar gasSeekBar = findViewById(R.id.gasSeekBar);
        SeekBar ethanolSeekBar = findViewById(R.id.ethanolSeekBar);
        //observer
        gasSeekBar.setOnSeekBarChangeListener(onGasSeekBarChangeListener);
//        ethanolSeekBar.setOnSeekBarChangeListener(onEthanolSeekBarChangeListener);

//        amountEditText.addTextChangedListener(amountEditTextWatcher);



//        public void updateTextView(String toThis) {
//            TextView textView = (TextView) findViewById(R.id.textView);
//            textView.setText(toThis);
//        }
    }

    private SeekBar.OnSeekBarChangeListener onGasSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    if (i == 0){
                        gasValueTextView.setText(currencyFormat.format(gasValue));
                    }
                    gasValue = gasValue * (i / 100);
                    gasValueTextView.setText(currencyFormat.format(gasValue));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
/*
    TextWatcher amountEditTextWatcher =
            new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try{
                        billAmount = Double.parseDouble(charSequence.toString()) / 100;
                        double tip = percent * billAmount;
                        double total = tip + billAmount;
                        tipTextView.setText(currencyFormat.format(tip));
                        totalTextView.setText(currencyFormat.format(total));
                        amountTextView.setText(currencyFormat.format(billAmount));
                    }catch(NumberFormatException e){
                        tipTextView.setText(currencyFormat.format(0d));
                        totalTextView.setText(currencyFormat.format(0d));
                        amountTextView.setText(currencyFormat.format(billAmount));
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            };







*/

}
