package com.example.codenwin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.codenwin.R
import com.example.codenwin.adapter.PhotosAdapter
import com.example.codenwin.model.PhotosModel
import kotlinx.android.synthetic.main.fragment_photos.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [Photos.newInstance] factory method to
 * create an instance of this fragment.
 */
class Photos : Fragment() {
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
        var photosList:MutableList<PhotosModel> = ArrayList()
        photosList.add(PhotosModel(R.drawable.photos_1))
        photosList.add(PhotosModel(R.drawable.photos_1))
        photosList.add(PhotosModel(R.drawable.photos_2))
        photosList.add(PhotosModel(R.drawable.photos_3))
        photosList.add(PhotosModel(R.drawable.photos_4))
        var layoutType = ArrayList<String>()
        layoutType.add("BlurredContent")
        layoutType.add("PhotoContent")
        layoutType.add("PhotoContent")
        layoutType.add("PhotoContent")
        layoutType.add("PhotoContent")
        var photosRecycler = photosRecyclerView
        var snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(photosRecycler)
        photosRecycler.layoutManager=LinearLayoutManager(context)
        photosRecycler.adapter=PhotosAdapter(layoutType,photosList,context)
        photosRecycler.setHasFixedSize(true)
        photoRecyclerList=photosRecycler
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Photos.
         */
        // TODO: Rename and change types and number of parameters
        lateinit var photoRecyclerList:RecyclerView
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Photos().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}