package com.example.etstest.pojo

data class TopPojo(
    val main_sticky_menu: List<MainStickyMenu>,
    val message: String,
    val status: String
)

data class MainStickyMenu(
    val image: String,
    val slider_images: List<SliderImage>,
    val sort_order: String,
    val title: String
)

data class SliderImage(
    val cta: String,
    val image: String,
    val sort_order: String,
    val title: String
)