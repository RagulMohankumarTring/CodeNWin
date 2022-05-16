package com.example.codenwin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.codenwin.R
import com.example.codenwin.adapter.ReelsAdapter
import com.example.codenwin.model.PhotosModel
import com.example.codenwin.model.VideoModel
import kotlinx.android.synthetic.main.fragment_reels.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReelsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReelsFragment : Fragment() {
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
    fun init(){
        var reelsList:MutableList<VideoModel> = ArrayList()
        reelsList.add(VideoModel(R.drawable.profile_pic_1,"Elon Musk","People say nothing is impossible, but I do nothing every day.","android.resource://com.example.codenwin/"+R.raw.video1 ,690,34))
        reelsList.add(VideoModel(R.drawable.user_profile_pic,"Jeff","If you think nothing is impossible, try slamming a revolving door.","android.resource://com.example.codenwin/"+R.raw.video2 ,845,78))
        reelsList.add(VideoModel(R.drawable.post_profile_3,"Shaun Kumar","I finally realized that people are prisoners of their phones… that’s why it’s called a “cell” phone. ","android.resource://com.example.codenwin/"+R.raw.video3 ,567,34))
        reelsList.add(VideoModel(R.drawable.post_profile_4,"Ratan Tata","Your secrets are safe with me… I wasn’t even listening.","android.resource://com.example.codenwin/"+R.raw.video4 ,345,54))
        var reelsViewPager = reels
        reelsViewPager.adapter=ReelsAdapter(reelsList)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reels, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReelsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReelsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}