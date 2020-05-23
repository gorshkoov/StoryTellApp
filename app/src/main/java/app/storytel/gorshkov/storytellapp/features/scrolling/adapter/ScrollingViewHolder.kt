package app.storytel.gorshkov.storytellapp.features.scrolling.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import kotlinx.android.synthetic.main.holder_scrolling.view.*

class ScrollingViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(item: ScrollingItem) {
        itemView.holder_title.text = item.title
        itemView.holder_description.text = item.body
        itemView.setTag(R.id.tag_id, item.id)
    }
}