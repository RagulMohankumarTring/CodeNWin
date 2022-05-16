package com.example.codenwin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.codenwin.R
import com.example.codenwin.fragment.Photos.Companion.photoRecyclerList
import com.example.codenwin.model.PhotosModel
import kotlinx.android.synthetic.main.blur_photo.view.*
import kotlinx.android.synthetic.main.photos_item_fragment.view.*

class PhotosAdapter(
    var layoutType: ArrayList<String>,
    var photosList: List<PhotosModel>,
    var context: Context?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    enum class ViewHolderType {
        PHOTO_CONTENT, BLLURED, ERROR
    }

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            itemView.photos.setImageResource(photosList[position].photos)
            itemView.photos.setOnClickListener {
                if(itemView.details.visibility==View.GONE) {
                    val animation = AnimationUtils.loadAnimation(context,R.anim.slide_up)
                    itemView.details.visibility = View.VISIBLE
                    itemView.details.startAnimation(animation)
                    itemView.photos.alpha = 0.4f
                }
                else{
                    val animation = AnimationUtils.loadAnimation(context,R.anim.slide_down)
                    itemView.details.visibility = View.VISIBLE
                    itemView.details.startAnimation(animation)
                    itemView.details.visibility = View.GONE
                    itemView.photos.alpha = 1.0f
                }
            }
        }
    }

    inner class BlurViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(){
        itemView.blurPhoto.setImageResource(photosList[position].photos)
        itemView.moreLayout.setOnClickListener {
            photoRecyclerList.smoothScrollToPosition(1)
        }
    }
    }

    inner class ErrorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewHolderType.PHOTO_CONTENT.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.photos_item_fragment, parent, false)
                return PhotosViewHolder(view)
            }
            ViewHolderType.BLLURED.ordinal -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.blur_photo, parent, false)
                return  BlurViewHolder(view)
            }
            else -> {
                return ErrorViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.error_text, parent, false)
                )


            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (layoutType[position]) {
            "PhotoContent" -> ViewHolderType.PHOTO_CONTENT.ordinal
            "BlurredContent" -> ViewHolderType.BLLURED.ordinal
            else -> ViewHolderType.ERROR.ordinal
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ViewHolderType.PHOTO_CONTENT.ordinal -> {
                (holder as PhotosViewHolder).bind()
            }
            ViewHolderType.BLLURED.ordinal ->{
                (holder as BlurViewHolder).bind()
            }
        }

    }

    override fun getItemCount(): Int {
        return photosList.size
    }
}