package com.example.teamprojectassistant2.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamprojectassistant2.R

//ViewPagerItem 데이터 클래스
data class ViewPagerItem(val title: String, val description: String)

class ViewpagerAdapter(private val items: List<ViewPagerItem>) : RecyclerView.Adapter<ViewpagerAdapter.ViewHolder>() {

    class ViewHolder(val view: ViewGroup) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item, parent, false) as ViewGroup
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 각 아이템에 대한 데이터를 사용하여 뷰 구성
        val item = items[position]
        holder.view.findViewById<TextView>(R.id.textView_Issue).text = item.title
        holder.view.findViewById<TextView>(R.id.textView_IssueInfo).text = item.description
    }

    override fun getItemCount(): Int = items.size
}

