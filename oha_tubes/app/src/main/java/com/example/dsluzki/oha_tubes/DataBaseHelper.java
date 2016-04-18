package com.example.dsluzki.oha_tubes;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by DSluzki on 15.04.2016.
 * http://blog.reigndesign.com/blog/using-your-own-sqlite-database-in-android-applications/
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_TUBE_TYPESYSID = "tube_typesysid";
    private static final String COLUMN_DESCRIPTIONSHORTMARK = "descriptionshortmark";

    //The Android's default system path of your application database.

    private static String DB_PATH = "/data/data/com.example.dsluzki.oha_tubes/databases/";
    private static String DB_NAME = "tube";
    private SQLiteDatabase myDataBase;
    private final Context myContext;


    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     *
     * @param context
     */
    public DataBaseHelper(MainActivity.PlaceholderFragment context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;

        // !!!!!!!!! Only for test


    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void createDataBase() throws IOException {


        // !!!!!!!!! TEST - DEAKTIVIEREN
        //myContext.deleteDatabase(DB_PATH + DB_NAME);
        // !!!!!!!!!!!!!!!!!!!


        boolean dbExist = checkDataBase();




        if (dbExist) {

             //do nothing - database already exist



        } else {

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.

            // ????????
            this.getReadableDatabase();



            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */

    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {

            String myPath = DB_PATH + DB_NAME;

            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

            //database does't exist yet.
        }

        if (checkDB != null) {

            checkDB.close();
        }

        return checkDB != null ? true : false;

    }


    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * <p/>
     * system folder, from where it can be accessed and handled.
     * <p/>
     * This is done by transfering bytestream.
     */

    private void copyDataBase() throws IOException {


        //Open your local db as the input stream

        AssetManager _assets = myContext.getAssets();

        InputStream myInput = myContext.getAssets().open(DB_NAME + ".db");


        // Path to the just created empty db

        String outFileName = DB_PATH + DB_NAME ;


        //Open the empty db as the output stream

        OutputStream myOutput = new FileOutputStream(outFileName);


        //transfer bytes from the inputfile to the outputfile

        byte[] buffer = new byte[1024];

        int length;

        while ((length = myInput.read(buffer)) > 0) {

            myOutput.write(buffer, 0, length);

        }


        //Close the streams

        myOutput.flush();

        myOutput.close();

        myInput.close();


    }


    public void openDataBase() throws SQLException {


        //Open the database

        String myPath = DB_PATH + DB_NAME;

        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);


    }


    @Override

    public synchronized void close() {


        if (myDataBase != null)

            myDataBase.close();


        super.close();


    }


    @Override

    public void onCreate(SQLiteDatabase db) {

        /*
        String sql = "";

        db.execSQL(sql);
        Log.d("DB Created", "onCreated sql");
        */

    }

/*
    public int insertFromFile(Context context, int resourceId) throws IOException {
        // Reseting Counter
        int result = 0;

        // Open the resource
        InputStream insertsStream = context.getResources().openRawResource(resourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        // Iterate through lines (assuming each insert has its own line and theres no other stuff)
        while (insertReader.ready()) {
            String insertStmt = insertReader.readLine();
            myDataBase.execSQL(insertStmt);
            result++;
        }
        insertReader.close();

        // returning number of inserted rows
        return result;
    }
*/

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    public ArrayList getAll_Tube_category()
    {
        ArrayList array_list = new ArrayList();

        try

        {
            SQLiteDatabase db = this.getReadableDatabase();
            //Cursor res =  db.rawQuery( "select status from task WHERE status LIKE "Processing%"", null );
            Cursor res = db.rawQuery("select * from tube_category where clientsysid = 1", null);
            res.moveToFirst();
            while (res.isAfterLast() == false) {
                String Name = res.getString(res.getColumnIndex(COLUMN_ID));
                array_list.add(res.getString(res.getColumnIndex(COLUMN_DESCRIPTION)));
                res.moveToNext();
            }
            return array_list;
        }
        catch (SQLiteException e) {

            throw new Error(e);
        }
    }

    // Add your public helper methods to access and get content from the database.

    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy

    // to you to create adapters for your views.


}


