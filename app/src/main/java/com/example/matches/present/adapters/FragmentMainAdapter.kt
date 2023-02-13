package com.example.matches.present.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matches.R
import com.example.matches.model.MatchItem

class FragmentMainAdapter: RecyclerView.Adapter<FragmentMainAdapter.MainViewHolder>() {

    private lateinit var matches:List<MatchItem>
    var setOnMatchClickListener: ((MatchItem) -> Unit)? = null

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo_away_Team = itemView.findViewById<ImageView>(R.id.logo_away_Team)
        val logo_homeTeam = itemView.findViewById<ImageView>(R.id.logo_homeTeam)
        val match_id = itemView.findViewById<TextView>(R.id.match_id)
        val home_team_name = itemView.findViewById<TextView>(R.id.home_team_name)
        val home_team_country =  itemView.findViewById<TextView>(R.id.home_team_country)
        val match_time_start = itemView.findViewById<TextView>(R.id.match_time_start)
        val away_Team_name = itemView.findViewById<TextView>(R.id.away_Team_name)
        val away_Team_country = itemView.findViewById<TextView>(R.id.away_Team_country)
        val match_status = itemView.findViewById<TextView>(R.id.match_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_match_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val match: MatchItem = matches[position]
            Glide.with(holder.itemView)
                .load(match.homeTeam.logo)
                .into(holder.logo_homeTeam)
            Glide.with(holder.itemView)
                .load(match.awayTeam.logo)
                .into(holder.logo_away_Team)

        holder.match_id.text = match.match_id.toString()
        holder.match_status.text = match.status
        holder.away_Team_name.text = match.awayTeam.name
        holder.away_Team_country.text = match.awayTeam.country.name
        holder.home_team_name.text = match.homeTeam.name
        holder.home_team_country.text = match.homeTeam.country.name

        setOnMatchClickListener?.invoke(match)


    }

    override fun getItemCount(): Int {
        return matches.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMatches(match: List<MatchItem?>) {
        matches = matches
        notifyDataSetChanged()
    }
}