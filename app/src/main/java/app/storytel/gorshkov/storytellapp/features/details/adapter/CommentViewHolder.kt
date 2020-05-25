package app.storytel.gorshkov.storytellapp.features.details.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.features.details.items.CommentItem
import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import kotlinx.android.synthetic.main.holder_scrolling.view.*

class CommentViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(item: CommentItem) {
        itemView.holder_title.text = item.name
        itemView.holder_description.text = item.body
    }
}