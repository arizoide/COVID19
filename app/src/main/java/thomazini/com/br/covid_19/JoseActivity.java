package thomazini.com.br.covid_19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        ListView listView = findViewById(R.id.listViewPacientes);

        ListAdapter listAdapter = new ArrayAdapter<Paciente>(this, android.R.layout.simple_list_item_1, pacientes);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(JoseActivity.this, "Clique rapido", Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(JoseActivity.this, "Clique longo", Toast.LENGTH_LONG).show();
                return false;
            }
        });


    }
}
