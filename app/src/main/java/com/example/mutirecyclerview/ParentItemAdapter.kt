package com.example.mutirecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class ParentItemAdapter(private val itemList: List<ParentItem>) :
    RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_item, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parentItem = itemList[position]

        holder.parentItemTitle.text = parentItem.parentItemTitle

        val layoutManager = LinearLayoutManager(
            holder.childRecyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        layoutManager.initialPrefetchItemCount = parentItem.childItemList.size

        val childItemAdapter = ChildItemAdapter(parentItem.childItemList)
        holder.childRecyclerView.layoutManager = layoutManager
        holder.childRecyclerView.adapter = childItemAdapter
        holder.childRecyclerView.setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parentItemTitle: TextView = itemView.findViewById(R.id.parent_item_title)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.child_recyclerview)
    }
}
