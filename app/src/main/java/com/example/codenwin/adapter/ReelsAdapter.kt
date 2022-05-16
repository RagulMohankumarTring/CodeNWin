package com.example.codenwin.adapter

import android.media.MediaPlayer
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.codenwin.R
import com.example.codenwin.model.VideoModel
import kotlinx.android.synthetic.main.feelings_section.view.*
import kotlinx.android.synthetic.main.reels_item.view.*

class ReelsAdapter(var reelsList:List<VideoModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ReelsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var video:VideoView
        var title:TextView
        var description:TextView
        init {
            video=itemView.video
            title=itemView.title
            description=itemView.caption
        }

        fun bind(){
            Log.d("Check","Reached bind")
            title.text = reelsList[position].title
            itemView.profilePic.setImageResource(reelsList[position].profilePic)
            itemView.likedCount.text=reelsList[position].likedCount.toString()
            itemView.commentCount.text=reelsList[position].commentCount.toString()
            description.text=reelsList[position].description
            Log.d("Check","Reached before URL setting")
            video.setVideoURI(Uri.parse(reelsList[position].videoUrl))
            Log.d("Check","Reached after URL setting")
            itemView.heartReels.setOnClickListener {
                itemView.likedCount.text=((reelsList[position].likedCount)+1).toString()
                itemView.heartReels.setImageResource(R.drawable.heart_filled)
            }
            itemView.commentReels.setOnClickListener {
                itemView.commentCount.text=((reelsList[position].commentCount)+1).toString()
            }
            video.setOnPreparedListener{ mp->
                Log.d("Check","Reached setOnPrepared")
                mp.start()
//                var videoRatio = mp.videoHeight/mp.videoHeight
//                var screenRatio = video.width/video.height
//                var scale = videoRatio/screenRatio
//                if(scale>=1f){
//                    video.setScaleX(scale.toFloat())
//                }
//                else{
//                    video.setScaleY(1f/scale.toFloat())
//                }
            }
            video.setOnCompletionListener { mp->
                Log.d("Check","Reached setOnCompletion")
                mp.start()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reels_item,parent,false)
        return ReelsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ReelsViewHolder).bind()
    }

    override fun getItemCount(): Int {
      return  reelsList.size
    }
}