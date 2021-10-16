package com.spotify.ui.feature.main.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.spotify.R
import com.spotify.data.model.Band

@Suppress("DEPRECATION")
class GridViewListAdapter(
    context: Context,
    bandList: ArrayList<Band>
) :
    ArrayAdapter<Band?>(context, 0, bandList as List<Band?>) {
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var listitemView = convertView
        if (listitemView == null) {
            listitemView =
                LayoutInflater.from(context).inflate(R.layout.layout_list_column_main, parent, false)
        }

        listitemView!!.setOnClickListener {  }

        val band: Band? = getItem(position)
        val name = listitemView.findViewById<TextView>(R.id.textViewName)
        val image = listitemView.findViewById<ImageView>(R.id.imageViewBand)
        name.text = band!!.name
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(5))
        Glide.with(context).load(band.image).apply(requestOptions).into(image)
        return listitemView
    }
}