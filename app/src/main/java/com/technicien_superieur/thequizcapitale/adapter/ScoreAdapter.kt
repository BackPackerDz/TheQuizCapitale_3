package com.technicien_superieur.thequizcapitale.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.technicien_superieur.thequizcapitale.R
import com.technicien_superieur.thequizcapitale.model.Score
import kotlinx.android.synthetic.main.score_item.view.*

/**
 * Created by Fayçal KADDOURI on 27/10/2018.
 * Website : www.technicien-superieur.com
 */
class ScoreAdapter(val scores: List<Score>, val context: Context)
    : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.score_item, parent, false))
    }

    // On renvoit le notre d'objet score qu'il y a dans notre liste
    override fun getItemCount(): Int {
        return scores.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.txtScore.text = "Score : ${scores.get(position).score}"

        // On transforme notre temps unix en temps relatif exmple "Il y a une heure...etc"
        val relativeTime = DateUtils.getRelativeTimeSpanString(scores.get(position).date)
        holder.txtDate.text = "$relativeTime"
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val txtScore = view.txt_score
    val txtDate = view.txt_date
}