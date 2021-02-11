package com.example.inuka_furnitures

import Classes.Sofa
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class SofasetActivity : AppCompatActivity() {
     private lateinit var webView: WebView
     companion object{
         const val EXTRA_TITLE ="title"
         const val EXTRA_URL ="url"

         fun newIntent(context:Context,sofa: Sofa):Intent{
             val detailIntent = Intent(context,SofasetActivity::class.java)
              detailIntent.putExtra(EXTRA_TITLE,sofa.name)
              detailIntent.putExtra(EXTRA_TITLE,sofa.imageUrl)
              return detailIntent
         }
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sofaset)
         val title = intent.extras?.getString(EXTRA_TITLE)
        val url = intent.extras?.getString(EXTRA_URL)

        setTitle(title)
         webView = findViewById(R.id.sofa_listview)
        url?.let { webView.loadUrl(it) }
    }
}

