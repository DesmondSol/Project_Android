package com.example.mykotlin

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlin.R.id
import com.example.mykotlin.R.layout
import java.util.*

class test : AppCompatActivity() {
    internal var spc: Shared_preference_con? = null
    internal var myDatabaseAdaptor: MyDatabaseAdaptor? = null
    internal var mvh: MyDatabaseHelper? = null
    internal var rv: RecyclerView? = null
    internal var usrlst: ArrayList<Users>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.success)
        spc = Shared_preference_con(this)
        rv = findViewById<RecyclerView?>(id.rv)
        rv!!.setHasFixedSize(false)
        rv!!.layoutManager = LinearLayoutManager(this)
        spc = Shared_preference_con(applicationContext)
        mvh = MyDatabaseHelper(this)
        rv = findViewById<RecyclerView?>(id.rv)
        usrlst = ArrayList()
        fetch()
        val f =
            fetchData(usrlst!!, applicationContext)
        val linearLayoutManager =
            LinearLayoutManager(applicationContext)
        rv!!.adapter = f
        //creating recyclerview adapter


        //setting adapter to recyclerview


    }

    fun fetch() {
        val data: Cursor =
            MyDatabaseHelper(this).fetchAllData()
        while (data.moveToNext()) {
            usrlst!!.add(
                Users(
                    data.getString(0),
                    data.getString(1),
                    data.getString(2),
                    data.getString(3),
                    data.getString(4),
                    data.getString(5),
                    data.getString(6)
                )
            )
        }
    }

    fun usrLogOut(view: View?) {
        logout()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun logout() {
        spc!!.wr_log_stat(false)
    }
}