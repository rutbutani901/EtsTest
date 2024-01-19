package com.example.etstest.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.etstest.R
import com.example.etstest.adapter.*
import com.example.etstest.databinding.FragmentHomeBinding
import com.example.etstest.modelClass.*
import com.example.etstest.viewModels.HomeViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    lateinit var fragmenActivity: FragmentActivity
    lateinit var binding: FragmentHomeBinding

    lateinit var homeViewModel: HomeViewModel

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

        binding = FragmentHomeBinding.inflate(layoutInflater)

        homeViewModel = ViewModelProvider(fragmenActivity)[HomeViewModel::class.java]
         homeViewModel.callApis()


        homeViewModel.generalList.observe(fragmenActivity, Observer {firstHashMap->

            setAdapter(firstHashMap)

        })
        homeViewModel.shopList.observe(fragmenActivity, Observer {sortList->

            setShopAdapter(sortList)

        })
        homeViewModel.fabricList.observe(fragmenActivity, Observer {sortList->

            setFabricAdapter(sortList)

        })
        homeViewModel.unstitchedList.observe(fragmenActivity, Observer {sortList->

            setUnStichedSliderAdapter(sortList)

        })


        homeViewModel.botiqueList.observe(fragmenActivity, Observer {sortList->

            setBotiqueAdapter(sortList)

        })
        homeViewModel.patternList.observe(fragmenActivity, Observer {sortList->

            setPatternAdapter(sortList)

        })
        homeViewModel.occasionList.observe(fragmenActivity, Observer {sortList->

            setOccasionAdapter(sortList)


        })


        return binding.root
    }

    var firstAdapter: HomeFirstAdapter?=null
    private fun setAdapter(map: HashMap<ParentData, ArrayList<SliderData>>) {

        val firstList : ArrayList<ParentData> = ArrayList(map.keys)

        val list= map.get(firstList[0]) as ArrayList
        setSliderAdapter(list)

        firstAdapter = HomeFirstAdapter(fragmenActivity, firstList) {position ->

            val list= map.get(firstList[position]) as ArrayList
            setSliderAdapter(list)
        }
        binding.firstRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.firstRecycler.adapter = firstAdapter
    }


    var sliderAdapter: HomeSliderAdapter?=null
    private fun setSliderAdapter(sliderList:  ArrayList<SliderData>) {

        sliderAdapter = HomeSliderAdapter(fragmenActivity, sliderList) {position ->

        }
//        binding.firstRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
//        binding.firstRecycler.adapter = sliderAdapter


        binding.carsRecyclerview.adapter = sliderAdapter
        binding.carsRecyclerview.apply {
            set3DItem(true)
            setAlpha(true)
//            setInfinite(true)
        }
//        binding.carsRecyclerview.minimumHeight=50

    }


    var shopAdapter: ShopCategoryAdapter?=null
    private fun setShopAdapter(shopList: List<ShopModel>) {


        shopAdapter = ShopCategoryAdapter(fragmenActivity, shopList) {position ->

        }
        binding.shopRecycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        binding.shopRecycler.adapter = shopAdapter
    }

    var fabricAdapter: FabricCategroyAdapter?=null
    private fun setFabricAdapter(fabricList: List<ShopModel>) {


        fabricAdapter = FabricCategroyAdapter(fragmenActivity, fabricList) {position ->

        }
        binding.fabricRecycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        binding.fabricRecycler.adapter = fabricAdapter
    }


    var unstichedAdapter: UnStichedSliderAdapter?=null
    private fun setUnStichedSliderAdapter(unstichedlist:  List<UnStitchedModel>) {

        unstichedAdapter = UnStichedSliderAdapter(fragmenActivity, unstichedlist) {position ->

        }
//        binding.firstRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
//        binding.firstRecycler.adapter = unstichedAdapter


        binding.unStictchedRecycler.adapter = unstichedAdapter
        binding.unStictchedRecycler.apply {
            set3DItem(true)
            setAlpha(true)
//            setInfinite(true)
        }
//        binding.carsRecyclerview.minimumHeight=50

    }

    var botiqueAdapter: BotiqueAdapter?=null
    private fun setBotiqueAdapter(botiqueList: List<BotiqueModel>) {


        botiqueAdapter = BotiqueAdapter(fragmenActivity, botiqueList) {position ->

        }
        binding.botiqueRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.botiqueRecycler.adapter = botiqueAdapter
    }

    var patternAdapter: PatternAdapter?=null
    private fun setPatternAdapter(fabricList: List<PatternModel>) {


        patternAdapter = PatternAdapter(fragmenActivity, fabricList) {position ->

        }
        binding.patternRecycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        binding.patternRecycler.adapter = patternAdapter
    }

    var occasionAdapter: OccasionAdapter?=null
    private fun setOccasionAdapter(fabricList: List<OccasionModel>) {


        occasionAdapter = OccasionAdapter(fragmenActivity, fabricList) {position ->

        }
        binding.occasionRecycler.layoutManager = GridLayoutManager(fragmenActivity,3, GridLayoutManager.VERTICAL,false)
        binding.occasionRecycler.adapter = occasionAdapter
    }

}