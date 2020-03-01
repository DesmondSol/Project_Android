package com.example.mykotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mykotlin.R.id
import com.example.mykotlin.R.layout
import java.util.*

class fetchData(
    private val userList: ArrayList<Users>,
    internal var context: Context
) : Adapter<fetchData.ViewHolder>() {
    internal var helper: MyDatabaseHelper
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View? = LayoutInflater.from(context)
            .inflate(layout.layout, parent, false)
        return ViewHolder(view!!)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.username.text = userList[position].username
        holder.itemView.setOnClickListener {
            val intent =
                Intent(context, UserDetailc::class.java)
            // intent.putExtra("user",userList.get(position));


            context.startActivity(intent)
        }
        holder.setItemOnLongClickLisene(ItemOnLongClickLisener { view, id ->
            val model = userList[id]
            userList.removeAt(id)
            notifyItemRemoved(id)
        })
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        OnLongClickListener {
        internal var itemOnLongClickLisene: ItemOnLongClickLisener? = null
        var username: TextView
        fun setItemOnLongClickLisene(itemOnLongClickLisener: ItemOnLongClickLisener) {
            itemOnLongClickLisene = itemOnLongClickLisener
        }

        override fun onLongClick(v: View): Boolean {
            itemOnLongClickLisene!!.onLongClickListener(v, layoutPosition)
            return true
        }

        init {
            var itemOnLongClickLisener: ItemOnLongClickLisener
            username =
                itemView.findViewById(id.username)
            itemView.setOnLongClickListener(this)
        }
    }

    init {
        helper = MyDatabaseHelper(context)
    }
}