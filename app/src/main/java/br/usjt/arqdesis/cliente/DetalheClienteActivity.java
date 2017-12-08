package br.usjt.arqdesis.cliente;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetalheClienteActivity extends Activity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);

        TextView nome = (TextView) findViewById(R.id.nome_selecionado);
        Intent intent = getIntent();

        position =  intent.getIntExtra(ListaClientesActivity.ID, -1);

        nome.setText(
                ListaDados.getInstance().getLista().get(position)
        );
    }

    boolean editing = false;

    public void editarNome(View view){
        editing = !editing;

        if(editing){

            Button botao = (Button) findViewById(R.id.botao_editar);
            botao.setText("Salvar");

            EditText nome = (EditText) findViewById(R.id.nome_selecionado);
            nome.setEnabled(true);

        }
        else{
            Button botao = (Button) findViewById(R.id.botao_editar);
            botao.setText("Editar");

            EditText nome = (EditText) findViewById(R.id.nome_selecionado);

            ListaDados.getInstance().getLista().set(position, nome.getText().toString());

            nome.setEnabled(false);
        }
    }

    public void excluirCliente(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Excluir");
        alertDialog.setMessage("Deseja mesmo excluir " + ListaDados.getInstance().getLista().get(position) + "?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SIM",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ListaDados.getInstance().getLista().remove(position);

                        Intent intent = new Intent(DetalheClienteActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NÃO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}
