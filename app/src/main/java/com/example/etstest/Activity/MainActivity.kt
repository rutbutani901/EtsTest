package com.example.etstest.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.downloader.hd.allvideodownloader.viewPager.MainActivityViewPager
import com.example.etstest.R
import com.example.etstest.databinding.ActivityMainBinding
import com.example.etstest.fragments.*
import com.example.etstest.viewModels.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val categoryFragment = CategoryFragment()
    private val curateFragment = CurateFragment()
    private val saleFragment = SaleFragment()
    private val moreFragment = MoreFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createFragments()

    }

    lateinit var mainActivityViewPager: MainActivityViewPager
    fun createFragments() {

        val fragList= arrayListOf(
            homeFragment,
            categoryFragment,
            curateFragment,
            saleFragment,
            moreFragment
        )


        mainActivityViewPager = MainActivityViewPager(this@MainActivity, fragList)
        binding.viewPager2.adapter = mainActivityViewPager
        binding.viewPager2.offscreenPageLimit= mainActivityViewPager.itemCount
        binding.viewPager2.isUserInputEnabled=false

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home ->{
                        binding.bottomNavigationView.menu.getItem(0).isChecked = true;
                        binding.viewPager2.setCurrentItem(0,false)


                    }
                    R.id.category -> {
                        binding.bottomNavigationView.menu.getItem(1).isChecked = true;
                        binding.viewPager2.setCurrentItem(1,false)
//                        createFragment.isNetworkAvailable()

                    }
                    R.id.curate ->{
                        binding.bottomNavigationView.menu.getItem(2).isChecked = true
                        binding.viewPager2.setCurrentItem(2,false)

                    }
                    R.id.sale -> {

                        binding.bottomNavigationView.menu.getItem(3).isChecked = true
                        binding.viewPager2.setCurrentItem(3,false)


                    }
                    R.id.more -> {

                        binding.bottomNavigationView.menu.getItem(4).isChecked = true
                        binding.viewPager2.setCurrentItem(4,false)


                    }
                }
                false
            })



//        binding.tabs.setOnItemSelectedListener { position ->
//            binding.viewPager2.currentItem = position
//        }
//        binding.viewPager2.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                binding.tabs.itemActiveIndex = position
//
//            }
//        })
    }

}