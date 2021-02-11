package com.example.inuka_furnitures

import Classes.Sofa
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    companion object{
        const val EXTRA_TITLE ="title"
        const val EXTRA_URL ="url"

        fun newIntent(context: Context, sofa: Sofa): Intent {
            val detailIntent = Intent(context,SofasetActivity::class.java)
            detailIntent.putExtra(EXTRA_TITLE,sofa.name)
            detailIntent.putExtra(EXTRA_TITLE,sofa.imageUrl)
            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val title = intent.extras?.getString(SofasetActivity.EXTRA_TITLE)
        val url = intent.extras?.getString(SofasetActivity.EXTRA_URL)

        setTitle(title)
        webView = findViewById(R.id.home_listview)
        url?.let { webView.loadUrl(it) }
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
            R.id.action_refresh ->{
/*
                //val webView = findViewById<WebView>(R.id.webv)
                val url: String = intent.getStringExtra("targetURL") ?: ""
                webView.webViewClient = WebViewClient()
                webView.loadUrl(url)
                btn_go_back.setOnClickListener(
                        webView.reload(url)*/
                return true
            }

            R.id.action_exit -> {
                Toast.makeText(applicationContext, "click on exit", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}