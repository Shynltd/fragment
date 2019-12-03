package vn.fptpolytechnic.assignment.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context){
        super(context, "assignment.db", null, 1);
    }

    public void sendData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public Cursor getData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE THU(NGAYTHANG NVARCHAR, KHOANTHU NVARCHAR,LOAITHU NVARCHAR, IDTHU INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("CREATE TABLE CHI(NGAYTHANG NVARCHAR, KHOANCHI NVARCHAR,LOAICHI NVARCHAR, IDCHI INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS THU");
        db.execSQL("DROP TABLE IF EXISTS CHI");
        onCreate(db);
    }
}
