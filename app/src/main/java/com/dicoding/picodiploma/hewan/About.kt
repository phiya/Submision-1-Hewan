package com.dicoding.picodiploma.hewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About Me"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgSaya: ImageView = findViewById(R.id.img_item_photo)

        val FotoSaya = R.drawable.pia

        Glide.with(this)
            .load(FotoSaya)
            .apply(RequestOptions())
            .into(imgSaya)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}