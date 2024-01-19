package com.example.etstest.modelClass

data class MiddlePojo(
    val Unstitched: List<Unstitched>,
    val boutique_collection: List<BoutiqueCollection>,
    val message: String,
    val shop_by_category: List<ShopByCategory>,
    val shop_by_fabric: List<ShopByFabric>,
    val status: String
)

data class BoutiqueCollection(
    val banner_id: String,
    val banner_image: String,
    val cta: String,
    val name: String
)

data class ShopByCategory(
    val category_id: String,
    val image: String,
    val name: String,
    val sort_order: String,
    val tint_color: String
)

data class ShopByFabric(
    val fabric_id: String,
    val image: String,
    val name: String,
    val sort_order: String,
    val tint_color: String
)

data class Unstitched(
    val description: String,
    val image: String,
    val name: String,
    val range_id: String
)