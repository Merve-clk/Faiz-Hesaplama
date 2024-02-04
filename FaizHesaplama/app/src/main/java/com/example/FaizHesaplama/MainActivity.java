package com.example.FaizHesaplama;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faizhesaplama.R;

public class MainActivity extends AppCompatActivity {

    EditText edt_fiyat, edt_kdv;
    Button edt_hesapla;
    Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_fiyat = findViewById(R.id.edt_fiyat);
        edt_kdv = findViewById(R.id.edt_kdv);
        edt_hesapla = findViewById(R.id.edt_hesapla);

        edt_hesapla.setOnClickListener(v -> {

            int fiyat = Integer.parseInt(edt_fiyat.getText().toString());
            int kdv = Integer.parseInt(edt_kdv.getText().toString());

            int toplam_fiyat = ((fiyat * kdv) / 100) + fiyat;

            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.custom_dialog);

            ImageView carpi = dialog.findViewById(R.id.carpi);
            TextView aciklama = dialog.findViewById(R.id.aciklama);
            Button tamam = dialog.findViewById(R.id.tamam);

            aciklama.setText("Girilen Fiyat:" + fiyat + "\n" + "Kdv Oranı:" + kdv + "\n" + "Toplam Fiyat:" + toplam_fiyat);

            carpi.setOnClickListener(v1 -> dialog.dismiss());

            tamam.setOnClickListener(v12 -> {
                Toast.makeText(MainActivity.this, "Belge İncelendi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}
