package com.example.androiddasar2userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText adSisi;
    Button btnHitung;
    TextView tvHasil;
    Spinner spinerpilihan;
    String[] pilihanHitung = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adSisi = findViewById(R.id.ed_sisi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        spinerpilihan = findViewById(R.id.spinner_pilihan);

        btnHitung.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v){
               if (spinerpilihan.getSelectedItem().toString().equals(pilihanHitung[0])) {
                   rumusVolume();
               } else if (spinerpilihan.getSelectedItem().toString().equals(pilihanHitung[1])) {
                   Double sisi = Double.valueOf(adSisi.getText().toString());
                   rumusKeliling(sisi);
               }else if (spinerpilihan.getSelectedItem().toString().equals(pilihanHitung[2])) {

                   Double hasil = rumusLuasPermukaan();
                   tvHasil.setText(hasil.toString());
               }
           }
        });

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihanHitung);
        spinerpilihan.setAdapter(adapter);
    }

    private Double rumusLuasPermukaan() {
        Double sisi = Double.valueOf(adSisi.getText().toString());
        Double hasil = 6 * sisi * sisi;
        return hasil;
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 12 * sisi ;
        tvHasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(adSisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        tvHasil.setText(hasil.toString());
    }
}
