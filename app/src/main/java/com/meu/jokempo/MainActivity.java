package com.meu.jokempo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView saida, saida2, homem, computador;
    private RadioButton pedra, papel, tesoura;
    private ImageView jogador1, oponente1;
    private ScrollView fundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();


        saida = findViewById(R.id.resposta);
        saida2 = findViewById(R.id.saida2);
        pedra = findViewById(R.id.radioPedra);
        papel = findViewById(R.id.radioPapel);
        tesoura = findViewById(R.id.radioTesoura);
        jogador1 = findViewById(R.id.imageJogador);
        oponente1 = findViewById(R.id.imageOponente);
        homem = findViewById(R.id.pontoJog);
        computador = findViewById(R.id.pontoMaq);
        fundo = findViewById(R.id.scroll);

        String fala = "Vamos tentar denovo" , perde = "Perdeu", ganha = "Ganhou", empate = "Jogamos iguais camarada";
        String stoneWin = "Quebrou minha tesoura", stoneLoss = "Embrulhei sua pedra";
        String paperWin = "Embrulhou minha pedra", paperLoss = "Cortei seu papel";
        String cutWin = "Cortou meu papel", cutLoss = "Quebrei sua tesoura";

        final int[] ptjog = {0};
        final int[] ptmaq = {0};
        //Pegando o Id do botão
        Button btPlay = findViewById(R.id.btJoga);
        //Todo código é executado quando o botão é pressionado
        btPlay.setOnClickListener(view -> {
        //inicio do botão
            Random random = new Random();

            int player , maquina ;

            if(pedra.isChecked()){
                jogador1.setBackgroundResource(R.drawable.pedra);
                maquina = random.nextInt(3);
                player = 0;
                if(player == maquina){
                    oponente1.setBackgroundResource(R.drawable.pedra);
                    saida.setText(empate);
                    saida2.setText(fala);
                    fundo.setBackgroundResource(R.color.gray);
                }else if(maquina == 1){
                    oponente1.setBackgroundResource(R.drawable.papel);
                    saida.setText(perde);
                    saida2.setText(stoneLoss);
                    fundo.setBackgroundResource(R.color.red);
                    ptmaq[0]=ptmaq[0]+1;
                    computador.setText(""+ptmaq[0]);
                }else if(maquina == 2){
                    oponente1.setBackgroundResource(R.drawable.tesoura);
                    saida.setText(ganha);
                    saida2.setText(stoneWin);
                    fundo.setBackgroundResource(R.color.green);
                    ptjog[0]=ptjog[0]+1;
                    homem.setText(""+ptjog[0]);
                }

            }else if (papel.isChecked()){
                jogador1.setBackgroundResource(R.drawable.papel);
                maquina = random.nextInt(3);
                player = 1;
                if(player == maquina){
                    oponente1.setBackgroundResource(R.drawable.papel);
                    saida.setText(empate);
                    saida2.setText(fala);
                    fundo.setBackgroundResource(R.color.gray);
                }else if(maquina == 0){
                    oponente1.setBackgroundResource(R.drawable.pedra);
                    saida.setText(ganha);
                    saida2.setText(paperWin);
                    fundo.setBackgroundResource(R.color.green);
                    ptjog[0]=ptjog[0]+1;
                    homem.setText(""+ptjog[0]);
                }else if(maquina == 2){
                    oponente1.setBackgroundResource(R.drawable.tesoura);
                    saida.setText(perde);
                    saida2.setText(paperLoss);
                    fundo.setBackgroundResource(R.color.red);
                    ptmaq[0]=ptmaq[0]+1;
                    computador.setText(""+ptmaq[0]);
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
                    saida.setText(empate);
                    saida2.setText(fala);
                    fundo.setBackgroundResource(R.color.gray);
                }else if(maquina == 1){
                    oponente1.setBackgroundResource(R.drawable.papel);
                    saida.setText(ganha);
                    saida2.setText(cutWin);
                    fundo.setBackgroundResource(R.color.green);
                    ptjog[0]=ptjog[0]+1;
                    homem.setText(""+ptjog[0]);
                }else if(maquina == 0){
                    oponente1.setBackgroundResource(R.drawable.pedra);
                    saida.setText(perde);
                    saida2.setText(cutLoss);
                    fundo.setBackgroundResource(R.color.red);
                    ptmaq[0]=ptmaq[0]+1;
                    computador.setText(""+ptmaq[0]);
                }

            }else{
                Snackbar.make(view,"Escolha pedra papel ou tesoura",Snackbar.LENGTH_SHORT).show();

            }

        //fim do botão
        });

    }
}