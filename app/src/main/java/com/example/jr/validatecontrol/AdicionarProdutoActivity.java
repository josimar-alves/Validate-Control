package com.example.jr.validatecontrol;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Cadastrar Produto");
        }
    }

    public void adicionarProduto(View view) {
        EditText mNome = (EditText) findViewById(R.id.nome);
        EditText mDescricao = (EditText) findViewById(R.id.descricao);
        DatePicker mData = (DatePicker) findViewById(R.id.data);
        View focus = null;

        String nome = mNome.getText().toString();
        String descricao = mDescricao.getText().toString();
        String data = mData.getDayOfMonth() + "/" + mData.getMonth() + "/" + mData.getYear();

        if (TextUtils.isEmpty(nome)) {
            mNome.setError("Campo Vazio");
            focus = mNome;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(descricao)) {
            mDescricao.setError("Campo Vazio");
            focus = mDescricao;
            focus.requestFocus();
        } else {
            Produto p = new Produto(nome, descricao, data);
            GerenciadorBD gerenciadorBD = new GerenciadorBD(this);
            gerenciadorBD.addProduto(p);
            Toast.makeText(getBaseContext(), "O(a) " + nome + " foi Cadastrado(a)!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
