package com.example.covid_19updates

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class GlobalActivity : AppCompatActivity() {
    lateinit var tvCases:TextView
    lateinit var tvRecovered:TextView
    lateinit var tvActive:TextView
    lateinit var tvDeaths:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global)

        tvCases = findViewById(R.id.tvCases)
        tvRecovered = findViewById(R.id.tvRecovered)
        tvActive = findViewById(R.id.tvActive)
        tvDeaths = findViewById(R.id.tvTotalDeaths)

        fetchData()
    }

    private fun fetchData() {

        val url = "https://disease.sh/v3/covid-19/all"
        val request = StringRequest(
            Request.Method.GET,
            url,
            Listener { response ->

                try {

                    val jsonObject = JSONObject(
                        response
                    )


                    tvCases.text = jsonObject.getString(
                        "cases"
                    )
                    tvRecovered.text = jsonObject.getString(
                        "recovered"
                    )

                    tvActive.text = jsonObject.getString(
                        "active"
                    )

                    tvDeaths.setText(
                        jsonObject.getString(
                            "deaths"
                        )
                    )
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    this,
                    error.message,
                    Toast.LENGTH_SHORT
                )
                    .show()
            })
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(request)
    }
}