package thomazini.com.br.covid_19.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import thomazini.com.br.covid_19.model.Paciente;

public class PacienteDAO {

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    public PacienteDAO(Context context) {
        this.sqLiteHelper = new SQLiteHelper(context);
    }

    public void salvar(Paciente pac) {
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("NOME", pac.getNome());
        valores.put("IDADE", pac.getIdade());
        valores.put("CIDADE", pac.getCidade());
        valores.put("ESTADO", pac.getEstado());

        sqLiteDatabase.insert("PACIENTE", null, valores);

        sqLiteDatabase.close();
    }
}
