package thomazini.com.br.covid_19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
}
