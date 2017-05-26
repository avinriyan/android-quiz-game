package com.example.asus.kuis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class IsianSingkat extends AppCompatActivity {

    Button btnJawab;
    EditText etJawab;
    TextView soal, score;

    private Soal msoal = new Soal();

    private String mJawaban;
    private int mScore = 0;
    private int PanjangSoal = msoal.Soal.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isian_singkat);

        r = new Random();

        btnJawab = (Button)findViewById(R.id.btnJawab);
        soal = (TextView) findViewById(R.id.soal);
        score = (TextView) findViewById(R.id.skor);
        etJawab = (EditText) findViewById(R.id.etJawab);

        updatesoal(r.nextInt(PanjangSoal));

        btnJawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etJawab.getText().toString().equals(mJawaban)){
                    mScore++;
                    score.setText("Score: "+mScore);
                    etJawab.setText("");
                    updatesoal(r.nextInt(PanjangSoal));
                }else{
                    gameOver();
                }
            }
        });
    }

    private void updatesoal(int num){
        soal.setText(msoal.Koreksi2(num));
        mJawaban = msoal.JawabanBener2(num);
    }

    private void gameOver(){
        AlertDialog.Builder peringatan = new AlertDialog.Builder(IsianSingkat.this);
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
