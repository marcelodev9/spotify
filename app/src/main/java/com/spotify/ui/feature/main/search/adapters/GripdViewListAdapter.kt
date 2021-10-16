package com.spotify.ui.feature.main.search.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.spotify.R
import com.spotify.data.model.Category

class GridViewListAdapter(
    context: Context,
    private val bandList: ArrayList<Category>
) :
    ArrayAdapter<Category?>(context, 0, bandList as List<Category?>) {
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var listitemView = convertView
        if (listitemView == null) {
            listitemView =
                LayoutInflater.from(context).inflate(R.layout.layout_list_category_column, parent, false)
        }

        listitemView!!.setOnClickListener {  }

        val band: Category? = getItem(position)
        val title = listitemView!!.findViewById<TextView>(R.id.textViewTitle)
        val image = listitemView!!.findViewById<ImageView>(R.id.imageViewCategory)
        title.text = band!!.name
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(10))
        //Glide.with(context).load(band!!.image).apply(requestOptions).into(image)

        val categoryBackgroundColor = (0..bandList.size * 2).random()

        when(categoryBackgroundColor) {
            0 -> image.setBackgroundResource(R.drawable.layout_category_blue_light_gradient)
            1 -> image.setBackgroundResource(R.drawable.layout_category_green_gradient)
            2 -> image.setBackgroundResource(R.drawable.layout_category_blue_gradient)
            3 -> image.setBackgroundResource(R.drawable.layout_category_red_gradient)
            4 -> image.setBackgroundResource(R.drawable.layout_category_silver_gradient)
        }
        return listitemView
    }
}