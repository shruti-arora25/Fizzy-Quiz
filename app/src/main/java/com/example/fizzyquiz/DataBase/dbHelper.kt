package com.example.fizzyquiz.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbHelper(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {


        private const val DATABASE_NAME = "UserDatabase.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "data"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"
    }


    override fun onCreate(db: SQLiteDatabase?) {

        val createTableQuery = ("CREATE TABLE $TABLE_NAME " +
                "(" + "$COLUMN_ID INTEGER PRIMARY KEY AUTO-INCREMENTED, " +
                "$COLUMN_USERNAME text, " +
                "$COLUMN_PASSWORD text)")

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        val dropTable = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTable)
        onCreate(db)

    }


    fun insertUser(username: String, password: String): Long {

        val values = ContentValues().apply {
            put(COLUMN_USERNAME, username)
            put(COLUMN_PASSWORD, password)
        }

        val db = writableDatabase
        return db.insert(TABLE_NAME, null, values)

    }


    fun readUser(username: String, password: String): Boolean {
        val db = readableDatabase
        val selection = "$COLUMN_USERNAME =? AND $COLUMN_PASSWORD =?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null)


        val userExist = cursor.count > 0
        cursor.close()
        return userExist


    }
}