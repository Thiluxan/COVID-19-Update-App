package com.example.assignment1

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.covid_19updates.R
import com.squareup.picasso.Picasso

class MyListAdapter(private val context: Activity, private val title: ArrayList<String>, private val body:ArrayList<String>, private val active:ArrayList<String>,
                    private val deaths:ArrayList<String>, private val recovered:ArrayList<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater!!.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById(R.id.label) as TextView
        val bodyText = rowView.findViewById(R.id.count) as TextView
        val activeText = rowView.findViewById(R.id.active) as TextView
        val deathText = rowView.findViewById(R.id.deaths) as TextView
        val recoveredText = rowView.findViewById(R.id.recovered) as TextView
        //var imageView = rowView.findViewById(R.id.flag) as ImageView

        titleText.text = title[position]
        bodyText.text = body[position]
        activeText.text = active[position]
        deathText.text = deaths[position]
        recoveredText.text = recovered[position]

        /*Picasso
            .get()
            .load(image[position])
            .into(imageView);*/

        return rowView
    }
}