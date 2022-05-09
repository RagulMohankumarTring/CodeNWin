package com.example.codenwin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codenwin.R
import com.example.codenwin.model.CourseCapsule
import com.example.codenwin.model.CourseModel
import kotlinx.android.synthetic.main.course_view_item.view.*
import kotlinx.android.synthetic.main.feelings_section.view.*
import java.util.zip.Inflater

class CourseItemAdapter(var courseItemData:List<CourseModel>):RecyclerView.Adapter<CourseItemAdapter.CourseItemViewHolder>() {
    inner class CourseItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var courseImage : ImageView
        var courseName : TextView
        init {
            courseImage = itemView.findViewById(R.id.courseImage)
            courseName = itemView.findViewById(R.id.courseName)
        }
        fun bind(){
            itemView.heart_course.setOnClickListener {
                itemView.heart_course.setImageResource(R.drawable.heart_filled_course)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseItemViewHolder {
        return CourseItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.course_view_item,parent,false))
    }

    override fun onBindViewHolder(holder: CourseItemViewHolder, position: Int) {
        (holder as CourseItemViewHolder).bind()
        holder.courseImage.setImageResource(courseItemData[position].ImageUrl)
        holder.courseName.text=courseItemData[position].courseName
    }

    override fun getItemCount(): Int {
        return courseItemData.size
    }
}