package com.technicien_superieur.thequizcapitale.db

import com.technicien_superieur.thequizcapitale.model.Score
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by Fayçal KADDOURI on 27/10/2018.
 * Website : www.technicien-superieur.com
 */
class QuizDB(private val dbHelper: MySqlDBHelper = MySqlDBHelper.instance) {

    // Pour récupérer nos scores
    fun requestScores() = dbHelper.use {
        select(ScoreTable.NAME,
               ScoreTable.SCORE, ScoreTable.DATE)
                .parseList(classParser<Score>())
    }

    // Pour engistrer un score
    fun saveScore(scoreQuiz: Score) = dbHelper.use {
        insert(ScoreTable.NAME,
                ScoreTable.SCORE to scoreQuiz.score,
                ScoreTable.DATE to scoreQuiz.date)
    }
}