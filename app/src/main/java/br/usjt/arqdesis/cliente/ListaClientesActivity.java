package br.usjt.arqdesis.cliente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaClientesActivity extends Activity {

    public static final String ID = "br.usjt.arqdesis.cliente.id";
    ArrayList<String> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = buscaClientes(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(atividade, DetalheClienteActivity.class);
                intent.putExtra(ID, ListaDados.getInstance().getIdOf(lista.get(position)));
                startActivity(intent);
            }

        });
    }

    public ArrayList<String> buscaClientes(String chave){

        ArrayList<String> lista = ListaDados.getInstance().getLista();
        if(chave == null || chave.length() == 0){
            return lista;
        }
        else{
            ArrayList<String> subLista = new ArrayList<String>();
            for(String nome : lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }

    }

}
