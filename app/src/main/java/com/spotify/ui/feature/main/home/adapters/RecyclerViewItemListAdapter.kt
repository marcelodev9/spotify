package com.spotify.ui.feature.main.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.spotify.R
import com.spotify.data.model.Band
import com.spotify.ui.feature.main.home.enums.RecyclerViewAdapterEnum

class RecyclerViewItemListAdapter(
    private val context: Context,
    private val bandShowMain: ArrayList<Band>,
    private val type: String
) :
    RecyclerView.Adapter<RecyclerViewItemListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewBand: ImageView
        val textViewTitle: TextView

        init {
            imageViewBand = view.findViewById(R.id.imageViewBand)
            textViewTitle = view.findViewById(R.id.textViewTitle)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_list_horizontal_adapter_type_1, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewTitle.text = bandShowMain[position].name

        viewHolder.itemView.setOnClickListener {

        }

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(if(type == RecyclerViewAdapterEnum.FULL.name) 1 else 20))

        Glide.with(context).load(bandShowMain[position].image).apply(requestOptions).into(viewHolder.imageViewBand)
    }

    override fun getItemCount() = bandShowMain.size

}
