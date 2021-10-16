package com.spotify.ui.feature.main.search.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.spotify.R
import com.spotify.data.model.CategoryMain

class RecyclerViewListAdapter(
    private val context: Context,
    private val categoryMain: ArrayList<CategoryMain>
) :
    RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewTitle: TextView? = view.findViewById(R.id.textViewTitle)
        var gridViewCategory: GridView? = view.findViewById(R.id.gridViewMain)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.layout_list_category_main, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewTitle!!.text = categoryMain[position].title

        val adapter = GridViewListAdapter(context, categoryMain[position].categoryList)
        viewHolder.gridViewCategory!!.adapter = adapter
    }

    override fun getItemCount() = categoryMain.size

}
