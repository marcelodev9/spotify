package com.spotify.ui.feature.main.library.fragments.music_fragment.fragments.album.adapters

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
import com.spotify.data.model.AlbumLibrary

class RecyclerViewListAdapter(
    private val context: Context,
    private val albumLibrary: ArrayList<AlbumLibrary>
) :
    RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewBand: ImageView? = view.findViewById(R.id.imageViewLibrary)
        var textViewTitle: TextView? = view.findViewById(R.id.textViewTitle)
        var textViewDescription: TextView? = view.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_library_music_playlists_album, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewDescription!!.text = albumLibrary[position].description
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(1))
        Glide.with(context).load(albumLibrary[position].image).apply(requestOptions)
            .into(viewHolder.imageViewBand!!)
        viewHolder.textViewTitle!!.text = albumLibrary[position].title
    }

    override fun getItemCount() = albumLibrary.size

}
