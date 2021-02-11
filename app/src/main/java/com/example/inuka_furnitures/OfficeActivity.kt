package com.example.inuka_furnitures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

class OfficeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_office)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_refresh ->{

                Toast.makeText(applicationContext, "click on share", Toast.LENGTH_LONG).show()

                return true
            }

            R.id.action_exit ->{
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
