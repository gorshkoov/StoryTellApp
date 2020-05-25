package app.storytel.gorshkov.storytellapp.features.scrolling.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_scrolling.view.*

class ScrollingViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(item: ScrollingItem) {
        itemView.holder_title.text = item.title
        itemView.holder_description.text = item.body
        itemView.setTag(R.id.tag_item, item)
        Picasso.get()
            .load(item.thumbnailUrl)
            .into(itemView.holder_image)
    }
}