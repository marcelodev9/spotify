package com.spotify.ui.feature.main.home.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.spotify.R
import com.spotify.data.model.BandShow
import com.spotify.ui.feature.main.home.enums.RecyclerViewAdapterEnum

class RecyclerViewListAdapter(
    private val context: Context,
    private val bandShowMain: ArrayList<BandShow>
) :
    RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder>() {

    class ViewHolder(view: View, type: String) : RecyclerView.ViewHolder(view) {
        var imageViewBand: ImageView? = null
        var textViewTitle: TextView? = view.findViewById(R.id.textViewTitle)
        var textViewDescription: TextView? = null
        var recyclerViewBand: RecyclerView? = view.findViewById(R.id.recyclerViewBand)

        init {
            if(type == RecyclerViewAdapterEnum.FULL.name) {
                imageViewBand = view.findViewById(R.id.imageViewBand)
                textViewDescription = view.findViewById(R.id.textViewDescription)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var view: View

        if(bandShowMain[viewType].type == RecyclerViewAdapterEnum.FULL.name) {
            view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.layout_list_horizontal_type_full, viewGroup, false)
        }
        else {
            view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.layout_list_horizontal_type_default, viewGroup, false)
        }

        return ViewHolder(view, bandShowMain[viewType].type)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if(bandShowMain[position].type == RecyclerViewAdapterEnum.FULL.name) {
            viewHolder.textViewDescription!!.text = bandShowMain[position].description
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(125))
            Glide.with(context).load(bandShowMain[position].image).apply(requestOptions)
                .into(viewHolder.imageViewBand!!)
        }
        viewHolder.textViewTitle!!.text = bandShowMain[position].title

        val recyclerViewListAdapter =
            RecyclerViewItemListAdapter(context, bandShowMain[position].bandList, bandShowMain[position].type)
        val layoutManagerMain: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewHolder.recyclerViewBand!!.layoutManager = layoutManagerMain
        viewHolder.recyclerViewBand!!.setHasFixedSize(true)
        viewHolder.recyclerViewBand!!.adapter = recyclerViewListAdapter
    }

    override fun getItemCount() = bandShowMain.size

}
