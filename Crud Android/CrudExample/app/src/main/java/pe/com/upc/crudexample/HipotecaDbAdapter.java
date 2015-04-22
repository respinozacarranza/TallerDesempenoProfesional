package pe.com.upc.crudexample;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Alumnos on 07/04/2015.
 */
public class HipotecaDbAdapter {

    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String C_TABLA = "HIPOTECA" ;

    //Definimos constantes con el nombre de las columnas de la tabla

    public static final String C_COLUMNA_ID   = "_id";
    public static final String C_COLUMNA_NOMBRE = "hip_nombre";
    public static final String C_COLUMNA_CONDICIONES = "hip_condiciones";
    public static final String C_COLUMNA_CONTACTO = "hip_contacto";
    public static final String C_COLUMNA_EMAIL = "hip_email";
    public static final String C_COLUMNA_TELEFONO = "hip_telefono";
    public static final String C_COLUMNA_OBSERVACIONES = "hip_observaciones";

    private Context contexto;
    private HipotecaDbHelper dbHelper;
    private SQLiteDatabase db;

    //Defino la lista de columnas de la tabla para utilizarla en la consulta a la base de datos

    private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_CONDICIONES, C_COLUMNA_CONTACTO, C_COLUMNA_EMAIL, C_COLUMNA_TELEFONO, C_COLUMNA_OBSERVACIONES} ;

    public HipotecaDbAdapter(Context context)
    {
        this.contexto = context;
    }

    public HipotecaDbAdapter abrir() throws SQLException
    {
        dbHelper = new HipotecaDbHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar()
    {
        dbHelper.close();
    }

    //Devuelve cursor con todos las columnas de la tabla

    public Cursor getCursor() throws SQLException
    {
        Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);

        return c;
    }

    public Cursor getRegistro(long id) throws SQLException{
        Cursor c = db.query( true, C_TABLA, columnas, C_COLUMNA_ID + "=" + id, null, null, null, null, null);
        //Nos movemos al primer registro de la consulta
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public long insert(ContentValues reg){
        if(db == null)
            abrir();
        return db.insert(C_TABLA, null, reg);
    }

    public long delete(long id)
    {
        if (db == null)
            abrir();

        return db.delete(C_TABLA, "_id=" + id, null);
    }
    /**
     * Modificar el registro
     */
    public long update(ContentValues reg)
    {
        long result = 0;

        if (db == null)
            abrir();

        if (reg.containsKey(C_COLUMNA_ID))
        {
            //
            // Obtenemos el id y lo borramos de los valores
            //
            long id = reg.getAsLong(C_COLUMNA_ID);

            reg.remove(C_COLUMNA_ID);

            //
            // Actualizamos el registro con el identificador que hemos extraido
            //
            result = db.update(C_TABLA, reg, "_id=" + id, null);
        }
        return result;
    }

}
