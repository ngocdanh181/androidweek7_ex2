package com.example.mutirecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentRecyclerViewItem = findViewById<RecyclerView>(R.id.parent_recyclerview)

        // Initialize the LinearLayoutManager
        val layoutManager = LinearLayoutManager(this)

        // Pass the arguments to the parentItemAdapter
        val parentItemAdapter = ParentItemAdapter(ParentItemList())

        // Set the layout manager and adapter for items
        // of the parent RecyclerView
        parentRecyclerViewItem.adapter = parentItemAdapter
        parentRecyclerViewItem.layoutManager = layoutManager
    }

    private fun ParentItemList(): List<ParentItem> {
        val itemList = ArrayList<ParentItem>()

        val item = ParentItem("Game", ChildItemList())
        itemList.add(item)
        val item1 = ParentItem("Movie", ChildItemList1())
        itemList.add(item1)
        val item2 = ParentItem("Game", ChildItemList())
        itemList.add(item2)
        val item3 = ParentItem("Movie", ChildItemList1())
        itemList.add(item3)

        return itemList
    }

    // Method to pass the arguments for the elements
    // of the child RecyclerView
    private fun ChildItemList(): List<ChildItem> {
        val childItemList = ArrayList<ChildItem>()

        childItemList.add(ChildItem(R.drawable.fifa,"Fifa Online"))
        childItemList.add(ChildItem(R.drawable.fifa,"Fifa Online"))
        childItemList.add(ChildItem(R.drawable.fifa,"Fifa Online"))
        childItemList.add(ChildItem(R.drawable.fifa,"Fifa Online"))

        return childItemList
    }
    private fun ChildItemList1(): List<ChildItem> {
        val childItemList1 = ArrayList<ChildItem>()

        childItemList1.add(ChildItem(R.drawable.hollywood1,"Harry Porter"))
        childItemList1.add(ChildItem(R.drawable.hollywood2,"Super Natural"))
        childItemList1.add(ChildItem(R.drawable.hollywood1,"Harry Porter"))
        childItemList1.add(ChildItem(R.drawable.hollywood2,"Super Natural"))

        return childItemList1
    }
}
