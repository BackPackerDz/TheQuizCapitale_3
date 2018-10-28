package com.technicien_superieur.thequizcapitale.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.technicien_superieur.thequizcapitale.App
import org.jetbrains.anko.db.*

/**
 * Created by Fayçal KADDOURI on 27/10/2018.
 * Website : www.technicien-superieur.com
 */
class MySqlDBHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        DB_NAME, null, DB_VERSION) {


    // Ceci représente nos constantes
    companion object {
        val DB_NAME = "quiz_app.db"
        val DB_VERSION = 2
        val instance by lazy { MySqlDBHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Ici nous créeons notre table "Score", si elle existe tant mieux sinon elle est crée
        db.createTable(ScoreTable.NAME, true, ScoreTable.ID to INTEGER + PRIMARY_KEY,
                ScoreTable.SCORE to INTEGER,
                ScoreTable.DATE to INTEGER
        )
    }

    // Mettre à jour notre base de donnée à la nouvelle version
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(ScoreTable.NAME, true)
        onCreate(db)
    }

}
