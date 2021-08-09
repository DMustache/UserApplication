package com.example.userapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.UsersAdapter

class MainActivity : AppCompatActivity() {

    private var showSkillDateFilter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users: ArrayList<Field> = ArrayList()
        users.add(Field(0))
        users.add(Field(1))
        users.add(Field(2))
        users.add(Field(3, "Python, Cpp, SQL", "1"))
        users.add(Field(3, "С#, ", "2"))
        users.add(Field(3, "Blender, Unity, Data Science", "< 1"))
        val res: RecyclerView = findViewById(R.id.recycler_view)
        res.layoutManager = LinearLayoutManager(this)
        res.adapter = UsersAdapter(users)
        // FilterClickListener() = UsersAdapter.listener

    }

    inner class FilterClickListener : View.OnClickListener
    {
        override fun onClick(view: View?) {
            val intent = Intent(this@MainActivity, FilterActivity::class.java)
            startActivity(intent)
        }
    }
}

class Field(val type: Int, val name: String = "", val time: String = "")
