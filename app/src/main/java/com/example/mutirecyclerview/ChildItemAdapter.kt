package com.example.mutirecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChildItemAdapter(private val childItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        // Inflate the layout for the child item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_item, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        // Get the ChildItem for the given position
        val childItem = childItemList[position]
        //Set resource of image
        holder.imageAvatar.setImageResource(childItem.imageThumb)
        // Set the title for the ChildItem
        holder.childItemTitle.text = childItem.ChildItemTitle
    }

    override fun getItemCount(): Int {
        // Return the number of items in the childItemList
        return childItemList.size
    }

    // Initialize the Views in the child RecyclerView
    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageAvatar: ImageView = itemView.findViewById(R.id.img_child_item)
        val childItemTitle: TextView = itemView.findViewById(R.id.child_item_title)
    }
}
