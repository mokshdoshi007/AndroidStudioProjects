package tops.technologies.sqlexample.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import tops.technologies.sqlexample.Model.User;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_USER = "user";
    private static final String COLOUMN_USER_ID = "user_id";
    private static final String COLOUMN_USER_NAME = "user_name";
    private static final String COLOUMN_USER_EMAIL = "user_email";
    private static final String COLOUMN_USER_PASSWORD = "user_password";
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " ("
            + COLOUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_USER_NAME +
            " TEXT," + COLOUMN_USER_EMAIL + " TEXT," + COLOUMN_USER_PASSWORD + " TEXT)";
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS "+TABLE_USER;
    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }
    public void addUser(User user)
    {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        contentValues.put(COLOUMN_USER_NAME,user.getName());
        contentValues.put(COLOUMN_USER_EMAIL,user.getEmail());
        contentValues.put(COLOUMN_USER_PASSWORD,user.getPassword());

        sqLiteDatabase.insert(TABLE_USER, null, contentValues);
        sqLiteDatabase.close();
    }

    public boolean checkuser(String email, String password)
    {
        String columns[] = {COLOUMN_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLOUMN_USER_EMAIL+" =?" +" AND "+COLOUMN_USER_PASSWORD+" =?";
        String selectionArgs[] = {email,password};
        Cursor cursor = db.query(TABLE_USER,columns,selection,selectionArgs,null,null,null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount>0;
    }

    public List getallusers()
    {
        String columns[] = {COLOUMN_USER_ID,COLOUMN_USER_NAME,COLOUMN_USER_EMAIL,COLOUMN_USER_PASSWORD};
        String sortorder = COLOUMN_USER_NAME+" ASC";
        List <User>  userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,columns,null,null,null,null,sortorder);
        if (cursor.moveToFirst())
        {
            do {
                User user = new User();
                user.setId(Integer.parseInt((cursor.getString(cursor.getColumnIndex(COLOUMN_USER_ID)))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLOUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLOUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLOUMN_USER_PASSWORD)));
                userList.add(user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }
}
