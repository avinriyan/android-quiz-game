package com.example.asus.kuis;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnA, btnB, btnC, btnD;
    TextView soal, score;

    private Soal msoal = new Soal();

    private String mJawaban;
    private int mScore = 0;
    private int PanjangSoal = msoal.Soal.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        btnA = (Button)findViewById(R.id.btnA);
        btnB = (Button)findViewById(R.id.btnB);
        btnC = (Button)findViewById(R.id.btnC);
        btnD = (Button)findViewById(R.id.btnD);

        soal = (TextView) findViewById(R.id.soal);
        score = (TextView) findViewById(R.id.skor);

        updatesoal(r.nextInt(PanjangSoal));

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnA.getText() == mJawaban){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updatesoal(r.nextInt(PanjangSoal));

                }else{
                    gameOver();
                }
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnB.getText() == mJawaban){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updatesoal(r.nextInt(PanjangSoal));

                }else{
                    gameOver();
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnC.getText() == mJawaban){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updatesoal(r.nextInt(PanjangSoal));
                }else{
                    gameOver();
                }
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnD.getText() == mJawaban){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updatesoal(r.nextInt(PanjangSoal));

                }else{
                    gameOver();
                }
            }
        });
    }

    private void updatesoal(int num){
        soal.setText(msoal.Koreksi(num));
        btnA.setText(msoal.Milih1(num));
        btnB.setText(msoal.Milih2(num));
        btnC.setText(msoal.Milih3(num));
        btnD.setText(msoal.Milih4(num));

        mJawaban = msoal.JawabanBener(num);
    }

    private void gameOver(){
        AlertDialog.Builder peringatan = new AlertDialog.Builder(MainActivity.this);
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
