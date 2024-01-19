package com.example.etstest.modelClass

data class BottomPojo(
    val design_occasion: List<DesignOccasion>,
    val message: String,
    val range_of_pattern: List<RangeOfPattern>,
    val status: String
)

data class DesignOccasion(
    val cta: String,
    val image: String,
    val name: String,
    val product_id: String,
    val sub_name: String
)
data class RangeOfPattern(
    val image: String,
    val name: String,
    val product_id: String
)