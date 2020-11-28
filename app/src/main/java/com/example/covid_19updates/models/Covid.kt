package com.example.covid_19updates.models

import org.json.JSONObject

data class Covid(
    var updated: Long,
    var country:String,
    var countryInfo:JSONObject,
    var cases:Int,
    var todayCases:Int,
    var deaths:Int,
    var todayDeaths:Int,
    var recovered:Int,
    var todayRecovered:Int,
    var active:Int,
    var critical:Int,
    var casesPerOneMillion:Double,
    var deathsPerOneMillion:Double,
    var test:Long,
    var testPerOneMillion:Double,
    var population:Long,
    var continent:String,
    var oneCasePerPeople:Double,
    var oneDeathPerPeople:Double,
    var oneTestPerPeople:Double,
    var activePerOneMillion:Double,
    var recoveredPerOneMilion:Double,
    var criticalPerOneMillion:Double
)