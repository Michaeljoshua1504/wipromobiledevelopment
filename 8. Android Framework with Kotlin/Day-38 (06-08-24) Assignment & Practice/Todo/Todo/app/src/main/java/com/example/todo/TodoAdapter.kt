package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TodoAdapter(private val context: Context, private val todoItems: List<TodoItem>) : BaseAdapter() {

    override fun getCount(): Int = todoItems.size

    override fun getItem(position: Int): Any = todoItems[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)
        val todoItem = getItem(position) as TodoItem

        val titleView = view.findViewById<TextView>(android.R.id.text1)
        val descriptionView = view.findViewById<TextView>(android.R.id.text2)

        titleView.text = todoItem.title
        descriptionView.text = todoItem.description

        return view
    }
}
