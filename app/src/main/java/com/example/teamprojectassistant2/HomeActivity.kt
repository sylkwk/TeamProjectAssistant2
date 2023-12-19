/*package com.example.teamprojectassistant2

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.teamprojectassistant2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {



    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityHomeBinding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)

        navView.setupWithNavController(navController)

    }
}*/

package com.example.teamprojectassistant2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.teamprojectassistant2.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val navView: BottomNavigationView = binding.navView

        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        navView.setupWithNavController(navController)

        navView.menu.findItem(R.id.board).setIcon(R.drawable.home_pressed)

        navView.setOnItemSelectedListener { item ->
            val itemId = item.itemId
            // 모든 아이콘을 기본값으로 설정하고 선택된 아이템만 변경
            resetToDefaultIcons(navView)
            when (itemId) {
                R.id.board -> item.setIcon(R.drawable.home_pressed)
                R.id.todo -> item.setIcon(R.drawable.todo_pressed)
                R.id.ganttchart -> item.setIcon(R.drawable.ganttchart_pressed)
            }
            navController.navigate(item.itemId)
            true
        }
    }

    private fun resetToDefaultIcons(navView: BottomNavigationView) {
        navView.menu.findItem(R.id.board).setIcon(R.drawable.home)
        navView.menu.findItem(R.id.todo).setIcon(R.drawable.todo)
        navView.menu.findItem(R.id.ganttchart).setIcon(R.drawable.ganttchart)
    }
}