package com.example.covid_19updates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.example.assignment1.MyListAdapter
import com.example.covid_19updates.api.CovidApi
import com.example.covid_19updates.models.Covid
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gson = GsonBuilder().create()
        var retrofit = Retrofit.Builder()
            .baseUrl("https://disease.sh/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        var covidApi = retrofit.create(CovidApi::class.java)
        var covidCall = covidApi.summary

        covidCall.enqueue(object : Callback<List<Covid>>{
            override fun onFailure(call: Call<List<Covid>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failed to load Data\nCheck your internet connection",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Covid>>, response: Response<List<Covid>>) {
                var list = response.body()
                Log.d("Response: ",response.toString())
                var countryList = ArrayList<String>()
                var countList = ArrayList<String>()
                var activeList = ArrayList<String>()
                var deathList = ArrayList<String>()
                var recoveredList = ArrayList<String>()
                var imageList = ArrayList<String>()
                list?.map { item ->
                    countryList.add(item.country.toString())
                    var totalCases = "Total Cases: "+item.cases.toString()
                    var activeCases = "Active Cases: "+item.active.toString()
                    var deaths = "Total Deaths: "+item.deaths.toString()
                    var recovered = "Total Recovered: "+item.recovered.toString()
                    countList.add(totalCases)
                    activeList.add(activeCases)
                    deathList.add(deaths)
                    recoveredList.add(recovered)

                }

                var myListAdapter = MyListAdapter(this@MainActivity,countryList!!,countList!!,activeList!!,deathList!!,recoveredList!!)
                findViewById<ListView>(R.id.country_list).adapter = myListAdapter
            }

        })
    }
}