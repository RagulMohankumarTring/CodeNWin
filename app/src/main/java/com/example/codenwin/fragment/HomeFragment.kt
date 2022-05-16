package com.example.codenwin.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codenwin.R
import com.example.codenwin.adapter.CoverAdapter
import com.example.codenwin.adapter.TotalContentAdapter
import com.example.codenwin.model.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private var coverRecyclerView: RecyclerView? = null
    private var coverAdapter: CoverAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    private fun init() {
        menu.setOnClickListener {
            menu.setBackgroundColor(Color.GREEN)
        }
        notify_bell.setOnClickListener {
            activeIcon.visibility = View.GONE
        }
        searchIcon.setOnClickListener {
            searchIcon.setBackgroundColor(Color.GREEN)
        }
        val coverItemData:MutableList<StatusModel> = ArrayList()
        coverItemData.add(StatusModel("",R.drawable.plus_status_image))
        coverItemData.add(StatusModel("HR Team",R.drawable.status_image_one))
        coverItemData.add(StatusModel("Creative Bees",R.drawable.status_image_two))
        coverItemData.add(StatusModel("TechMads",R.drawable.status_image_three))
        coverItemData.add(StatusModel("Cloud 9",R.drawable.status_image_four))

        val postTopPart:MutableList<PostTopPartModel> = ArrayList()
        postTopPart.add(PostTopPartModel(R.drawable.profile_pic_1,"John Mathis","Product Delivery Manager","Successfully delivered this great kitchen app to the market.Kudos to the entire team","#Network #kitchenapp #foodies #productdesign...",R.drawable.post_image,"3 hours ago",450,97,"Likes by hju and 449 others"))
        postTopPart.add(PostTopPartModel(R.drawable.postprofile2,"Joel Rhodes","Director Marketing Sales","Good marketing makes the company look smart.Great marketing makes the customer look smart","#Sales #marketing #statergy #businessgoals # di...",0,"9 hours ago",78,17,"Likes by poi and 77 others"))
        postTopPart.add(PostTopPartModel(R.drawable.post_profile_3,"Landon Murray","Creative Director","Design is all about, using your brain 100%","#creative design #Brainstroming #UI/UX #Rese...",R.drawable.post3,"1 hours ago",33,8,"Likes by iuy and 32 others"))
        postTopPart.add(PostTopPartModel(R.drawable.post_profile_4,"Tringapps","Management","Tringapps is now an AWS partner.","#Management #tringers #tringapps #AWS #am...",0,"7 hours ago",660,57,"Likes by dfj and 659 others"))
        postTopPart.add(PostTopPartModel(0,"","","","",0,"5 hours ago",360,27,"Likes by yui and 359 others"))
//        val coverData : MutableList<CoverModel> = ArrayList()
//        coverData.add(CoverModel("status",coverItemData))
//         totalContentRecyclerView.layoutManager = LinearLayoutManager(context)
//        totalContentRecyclerView.adapter = CoverAdapter(context,coverData)
        val type = ArrayList<String>()
        type.add("Type E")
        type.add("Type A")
        type.add("Type B")
        type.add("Type A")
        type.add("Type C")
        type.add("Type D")
        val courseItemData:MutableList<CourseModel> = ArrayList()
        courseItemData.add(CourseModel("Amazon Dynamo DB",R.drawable.course_pic_1))
        courseItemData.add(CourseModel("Portfolio Management",R.drawable.course_pic_2))
//        val courseData : MutableList<CourseCapsule> = ArrayList()
//        courseData.add(CourseCapsule(courseItemData))
        diffTypes.layoutManager = LinearLayoutManager(context)
        diffTypes.adapter = TotalContentAdapter(context,type,courseItemData,coverItemData,postTopPart)
        diffTypes.setHasFixedSize(true)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }
}