package com.example.menuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.example.menuapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        supportActionBar?.title = "Main Menu"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //if(item.itemId == android.R.id.home) finish()
        when(item.itemId){
            android.R.id.home -> finish()
            R.id.Open->{
                showToast(1, "OpenFile")
            }
            R.id.Save->{
                showToast(1, "SaveFile")
            }
            R.id.Del->{
                showToast(2, "DeleteFile")
            }
            R.id.Search->{
                showToast(2, "SearchFile", 100, 100)
            }
        }
        return true
    }
    fun showToast(id:Int, text:String, x:Int=0, y:Int=30){
        var toast: Toast
        var image: ImageView

        when(id){
            1 -> {
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            }
            2->{
                toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, x, y)
                toast.show()

            }
        }
    }
}