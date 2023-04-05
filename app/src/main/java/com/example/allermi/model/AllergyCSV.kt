package com.example.allermi.model

import java.net.URL

data class AllergyCSV(
    val itemNum: String,
    val seperate: String,
    val itemName: String,
    val ingredient: String,
    val allergy: String,
    val typeName: String,
    val statement: String,
    val madeInInfor: String,
    val itemImageURL: URL,
    val metaImageURL: URL,
    val nutrient: String,
    val seller: String,
    val barcode: String,
    val amount: String
    )
