
package com.e.gasolina_ou_etanol_exercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private TextView gasValueTextView;
    private TextView ethanolValueTextView;
    private TextView answerTextView;
    private ImageView imageView;
    private double gas = 1.09;
    private double gasValue = 1.09;
    private double ethanol = 0.95;
    private double ethanolValue = 0.95;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImgView
        imageView = findViewById(R.id.imageView);
        //TxtView
        gasValueTextView = findViewById(R.id.gasValueTextView);
        ethanolValueTextView = findViewById(R.id.ethanolValueTextView);
        answerTextView = findViewById(R.id.ansTextView);
        //seekBar
        SeekBar gasSeekBar = findViewById(R.id.gasSeekBar);
        SeekBar ethanolSeekBar = findViewById(R.id.ethanolSeekBar);
        //SeekBar observer
        gasSeekBar.setOnSeekBarChangeListener(onGasSeekBarChangeListener);
        ethanolSeekBar.setOnSeekBarChangeListener(onEthanolSeekBarChangeListener);

    }

    public void gas_or_ethanol(){
        if(ethanolValue/gasValue>=0.7){
            answerTextView.setText(getString(R.string.gasAnswer));
            imageView.setImageResource(R.drawable.gasoline);
            imageView.setContentDescription(getString(R.string.gasAnswer));
        }
        else{
            answerTextView.setText(getString(R.string.ethanolAnswer));
            imageView.setImageResource(R.drawable.ethanol);
            imageView.setContentDescription(getString(R.string.ethanolAnswer));
        }
    }

    private SeekBar.OnSeekBarChangeListener onGasSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    gasValue = (gas * (i + 1.0));
                    gasValueTextView.setText(currencyFormat.format(gasValue));
                    gas_or_ethanol();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

    private SeekBar.OnSeekBarChangeListener onEthanolSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    ethanolValue = (ethanol * (i + 1.0));
                    ethanolValueTextView.setText(currencyFormat.format(ethanolValue));
                    gas_or_ethanol();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

}
