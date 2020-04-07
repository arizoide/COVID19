package thomazini.com.br.covid_19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import thomazini.com.br.covid_19.dao.PacienteDAO;
import thomazini.com.br.covid_19.model.Paciente;

public class JoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jose);

        PacienteDAO dao = new PacienteDAO(this);
        List<Paciente> pacientes = dao.listar();

        ListView listView = getListViewPacientes(pacientes);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Recupera o item que foi clicado na posicao
                Paciente pac = (Paciente) parent.getItemAtPosition(position); //Converte usando cast

                Intent cadastroPaciente = new Intent(JoseActivity.this, CadastroPacienteActivity.class);
                cadastroPaciente.putExtra("ID_PACIENTE", pac.getId().toString());
                startActivity(cadastroPaciente);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Recupera o item que foi clicado na posicao
                Paciente pac = (Paciente) parent.getItemAtPosition(position); //Converte usando cast

                PacienteDAO dao = new PacienteDAO(JoseActivity.this);
                dao.excluir(pac);

                Toast.makeText(JoseActivity.this, "Item excluído com sucesso", Toast.LENGTH_LONG).show();

                Intent jose = new Intent(JoseActivity.this, JoseActivity.class);
                startActivity(jose);

                return false;
            }
        });

        EditText buscaNome = findViewById(R.id.editTextBuscaNome);

        buscaNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                PacienteDAO dao = new PacienteDAO(JoseActivity.this);
                getListViewPacientes(dao.buscarPorNome(s.toString()));
            }
        });


    }

    private ListView getListViewPacientes(List<Paciente> pacientes) {
        ListView listView = findViewById(R.id.listViewPacientes);

        ListAdapter listAdapter = new ArrayAdapter<Paciente>(this, android.R.layout.simple_list_item_1, pacientes);

        listView.setAdapter(listAdapter);
        return listView;
    }
}
