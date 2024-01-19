package com.example.etstest.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.etstest.apiCalling.ApiClient
import com.example.etstest.modelClass.*
import com.example.etstest.pojo.CategoryPojo
import com.example.etstest.pojo.TopPojo
import retrofit2.Call
import retrofit2.Response

class CategoryViewModel : ViewModel() {

    var allCategoryData = MutableLiveData<HashMap<String,List<String>>>()


    fun callApis()
    {

        ApiClient.getApiInterface().getCategoryResults()
            .enqueue(object : retrofit2.Callback<CategoryPojo> {
                override fun onResponse(
                    call: Call<CategoryPojo>,
                    response: Response<CategoryPojo>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {body->

                            var categoryMap = HashMap<String,List<String>>()

                            for(item in body.categories){

                                var name=item.category_name
//                                var childList= ArrayList<ChildCategoryModel>()
                                var childList= ArrayList<String>()

                                for(child in item.child){

//                                    childList.add(ChildCategoryModel(child.category_id,child.category_name,child.parent_id))
                                    childList.add(child.category_name)

                                }
                                categoryMap[name] = childList
                            }

                            allCategoryData.postValue(categoryMap)

                        }
                    }
                }
                override fun onFailure(call: Call<CategoryPojo>, t: Throwable) {

                    Log.d("dfdfdjfkdfdjkdfailed",t.message.toString())
                }
            })


    }
}