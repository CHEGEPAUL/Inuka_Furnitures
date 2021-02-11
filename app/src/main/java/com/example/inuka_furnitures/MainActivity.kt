package com.example.inuka_furnitures

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnsofaset = findViewById<Button>(R.id.btnsofasets)
        var btnhomefurniture = findViewById<Button>(R.id.btnhomefurniture)
        var btnofficefurniture = findViewById<Button>(R.id.btnofficefurniture)


        btnsofaset.setOnClickListener{
            startActivity(Intent(this,SofasetActivity::class.java))

        }
        btnhomefurniture.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))

        }
        btnofficefurniture.setOnClickListener{
            startActivity(Intent(this,OfficeActivity::class.java))

        }

    }
    // The double press back operation
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun isOnline(context: Context):Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }
            }
        }
        return false


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                true
            }

            R.id.action_exit ->{
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
