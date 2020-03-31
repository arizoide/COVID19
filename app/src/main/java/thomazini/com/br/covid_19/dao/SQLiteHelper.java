package thomazini.com.br.covid_19.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private final String DB_PACIENTE = "CREATE TABLE PACIENTE (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NOME TEXT," +
            "IDADE INTEGER," +
            "CIDADE TEXT," +
            "ESTADO TEXT)";

    public SQLiteHelper(Context context) {
        super(context, "covid19.bd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_PACIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
