package com.example.teamprojectassistant2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamprojectassistant2.R
import com.example.teamprojectassistant2.Adapters.RecyclerViewAdapter
import com.example.teamprojectassistant2.Adapters.TodoItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */



class TodoFragment : Fragment() {
    // 전달된 인자들을 저장할 변수
    private var param1: String? = null
    private var param2: String? = null

    // RecyclerViewAdapter와 할 일/완료된 일 아이템 목록
    private lateinit var toDoAdapter: RecyclerViewAdapter
    private lateinit var doneAdapter: RecyclerViewAdapter
    private val toDoItems = mutableListOf<TodoItem>()
    private val doneItems = mutableListOf<TodoItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    // Fragment의 뷰를 생성하는 메소드
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo, container, false)

        // 할 일 목록 RecyclerView 설정
        toDoAdapter = RecyclerViewAdapter(toDoItems) { position, isChecked ->
            if (isChecked && position < toDoItems.size) {
                val item = toDoItems[position].copy(isChecked = true)
                doneItems.add(0, item)
                doneAdapter.notifyItemInserted(0)
                toDoItems.removeAt(position)
                toDoAdapter.notifyItemRemoved(position)
            }
        }
        val recyclerViewTasksToDo = view.findViewById<RecyclerView>(R.id.recyclerView_TasksToDo)
        recyclerViewTasksToDo.layoutManager = LinearLayoutManager(context)
        recyclerViewTasksToDo.adapter = toDoAdapter

        // 새 할 일 추가 버튼 설정
        val testButton4 = view.findViewById<Button>(R.id.testbutton4)
        testButton4.setOnClickListener {
            toDoAdapter.addItem(TodoItem("", false))
        }

        // 완료된 일 목록 RecyclerView 설정
        doneAdapter = RecyclerViewAdapter(doneItems) { position, isChecked ->
            if (!isChecked && position < doneItems.size) {
                val item = doneItems[position].copy(isChecked = false)
                toDoItems.add(0, item)
                toDoAdapter.notifyItemInserted(0)
                doneItems.removeAt(position)
                doneAdapter.notifyItemRemoved(position)
            }
        }
        val recyclerViewDone = view.findViewById<RecyclerView>(R.id.recyclerView_Done)
        recyclerViewDone.layoutManager = LinearLayoutManager(context)
        recyclerViewDone.adapter = doneAdapter

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TodoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TodoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}