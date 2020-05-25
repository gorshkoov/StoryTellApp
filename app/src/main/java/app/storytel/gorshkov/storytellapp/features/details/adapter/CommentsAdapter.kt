package app.storytel.gorshkov.storytellapp.features.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.features.details.items.CommentItem
import app.storytel.gorshkov.storytellapp.features.scrolling.adapter.ScrollingViewHolder
import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem

class CommentsAdapter(
    val items: List<CommentItem>
) : RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.holder_comment, parent, false)
        val holder = CommentViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(items[position])
    }
}