package com.technicien_superieur.thequizcapitale.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.technicien_superieur.thequizcapitale.R
import com.technicien_superieur.thequizcapitale.adapter.ScoreAdapter
import com.technicien_superieur.thequizcapitale.db.QuizDB
import kotlinx.android.synthetic.main.content_list_scores.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListScoresActivity : AppCompatActivity(), AnkoLogger {

    val quizDb = QuizDB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_scores)

        score_list.layoutManager = LinearLayoutManager(this)

        doAsync {
            val list = quizDb.requestScores()
            // pour pouvoir afficher les scores à notre utilisateur
            // C'est genre l'équivalant de onPostExecute d'un AsyncTask
            uiThread {
                score_list.adapter = ScoreAdapter(list, this@ListScoresActivity)
            }
        }
    }

}
