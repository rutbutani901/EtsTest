package com.example.etstest.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.etstest.R
import com.example.etstest.adapter.CustomizedExpandableListAdapter
import com.example.etstest.databinding.FragmentCategoryBinding
import com.example.etstest.modelClass.ChildCategoryModel
import com.example.etstest.viewModels.CategoryViewModel


class CategoryFragment : Fragment() {

    lateinit var fragmenActivity: FragmentActivity
    lateinit var binding: FragmentCategoryBinding

    lateinit var categoryViewModel: CategoryViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmenActivity = context as FragmentActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (activity != null) fragmenActivity = activity as FragmentActivity

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCategoryBinding.inflate(layoutInflater)

        categoryViewModel = ViewModelProvider(fragmenActivity)[CategoryViewModel::class.java]
        categoryViewModel.callApis()


        categoryViewModel.allCategoryData.observe(fragmenActivity, Observer {categoryMap->


            setAdapter(categoryMap)

        })

        return binding.root
    }
    var expandableListAdapter: ExpandableListAdapter? = null


    private fun setAdapter(map: HashMap<String, List<String>>) {

//        val titleList : ArrayList<String> = ArrayList(map.keys)
//
//        expandableListAdapter = CustomizedExpandableListAdapter(fragmenActivity, titleList,map)
//        binding.expandableListViewSample.setAdapter(expandableListAdapter)

    }

//    var adapter: CategoryMainAdapter?=null
//    private fun setAdapter(map: HashMap<String, ArrayList<ChildCategoryModel>>) {
//
//        val firstList : ArrayList<String> = ArrayList(map.keys)
//
//
//        adapter = CategoryMainAdapter(fragmenActivity, firstList) {position ->
//
//            val list= map.get(firstList[position]) as ArrayList
//
//        }
//        binding.recycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
//        binding.recycler.adapter = adapter
//    }

}