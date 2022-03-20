package com.example.jogodoadvinha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editTextAdvinha;
    Button btnAdvinha;
    Button btnNewGame;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////
        editTextAdvinha = findViewById(R.id.editTextAdvinha);
        btnAdvinha = findViewById(R.id.btnAdvinha);
        btnNewGame = findViewById(R.id.btnNewGame);
    }

    // Gerar número randômico
    public int getRandomNumber () {
        Random random = new Random();
        int numRandom = random.nextInt(100);
        return numRandom;
    }

    // Quando clica em NOVO JOGO
    public void btnNewGameClick (View v) {
        editTextAdvinha.setEnabled(true);
        btnAdvinha.setEnabled(true);
        result = getRandomNumber();
        btnNewGame.setEnabled(false);
    }

    public void btnAdvinha (View v){
        if (editTextAdvinha.getText().toString().length() != 0)
        {
            if (editTextAdvinha.getText().toString().equalsIgnoreCase(Integer.toString(result)))
            {
                Toast.makeText(this, "VOCÊ ACERTOU \uD83D\uDE04..", Toast.LENGTH_SHORT).show();
                editTextAdvinha.setEnabled(false);
                btnAdvinha.setEnabled(false);
                btnNewGame.setEnabled(true);
                return;
            } else if (Integer.parseInt(editTextAdvinha.getText().toString()) < result){
                Toast.makeText(this, "Não é esse número \uD83D\uDE41. Que tal um maior?" , Toast.LENGTH_SHORT).show();
            } else if (Integer.parseInt(editTextAdvinha.getText().toString()) > result)
            {
                Toast.makeText(this, "Não é esse número \uD83D\uDE41.  Que tal um menor?" , Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "\uD83E\uDD14", Toast.LENGTH_SHORT).show();
        }
    }
}
