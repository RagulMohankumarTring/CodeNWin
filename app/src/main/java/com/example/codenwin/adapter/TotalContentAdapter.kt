package com.example.codenwin.adapter

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codenwin.HomeFragment
import com.example.codenwin.R
import com.example.codenwin.mapper.ItemMapper
import com.example.codenwin.model.CourseCapsule
import com.example.codenwin.model.CourseModel
import com.example.codenwin.model.PostTopPartModel
import com.example.codenwin.model.StatusModel
import kotlinx.android.synthetic.main.course_view_item.view.*
import kotlinx.android.synthetic.main.feelings_section.view.*
import kotlinx.android.synthetic.main.profile_item.view.*
import kotlinx.android.synthetic.main.status_cover.view.*
import kotlinx.android.synthetic.main.top_part.view.*

class TotalContentAdapter(
    val context: Context?,
    var type: ArrayList<String>,
    var courseData: List<CourseModel>,
    var statusData: List<StatusModel>,
    var postTopPart: List<PostTopPartModel>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewHolderType {
        TYPE_A, TYPE_B, TYPE_C, TYPE_D, TYPE_E, ERROR
    }

    private var list: MutableList<String> = mutableListOf()
    var homeFragment = HomeFragment()

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var postImage: ImageView
        val comment: EditText
        val submitArrow: ImageView
        val reply: TextView

        init {
            postImage = itemView.findViewById(R.id.postImage)
            comment = itemView.findViewById(R.id.addComent)
            submitArrow = itemView.findViewById(R.id.submit_arrow)
            reply = itemView.findViewById(R.id.reply)
        }

        fun bind() {
            itemView.profilePic.setImageResource(postTopPart[position - 1].profilePic)
            itemView.profileName.text = postTopPart[position - 1].profileName
            itemView.designation.text = postTopPart[position - 1].designation
            itemView.caption.text = postTopPart[position - 1].caption
            itemView.hashtag.text = postTopPart[position - 1].hashTag
            itemView.duration.text=postTopPart[position-1].hoursAgo
            itemView.liked.text=postTopPart[position-1].likes.toString()
            itemView.commented.text=postTopPart[position-1].comment.toString()
            itemView.personNameLiked.text=postTopPart[position-1].likedBy
            itemView.postImage.setImageResource(postTopPart[position-1].postPic)
            itemView.heart.setOnClickListener {
                itemView.heart.setImageResource(R.drawable.heart_filled)
            }
        }
    }

    inner class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            itemView.profilePic.setImageResource(postTopPart[position - 1].profilePic)
            itemView.profileName.text = postTopPart[position - 1].profileName
            itemView.designation.text = postTopPart[position - 1].designation
            itemView.caption.text = postTopPart[position - 1].caption
            itemView.hashtag.text = postTopPart[position - 1].hashTag
            itemView.duration.text=postTopPart[position-1].hoursAgo
            itemView.liked.text=postTopPart[position-1].likes.toString()
            itemView.commented.text=postTopPart[position-1].comment.toString()
            itemView.personNameLiked.text=postTopPart[position-1].likedBy
            itemView.heart.setOnClickListener {
                itemView.heart.setImageResource(R.drawable.heart_filled)
            }
        }
    }

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            itemView.profilePic.setImageResource(postTopPart[position - 1].profilePic)
            itemView.profileName.text = postTopPart[position - 1].profileName
            itemView.designation.text = postTopPart[position - 1].designation
            itemView.caption.text = postTopPart[position - 1].caption
            itemView.hashtag.text = postTopPart[position - 1].hashTag
            itemView.duration.text=postTopPart[position-1].hoursAgo
            itemView.liked.text=postTopPart[position-1].likes.toString()
            itemView.commented.text=postTopPart[position-1].comment.toString()
            itemView.personNameLiked.text=postTopPart[position-1].likedBy
            itemView.heart.setOnClickListener {
                itemView.heart.setImageResource(R.drawable.heart_filled)
            }
        }
    }

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseRecyclerView: RecyclerView

        init {
            courseRecyclerView = itemView.findViewById(R.id.courseRecyclerView)
        }

        fun bind() {
            itemView.duration.text=postTopPart[position-1].hoursAgo
            itemView.liked.text=postTopPart[position-1].likes.toString()
            itemView.commented.text=postTopPart[position-1].comment.toString()
            itemView.personNameLiked.text=postTopPart[position-1].likedBy
            itemView.heart.setOnClickListener {
                itemView.heart.setImageResource(R.drawable.heart_filled)
            }
        }
    }

    inner class StatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val statusRecyclerView: RecyclerView

        init {
            statusRecyclerView = itemView.findViewById(R.id.coverItemRecyclerView)
        }

        fun bind() {

        }
    }

    inner class ErrorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (type[position]) {
            "Type A" -> ViewHolderType.TYPE_A.ordinal
            "Type B" -> ViewHolderType.TYPE_B.ordinal
            "Type C" -> ViewHolderType.TYPE_C.ordinal
            "Type D" -> ViewHolderType.TYPE_D.ordinal
            "Type E" -> ViewHolderType.TYPE_E.ordinal
            else -> ViewHolderType.ERROR.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        Log.d("check", viewType.toString())
        Log.d("check", "Got:${ViewHolderType.TYPE_A.ordinal}")
        return when (viewType) {
            ViewHolderType.TYPE_A.ordinal -> {
                Log.d("check", "A")
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.profile_item, parent, false)
                return PostViewHolder(view)
            }
            ViewHolderType.TYPE_B.ordinal -> {
                Log.d("check", "B")
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.gallery_item, parent, false)
                return GalleryViewHolder(view)
            }
            ViewHolderType.TYPE_C.ordinal -> {
                Log.d("check", "C")
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
                return BannerViewHolder(view)
            }
            ViewHolderType.TYPE_D.ordinal -> {
                Log.d("check", "D")
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.course_view, parent, false)
                return CourseViewHolder(view)
            }
            ViewHolderType.TYPE_E.ordinal -> {
                Log.d("check", "E")
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.status_cover_item, parent, false)
                return StatusViewHolder(view)
            }
            else -> {
                Log.d("check", "Error")
                return ErrorViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.error_text, parent, false)
                )
            }
        }
//        Log.d("check",viewType.toString())
//        Log.d("check","Got:${ItemMapper.getLayoutId("Status")}")
//        return when(viewType) {
//            ItemMapper.getLayoutId(widgetType = "Status")-> {
//                val v =
//                    LayoutInflater.from(parent.context).inflate(R.layout.home_status, parent, false)
//                ViewHolder(v)
//            }
//            else -> {
//                val v =
//                    LayoutInflater.from(parent.context).inflate(R.layout.error_text, parent, false)
//                ViewHolder(v)
//            }
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ViewHolderType.TYPE_A.ordinal -> {
                (holder as PostViewHolder).bind()
                holder.submitArrow.setOnClickListener {
                    holder.reply.text = holder.comment.text
                }
            }
            ViewHolderType.TYPE_B.ordinal -> {
                (holder as GalleryViewHolder).bind()
            }
            ViewHolderType.TYPE_C.ordinal -> {
                (holder as BannerViewHolder).bind()
            }
            ViewHolderType.TYPE_D.ordinal -> {
                setCourseRecyclerView(
                    (holder as CourseViewHolder).courseRecyclerView,
                    courseData
                )
            }
            ViewHolderType.TYPE_E.ordinal -> {
                setStatusRecyclerView((holder as StatusViewHolder).statusRecyclerView, statusData)
            }
        }
    }

    fun setStatusRecyclerView(recyclerView: RecyclerView, statusData: List<StatusModel>) {
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = CoverItemAdapter(statusData)
    }

    fun setCourseRecyclerView(recyclerView: RecyclerView, courseData: List<CourseModel>) {
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = CourseItemAdapter(courseData)
    }

    override fun getItemCount(): Int {
        return type.size
    }
}