package aleksandrabramovski.personsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "persons.db";
    public static final String TABLE_NAME = "ces_export";
    public static final String COL_1 = "_id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "year";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " + COL_3 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.query(TABLE_NAME, null,null,null,
                        null,null,null);
        return result;
    }

    public Cursor getDbData(String edittextSearch){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_2
                + " LIKE " + "'%" + edittextSearch + "%'", null);
        return result;
    }
}
