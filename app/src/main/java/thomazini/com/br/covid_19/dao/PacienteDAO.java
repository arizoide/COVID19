package thomazini.com.br.covid_19.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public List<Paciente> listar() {
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();

        String sql = "SELECT * FROM PACIENTE;";

        Cursor c = sqLiteDatabase.rawQuery(sql, null);

        List<Paciente> pacientes = new ArrayList<>();

        while(c.moveToNext()){
            Paciente pac = new Paciente();
            pac.setId(c.getInt(c.getColumnIndex("ID")));
            pac.setNome(c.getString(c.getColumnIndex("NOME")));
            pac.setIdade(c.getInt(c.getColumnIndex("IDADE")));
            pac.setCidade(c.getString(c.getColumnIndex("CIDADE")));
            pac.setEstado(c.getString(c.getColumnIndex("ESTADO")));

            pacientes.add(pac);
        }

        return pacientes;
    }

    public void excluir(Paciente pac) {
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        sqLiteDatabase.delete("PACIENTE", "ID = ?", new String[] {String.valueOf(pac.getId())});

        sqLiteDatabase.close();
    }

    public List<Paciente> buscarPorNome(String nome) {
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();

        String sql = "SELECT * FROM PACIENTE WHERE NOME LIKE '%"+nome+"%';";

        Cursor c = sqLiteDatabase.rawQuery(sql, null);

        List<Paciente> pacientes = new ArrayList<>();

        while(c.moveToNext()){
            Paciente pac = new Paciente();
            pac.setId(c.getInt(c.getColumnIndex("ID")));
            pac.setNome(c.getString(c.getColumnIndex("NOME")));
            pac.setIdade(c.getInt(c.getColumnIndex("IDADE")));
            pac.setCidade(c.getString(c.getColumnIndex("CIDADE")));
            pac.setEstado(c.getString(c.getColumnIndex("ESTADO")));

            pacientes.add(pac);
        }

        return pacientes;
    }
}
