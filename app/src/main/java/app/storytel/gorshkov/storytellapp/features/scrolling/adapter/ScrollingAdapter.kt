package app.storytel.gorshkov.storytellapp.features.scrolling.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem

class ScrollingAdapter(
    private val items: List<ScrollingItem>,
    private val itemClickListener: (view: View) -> Unit
) : RecyclerView.Adapter<ScrollingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrollingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.holder_scrolling, parent, false)
        val holder = ScrollingViewHolder(view)
        holder.itemView.setOnClickListener(itemClickListener)
        return holder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ScrollingViewHolder, position: Int) {
        holder.bind(items[position])
    }
}