package com.example.codenwin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codenwin.R
import com.example.codenwin.model.CoverModel
import com.example.codenwin.model.StatusModel

class CoverAdapter(var context: Context?,var coverData:List<CoverModel>):RecyclerView.Adapter<CoverAdapter.CoverViewHolder>() {
    class CoverViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var coverItemRecyclerView: RecyclerView
        init {
            coverItemRecyclerView = itemView.findViewById(R.id.coverItemRecyclerView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoverViewHolder {
        return CoverViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.status_cover_item,parent,false))
    }

    override fun onBindViewHolder(holder: CoverViewHolder, position: Int) {

        setcoverItemRecyclerView(holder.coverItemRecyclerView,coverData[position].coverItem)
    }
    private fun setcoverItemRecyclerView(recyclerView:RecyclerView,coverItemData:List<StatusModel>){
        recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        recyclerView.adapter=CoverItemAdapter(coverItemData)
    }

    override fun getItemCount(): Int {
        return coverData.size
    }
}