package com.example.userapplication // ktlint-disable filename

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class UsersAdapter(private val users: ArrayList<Field>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var items: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    lateinit var prnt: ViewGroup
    // lateinit var headerBinding : ItemHeaderBinding
    lateinit var listener : View.OnClickListener
    var clicked = false

    companion object {
        private const val PROJECT_INFO = 1
        private const val SKILLS_FILTER = 2
        private const val USER_SKILLS_ITEM = 3
        private const val USER_INFO = 0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            USER_INFO -> {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.recycler_skills_item, parent, false)
                return myViewHolder(view, USER_INFO)
            }
            PROJECT_INFO -> {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_user_info, parent, false)
                return myViewHolder(view, PROJECT_INFO)
            }
            USER_SKILLS_ITEM -> {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.recycler_pfoject_info, parent, false)
                return myViewHolder(view, USER_SKILLS_ITEM)
            }
            else -> {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.recycler_skills_filter, parent, false)
                return myViewHolder(view, SKILLS_FILTER)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (users[position].type == 3) {
            holder.firstName?.text = users[position].name
            holder.time?.text = users[position].time
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (users[position].type) {
            0 -> {
                PROJECT_INFO
            }
            1 -> {
                USER_SKILLS_ITEM
            }
            2 -> {
                SKILLS_FILTER
            }
            else -> {
                USER_INFO
            }
        }
    }
    private fun myViewHolder(itemView: View, type: Int): ViewHolder {
        if (type == USER_INFO) {
            val vh = ViewHolder(itemView)
            vh.time = itemView.findViewById(R.id.skill_date)
            vh.firstName = itemView.findViewById(R.id.skill_name)
            return vh
        }
        if (type == PROJECT_INFO) {
            val vh = ViewHolder(itemView)
            vh.button = itemView.findViewById(R.id.github_button)
            vh.button?.setOnClickListener {
                val nextintent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Dmustache"))
                ContextCompat.startActivity(itemView.context, nextintent, null)
            }
            return vh
        }
        return ViewHolder(itemView)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var time: TextView? = null
        var firstName: TextView? = null
        var button: Button? = null
    }
}
