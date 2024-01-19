package com.example.etstest.viewModels

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.etstest.apiCalling.ApiClient
import com.example.etstest.modelClass.*
import com.example.etstest.pojo.TopPojo
import retrofit2.Call
import retrofit2.Response


class HomeViewModel : ViewModel() {

     var generalList = MutableLiveData<HashMap<ParentData,ArrayList<SliderData>>>()
     var shopList = MutableLiveData<List<ShopModel>>()
     var fabricList = MutableLiveData<List<ShopModel>>()
     var unstitchedList = MutableLiveData<List<UnStitchedModel>>()
     var botiqueList = MutableLiveData<List<BotiqueModel>>()
     var patternList = MutableLiveData<List<PatternModel>>()
     var occasionList = MutableLiveData<List<OccasionModel>>()

    fun callApis()
    {

        ApiClient.getApiInterface().getTopResults()
            .enqueue(object : retrofit2.Callback<TopPojo> {
                override fun onResponse(
                    call: Call<TopPojo>,
                    response: Response<TopPojo>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {body->

//                            var firstList= arrayListOf<GeneralTypes>()
                            val parentList= hashMapOf<ParentData,ArrayList<SliderData>>()

                            for (items in body.main_sticky_menu){

                                val sliderList= ArrayList<SliderData>()

                                for(sliders in items.slider_images){
                                    sliderList.add(SliderData(sliders.title,sliders.image))
                                }

                                parentList.put(ParentData(items.title,items.image), sliderList)

//                                parentList.add(GeneralTypes(items.title, items.image))
                            }


                            generalList.postValue(parentList)

                        }
                    }
                }
                override fun onFailure(call: Call<TopPojo>, t: Throwable) {

                    Log.d("dfdfdjfkdfdjkdfailed",t.message.toString())
                }
            })

        ApiClient.getApiInterface().getMiddleResults()
            .enqueue(object : retrofit2.Callback<MiddlePojo> {
                override fun onResponse(
                    call: Call<MiddlePojo>,
                    response: Response<MiddlePojo>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {body->

                            val shopListTemp= ArrayList<ShopModel>()
                            val fabricListTemp= ArrayList<ShopModel>()
                            val unstitchedListTemp= ArrayList<UnStitchedModel>()
                            val botiqueListTemp= ArrayList<BotiqueModel>()

                            for (items  in body.shop_by_category){

                                shopListTemp.add(ShopModel(items.name,items.image,items.sort_order.toInt(), items.tint_color))

                            }
                            for (items  in body.shop_by_fabric){

                                fabricListTemp.add(ShopModel(items.name,items.image,items.fabric_id.toInt(), items.tint_color))

                            }
                            for (items  in body.Unstitched){

                                unstitchedListTemp.add(UnStitchedModel(items.range_id.toInt(),items.name,items.description, items.image))

                            }
                            for (items  in body.boutique_collection){

                                botiqueListTemp.add(BotiqueModel(items.banner_id.toInt(),items.name,items.cta, items.banner_image))

                            }

                            var shopTemp = shopListTemp.sortedBy { it.sortOrder }
                            var fabricTemp = fabricListTemp.sortedBy { it.sortOrder }

                            shopList.postValue(shopTemp)
                            fabricList.postValue(fabricTemp)
                            unstitchedList.postValue(unstitchedListTemp)
                            botiqueList.postValue(botiqueListTemp)

                        }
                    }
                }
                override fun onFailure(call: Call<MiddlePojo>, t: Throwable) {

                    Log.d("dfdfdjfkdfdjkdfailed",t.message.toString())
                }
            })

        ApiClient.getApiInterface().getBottomResults()
            .enqueue(object : retrofit2.Callback<BottomPojo> {
                override fun onResponse(
                    call: Call<BottomPojo>,
                    response: Response<BottomPojo>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {body->

                            val patternListTemp= ArrayList<PatternModel>()
                            val occasionListTemp= ArrayList<OccasionModel>()

                            for (items  in body.range_of_pattern){

                                patternListTemp.add(PatternModel(items.product_id,items.image,items.name))

                            }

                            for (items  in body.design_occasion){

                                occasionListTemp.add(OccasionModel(items.product_id,items.name,items.image,items.sub_name, items.cta))

                            }
                            patternList.postValue(patternListTemp)
                            occasionList.postValue(occasionListTemp)


                        }
                    }

                }
                override fun onFailure(call: Call<BottomPojo>, t: Throwable) {

                    Log.d("dfdfdjfkdfdjkdfailed",t.message.toString())
                }
            })
    }
}