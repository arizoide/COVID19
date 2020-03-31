package thomazini.com.br.covid_19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import thomazini.com.br.covid_19.dao.PacienteDAO;
import thomazini.com.br.covid_19.model.Paciente;

public class CadastroPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);
    }

    public void limpar(View view){
        EditText nome = findViewById(R.id.editTextNome);
        EditText idade = findViewById(R.id.editTextIdade);
        EditText cidade = findViewById(R.id.editTextCidade);
        EditText estado = findViewById(R.id.editTextEstado);
        nome.getText().clear();
        idade.getText().clear();
        cidade.getText().clear();
        estado.getText().clear();
    }

    public void salvar(View view){
        //Leio as informacoes da tela
        EditText nome = findViewById(R.id.editTextNome);
        EditText idade = findViewById(R.id.editTextIdade);
        EditText cidade = findViewById(R.id.editTextCidade);
        EditText estado = findViewById(R.id.editTextEstado);

        //crio o objeto paciente
        Paciente pac = new Paciente(nome.getText().toString(), Integer.parseInt(idade.getText().toString()), cidade.getText().toString(), estado.getText().toString());

        //salvar paciente no bd
        PacienteDAO dao = new PacienteDAO(this);
        dao.salvar(pac);

        limpar(view);

        Toast.makeText(this, "Paciente cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }
}
