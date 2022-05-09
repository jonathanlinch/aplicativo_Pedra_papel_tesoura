package com.mixcorp.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    @SuppressLint("SetTextI18n")
    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView imageResult = findViewById(R.id.imageResult);
        TextView textR = findViewById(R.id.texto);

        int numero = new Random().nextInt(3);//0,1,2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imageResult.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResult.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        }
        //App ganhador
        if (
                (opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                        (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                        (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))
        ){
            textR.setText("Você perdeu :(");
        }else if(
                (opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                        (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
                        (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura"))
        ){ //Usuario ganhador
            textR.setText("Você ganhou! :)");
        }else{
            textR.setText("Empatamos! ;)");
        }
    }
}
