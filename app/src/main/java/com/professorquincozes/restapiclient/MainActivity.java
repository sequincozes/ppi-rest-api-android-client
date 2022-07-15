package com.professorquincozes.restapiclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.professorquincozes.restapiclient.entity.Usuario;
import com.professorquincozes.restapiclient.presenter.UsuarioPresenter;

public class MainActivity extends AppCompatActivity implements Contratos.View {

    Contratos.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new UsuarioPresenter(this);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextId = findViewById(R.id.editTextId);
                try {
                    presenter.solicitarDados(Integer.parseInt(editTextId.getText().toString()));
                } catch (NumberFormatException e){
                    mostrarErro("É necessário informar um ID.");
                }
            }
        });
    }

    @Override
    public void mostrarDados(Usuario usuario) {
        EditText idade = findViewById(R.id.editTextIdade);
        idade.setText(String.valueOf(usuario.getIdade()));

        EditText nome = findViewById(R.id.editTextNome);
        nome.setText(usuario.getNome());
    }

    @Override
    public void mostrarErro(String localizedMessage) {
        Toast.makeText(this, "Erro: " + localizedMessage, Toast.LENGTH_SHORT).show();
    }
}