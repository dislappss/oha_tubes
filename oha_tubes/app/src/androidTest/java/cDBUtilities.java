import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by disl on 14.04.2016.
 *
 *   DatabaseHandler db = new DatabaseHandler(this);

 /**
 * CRUD Operations
 * */
// Inserting Contacts
/*
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        /*
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
        String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
        // Writing Contacts to log
        Log.d("Name: ", log);
        }
        }
 *
 * http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
 */
public class cDBUtilities extends android.database.sqlite.SQLiteOpenHelper  {

    private cModRohrtype_1 _rohrtype_1;
    static final String TAG = "DbHelper1";
    static final String DB_NAME = "timeline.db";
    static final int DB_VERSION = 1;

    static final String TABLE_rohrtype_1 = "_rohrtype_1";
    static final String C_ID = BaseColumns._ID;
    static final String C_DESCRIPTION = "description";


    public cDBUtilities(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE_rohrtype_1 + " ("
                + C_ID + " int primary key, "
                + C_DESCRIPTION + " text)";

        db.execSQL(sql);

        Log.d(TAG, "onCreated sql:" + TABLE_rohrtype_1);
        //System.out.println("dbhelper oncreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_rohrtype_1);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addContact(cModRohrtype_1 rohrtype_1) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(C_ID, rohrtype_1.getID()); // Contact Name
        values.put(C_DESCRIPTION, rohrtype_1.getDescription()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_rohrtype_1, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public cModRohrtype_1 getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_rohrtype_1, new String[] { C_ID,
                        C_DESCRIPTION }, C_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        cModRohrtype_1 _item = new cModRohrtype_1(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return contact
        return _item;
    }

    // Getting All Contacts
    public List<cModRohrtype_1> getAllContacts() {
        List<cModRohrtype_1> contactList = new ArrayList<cModRohrtype_1>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_rohrtype_1;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                cModRohrtype_1 _item = new cModRohrtype_1();
                _item.setID(Integer.parseInt(cursor.getString(0)));
                _item.setDescription(cursor.getString(1));
                // Adding contact to list
                contactList.add(_item);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_rohrtype_1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    // Updating single contact
    public int updateContact(cModRohrtype_1 contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(C_DESCRIPTION, contact.getDescription());

        // updating row
        return db.update(TABLE_rohrtype_1, values, C_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void deleteContact(cModRohrtype_1 contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_rohrtype_1, C_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }


}
