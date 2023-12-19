package com.example.teamprojectassistant2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.teamprojectassistant2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var vpAdapter: FragmentStateAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vpAdapter = CustomPagerAdapter(this)
        binding.viewpager2.adapter = vpAdapter

        binding.indicator.setViewPager(binding.viewpager2)
    }


    class CustomPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
        private val PAGENUMBER = 4

        override fun getItemCount(): Int {
            return PAGENUMBER
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ProjectFragment.newInstance(R.raw.img00, "test 00")
                1 -> ProjectFragment.newInstance(R.raw.img01, "test 01")
                2 -> ProjectFragment.newInstance(R.raw.img02, "test 02")
                3 -> ProjectFragment.newInstance(R.raw.img03, "test 03")
                else -> ProjectFragment.newInstance(R.raw.img00, "page00")
            }
        }
    }
}