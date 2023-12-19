package com.example.teamprojectassistant2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.teamprojectassistant2.R
import com.example.teamprojectassistant2.Adapters.RecyclerViewAdapter2
import com.example.teamprojectassistant2.Adapters.ViewPagerItem
import com.example.teamprojectassistant2.Adapters.ViewpagerAdapter



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class BoardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var isImagesVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_board, container, false)

        // 다가올 이벤트를 위한 RecyclerView 설정
        // 초기 아이템 리스트 생성 - 여기서 아이템 수를 미리 설정
        val initialItems = mutableListOf(
            "11/15   테스트 빌드",
            "11/22   1차 빌드 완성",
            "12/19   최종 제출"
        )  // 초기 아이템을 미리 추가

        val adapter = RecyclerViewAdapter2(initialItems)
        val recyclerViewDone = view.findViewById<RecyclerView>(R.id.recyclerView_UpcomingEvents)
        recyclerViewDone.layoutManager = LinearLayoutManager(context)
        recyclerViewDone.adapter = adapter

        // ViewPager2 설정
        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager_issue)

        // 각 아이템에 대한 데이터 생성
        val viewPagerItems = listOf(
            ViewPagerItem("ToDo의 RecyclerView와 어댑터의 동기화 오류 해결", "23/12/9 16:00     시열"),
            ViewPagerItem("메모리 누수, 자원 관리와 레퍼런스 해제를 확인 요망", "23/12/12 20:00     윤서"),
            ViewPagerItem("스크린 크기에 대한 UI 호환성 문제 확인 요망", "23/12/15 22:00     찬희"),
            ViewPagerItem("OpenAI API 사용해서 Chatbot 구현 제안 ", "23/12/17 9:00     시열"),
            ViewPagerItem("Add Issue", "")
        )

        // Adapter에 데이터 전달
        viewPager.adapter = ViewpagerAdapter(viewPagerItems)

        // testbutton1 버튼에 대한 클릭 리스너 설정
        val testButton1 = view.findViewById<Button>(R.id.testbutton1)
        testButton1.setOnClickListener {
            // '새로운 아이템'을 RecyclerView에 추가
            adapter.addItem("12/${initialItems.size + 17}   최종 발표")
        }

        // testbutton2 버튼에 대한 클릭 리스너 설정
        val testButton2 = view.findViewById<Button>(R.id.testbutton2)
        val imageViewGreen2 = view.findViewById<ImageView>(R.id.imageView_Green2)
        val imageViewGreen3 = view.findViewById<ImageView>(R.id.imageView_Green3)

        testButton2.setOnClickListener {
            if (isImagesVisible) {
                // 이미지를 숨김
                imageViewGreen2.visibility = View.GONE
                imageViewGreen3.visibility = View.GONE
            } else {
                // 이미지를 보임
                imageViewGreen2.visibility = View.VISIBLE
                imageViewGreen3.visibility = View.VISIBLE
            }
            isImagesVisible = !isImagesVisible
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BoardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

/*package com.example.teamprojectassistant2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamprojectassistant2.R
import com.example.teamprojectassistant2.Adapters.RecyclerViewAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BoardFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_board, container, false)

        // RecyclerView 설정
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerViewAdapter(5) // 5개의 CardView를 표시

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}*/

