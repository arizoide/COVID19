package thomazini.com.br.covid_19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import thomazini.com.br.covid_19.dao.PacienteDAO;
import thomazini.com.br.covid_19.model.Paciente;

public class CadastroPacienteActivity extends AppCompatActivity {

    private int id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);

        if (getIntent() != null && getIntent().getStringExtra("ID_PACIENTE") != null) {
            PacienteDAO pacienteDAO = new PacienteDAO(CadastroPacienteActivity.this);
            Paciente pac = pacienteDAO.getById(Integer.parseInt(getIntent().getStringExtra("ID_PACIENTE")));

            EditText nome = findViewById(R.id.editTextNome);
            EditText idade = findViewById(R.id.editTextIdade);
            EditText cidade = findViewById(R.id.editTextCidade);
            EditText estado = findViewById(R.id.editTextEstado);

            nome.setText(pac.getNome());
            idade.setText(pac.getIdade().toString());
            cidade.setText(pac.getCidade());
            estado.setText(pac.getEstado());
            id = pac.getId();

            Button atualizar = findViewById(R.id.buttonSalvar);
            atualizar.setText("Atualizar");
        }
    }

    public void limpar(View view) {
        EditText nome = findViewById(R.id.editTextNome);
        EditText idade = findViewById(R.id.editTextIdade);
        EditText cidade = findViewById(R.id.editTextCidade);
        EditText estado = findViewById(R.id.editTextEstado);
        nome.getText().clear();
        idade.getText().clear();
        cidade.getText().clear();
        estado.getText().clear();
    }

    public void salvarAtualizar(View view) {
        if (id <= 0) {
            salvarPaciente(view);
        } else {
            atualizarPaciente(view);
        }
    }

    private void atualizarPaciente(View view) {
        //Leio as informacoes da tela
        EditText nome = findViewById(R.id.editTextNome);
        EditText idade = findViewById(R.id.editTextIdade);
        EditText cidade = findViewById(R.id.editTextCidade);
        EditText estado = findViewById(R.id.editTextEstado);

        //crio o objeto paciente
        Paciente pac = new Paciente(id, nome.getText().toString(), Integer.parseInt(idade.getText().toString()), cidade.getText().toString(), estado.getText().toString());

        PacienteDAO dao = new PacienteDAO(this);
        dao.updatePacient(pac);

        Toast.makeText(this, "Paciente atualizado com sucesso", Toast.LENGTH_SHORT).show();

        id = -1;

    }

    private void salvarPaciente(View view) {
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
