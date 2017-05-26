package com.example.asus.kuis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class BenarSalah extends AppCompatActivity {

    Button btnJawab;
    RadioGroup rg;
    TextView soal, score;
    private Soal msoal = new Soal();

    private String mJawaban;
    private int mScore = 0;
    private int PanjangSoal = msoal.Soal.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benar_salah);

        r = new Random();

        btnJawab = (Button)findViewById(R.id.btnJawab);
        soal = (TextView) findViewById(R.id.soal);
        score = (TextView) findViewById(R.id.skor);

        rg = (RadioGroup) findViewById(R.id.rg);


        updatesoal(r.nextInt(PanjangSoal));

        btnJawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        int selectedId = rg.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton)findViewById(selectedId);
                if (radioButton.getText().toString().equals(mJawaban)){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updatesoal(r.nextInt(PanjangSoal));
                    radioButton.setChecked(false);
                }else{
                    gameOver();
                }

            }
        });

    }
    private void updatesoal(int num){
        soal.setText(msoal.Koreksi3(num));
        mJawaban = msoal.JawabanBener3(num);
    }

    private void gameOver(){
        AlertDialog.Builder peringatan = new AlertDialog.Builder(BenarSalah.this);
        peringatan
                .setMessage("Game Over! skor= "+mScore+" poin")
                .setCancelable(false)
                .setPositiveButton("Ulangi??",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), Menu.class));
                            }
                        })
                .setNegativeButton("Kluar??",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
        AlertDialog alertDialog=peringatan.create();
        alertDialog.show();
    }
}
