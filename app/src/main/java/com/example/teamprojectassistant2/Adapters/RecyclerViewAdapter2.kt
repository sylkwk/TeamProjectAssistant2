package com.example.teamprojectassistant2.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamprojectassistant2.R

class RecyclerViewAdapter2(private val items: MutableList<String>) : RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>() {

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TextView를 LayoutInflater를 사용하여 생성
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false) as TextView
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 여기에서 각 TextView의 내용을 구성
        holder.textView.text = items[position]
    }

    override fun getItemCount() = items.size

    // 새로운 아이템을 추가하는 메소드
    fun addItem(item: String) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }
}

//BoardFragment에 있는 UpcomingEvent 용 RecyclerViewAdapter 임.
