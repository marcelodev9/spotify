package com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.artists.adapters

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
import com.spotify.data.model.ArtistsLibrary

class RecyclerViewListAdapter(
    private val context: Context,
    private val bandShowMain: ArrayList<ArtistsLibrary>
) :
    RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewBand: ImageView? = view.findViewById(R.id.imageViewLibrary)
        var textViewTitle: TextView? = view.findViewById(R.id.textViewTitle)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_library_music_artists_adapter, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(125))
        Glide.with(context).load(bandShowMain[position].image).apply(requestOptions)
            .into(viewHolder.imageViewBand!!)
        viewHolder.textViewTitle!!.text = bandShowMain[position].title
    }

    override fun getItemCount() = bandShowMain.size

}
