package com.example.mykotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.signind.*

class MainActivity : AppCompatActivity() {

    private var spc: Shared_preference_con? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signind)

        spc = Shared_preference_con(applicationContext)

    //    spc!!.run { wr_log_stat(false) }

        if (spc!!.rd_log_stat()) {
            startActivity(Intent(this, test::class.java))
            finish()
        }
        register.setOnClickListener {
            var intent = Intent(this,Activity::class.java)
            startActivity(intent)
            finish()
        }


        login.setOnClickListener {
            var myDatabaseAdaptor = MyDatabaseAdaptor(this)

            val usr = myDatabaseAdaptor.checkUser(
                uname!!.text.toString(),
                pass!!.text.toString()
            )
            if (usr) {
                Toast.makeText(this,"welcome ${this.uname}", Toast.LENGTH_SHORT).show()

                spc!!.run { wr_log_stat(true) }
                val intent = Intent(this, test::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this,"try again ${this.uname.text.toString()}", Toast.LENGTH_SHORT).show()

        }



    }



}
