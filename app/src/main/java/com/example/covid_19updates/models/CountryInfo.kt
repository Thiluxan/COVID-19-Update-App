package com.example.covid_19updates.models

data class CountryInfo(
    var id:Int,
    var iso2:String,
    var iso3:String,
    var lat:Int,
    var long:Int,
    var flag:String
)