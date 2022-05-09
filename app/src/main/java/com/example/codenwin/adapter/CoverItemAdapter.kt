package com.example.codenwin.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.codenwin.R
import com.example.codenwin.model.CoverModel
import com.example.codenwin.model.StatusModel

    class CoverItemAdapter(var coverItemData:List<StatusModel>):RecyclerView.Adapter<CoverItemAdapter.CoverItemViewHolder>() {
    class CoverItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var personImage :ImageView
        var personName : TextView
        var statusCard : CardView
        init {
            personImage = itemView.findViewById(R.id.personImage)
            personName = itemView.findViewById(R.id.personName)
            statusCard = itemView.findViewById(R.id.status_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoverItemViewHolder {
        return CoverItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_status,parent,false))
    }

    override fun onBindViewHolder(holder: CoverItemViewHolder, position: Int) {
        holder.personImage.setImageResource(coverItemData[position].imageUrl)
        holder.personName.text=coverItemData[position].statusName
        holder.statusCard.setOnClickListener {
            holder.statusCard.setBackgroundColor(Color.GREEN)
        }
    }

    override fun getItemCount(): Int {
        return coverItemData.size
    }
}