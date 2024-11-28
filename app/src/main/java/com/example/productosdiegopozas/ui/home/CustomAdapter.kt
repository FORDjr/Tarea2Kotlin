package com.example.productosdiegopozas.ui.home

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.productosdiegopozas.R

class CustomAdapter(
    private var itemList: List<ListElement>,
    private val context: Context,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: ListElement)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(itemList[position], listener)
    }

    // CustomAdapter.kt
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iconImage: ImageView = itemView.findViewById(R.id.ImageView)
        private val name: TextView = itemView.findViewById(R.id.nameTextView)
        private val desc: TextView = itemView.findViewById(R.id.descTextView)
        private val status: TextView = itemView.findViewById(R.id.statusTextView)

        fun bindData(item: ListElement, listener: OnItemClickListener) {
            iconImage.setColorFilter(Color.parseColor(item.color), PorterDuff.Mode.SRC_IN)
            name.text = item.name
            desc.text = item.desc
            status.text = item.status
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

}
