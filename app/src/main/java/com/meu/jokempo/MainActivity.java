package com.meu.jokempo;

import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView saida, saida2;
    private RadioButton pedra, papel, tesoura;
    private ImageView jogador1, oponente1;
    private ScrollView fundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        saida = findViewById(R.id.resposta);
        saida2 = findViewById(R.id.saida2);
        pedra = findViewById(R.id.radioPedra);
        papel = findViewById(R.id.radioPapel);
        tesoura = findViewById(R.id.radioTesoura);
        jogador1 = findViewById(R.id.imageJogador);
        oponente1 = findViewById(R.id.imageOponente);
        fundo = findViewById(R.id.scroll);

        Button btPlay = findViewById(R.id.btJoga);
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();

                int player = 0, maquina ;
                if(pedra.isChecked()){
                    jogador1.setBackgroundResource(R.drawable.pedra);
                    maquina = random.nextInt(3);
                    player = 0;
                    if(player == maquina){
                        oponente1.setBackgroundResource(R.drawable.pedra);
                        saida.setText("Jogamos iguais camarada");
                        saida2.setText("Vamos tentar denovo");
                        fundo.setBackgroundResource(R.color.gray);
                    }else if(player == 0 && maquina ==1){
                        oponente1.setBackgroundResource(R.drawable.papel);
                        saida.setText("Perdeu");
                        saida2.setText("Embrulhei sua pedra");
                        fundo.setBackgroundResource(R.color.red);
                    }else if(player ==0 && maquina ==2){
                        oponente1.setBackgroundResource(R.drawable.tesoura);
                        saida.setText("Ganhou");
                        saida2.setText("Quebrou minha tesoura");
                        fundo.setBackgroundResource(R.color.green);
                    }

                }else if (papel.isChecked()){
                    jogador1.setBackgroundResource(R.drawable.papel);
                    maquina = random.nextInt(3);
                    player = 1;
                    if(player == maquina){
                        oponente1.setBackgroundResource(R.drawable.papel);
                        saida.setText("Jogamos iguais camarada");
                        saida2.setText("Vamos tentar denovo");
                        fundo.setBackgroundResource(R.color.gray);
                    }else if(player == 1 && maquina == 0){
                        oponente1.setBackgroundResource(R.drawable.pedra);
                        saida.setText("Ganhou");
                        saida2.setText("Embrulhou minha pedra");
                        fundo.setBackgroundResource(R.color.green);
                    }else if(player ==1 && maquina ==2){
                        oponente1.setBackgroundResource(R.drawable.tesoura);
                        saida.setText("Perdeu");
                        saida2.setText("Cortei seu papel");
                        fundo.setBackgroundResource(R.color.red);
                    }
                    //0=pedra
                    //1=papel
                    //2=tesoura
                }else if(tesoura.isChecked()){
                    jogador1.setBackgroundResource(R.drawable.tesoura);
                    maquina = random.nextInt(3);
                    player = 2;
                    if(player == maquina){
                        oponente1.setBackgroundResource(R.drawable.tesoura);
                        saida.setText("Jogamos iguais camarada");
                        saida2.setText("Vamos tentar denovo");
                        fundo.setBackgroundResource(R.color.gray);
                    }else if(player == 2 && maquina ==1){
                        oponente1.setBackgroundResource(R.drawable.papel);
                        saida.setText("Ganhou");
                        saida2.setText("Cortou meu papel");
                        fundo.setBackgroundResource(R.color.green);
                    }else if(player ==2 && maquina ==0){
                        oponente1.setBackgroundResource(R.drawable.pedra);
                        saida.setText("Perdeu");
                        saida2.setText("Quebrei sua tesoura");
                        fundo.setBackgroundResource(R.color.red);
                    }

                }else{
                    Snackbar.make(view,"Escolha pedra papel ou tesoura",Snackbar.LENGTH_SHORT).show();

                }




            }
        });

    }
}