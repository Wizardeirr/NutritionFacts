package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class TotalNutrientsKCal(
    @SerializedName("CHOCDF_KCAL")
    val cHOCDFKCAL: CHOCDFKCAL,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: ENERCKCALXXX,
    @SerializedName("FAT_KCAL")
    val fATKCAL: FATKCAL,
    @SerializedName("PROCNT_KCAL")
    val pROCNTKCAL: PROCNTKCAL
)