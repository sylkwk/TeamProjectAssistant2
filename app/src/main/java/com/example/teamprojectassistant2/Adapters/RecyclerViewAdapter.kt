package com.example.teamprojectassistant2.Adapters

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamprojectassistant2.R

//TodoItem 데이터 클래스
data class TodoItem(var text: String, var isChecked: Boolean)

class RecyclerViewAdapter(
    private val items: MutableList<TodoItem>,
    private val onItemChecked: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
        val checkBox: CheckBox = cardView.findViewById(R.id.checkBox)
        val editText: EditText = cardView.findViewById(R.id.editText)
    }

    // 뷰 홀더 생성 시 호출되는 메소드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false) as CardView
        return ViewHolder(cardView)
    }

    // 뷰 홀더에 데이터 바인딩 시 호출되는 메소드
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.checkBox.setOnCheckedChangeListener(null)
        holder.checkBox.isChecked = item.isChecked
        holder.editText.setText(item.text)
        holder.editText.hint = "New Task"
        holder.editText.setHintTextColor(Color.parseColor("#FF6A6A6A"))


        // 체크박스 상태가 변경될 때 호출되는 리스너
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            val adapterPosition = holder.adapterPosition
            if(adapterPosition != RecyclerView.NO_POSITION) {
                onItemChecked(adapterPosition, isChecked)
            }
        }

        // EditText의 텍스트가 변경될 때 TodoItem 객체를 업데이트하는 TextWatcher 추가
        holder.editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val adapterPosition = holder.adapterPosition
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    items[adapterPosition].text = s.toString()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 필요 없는 메소드는 구현하지 않음
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 필요 없는 메소드는 구현하지 않음
            }
        })
    }

    // RecyclerView에 표시할 아이템의 총 개수 반환
    override fun getItemCount() = items.size

    // 새로운 TodoItem을 리스트에 추가하는 메소드
    fun addItem(item: TodoItem) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }
}




//TodoFragment에 있는 RecyclerViewAdapter 임.