package com.example.etstest.pojo

data class CategoryPojo(
    val banner_image: String,
    val categories: List<Category>,
    val message: String,
    val status: String
)
data class Category(
    val category_id: String,
    val category_name: String,
    val child: List<Child>,
    val parent_id: String
)
data class Child(
    val category_id: String,
    val category_name: String,
    val parent_id: String
)