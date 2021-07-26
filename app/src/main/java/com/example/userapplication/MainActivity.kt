package com.example.userapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
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
    }
}

class Field(val type: Int, val name: String = "", val time: String = "")
