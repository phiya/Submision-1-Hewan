package com.dicoding.picodiploma.hewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailHewanActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hewan)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Hewan"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetDetail: TextView = findViewById(R.id.tv_set_detail)

        val dataNama  = intent.getStringExtra(EXTRA_NAME)
        //val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val dataDetail = intent.getStringExtra(EXTRA_DETAIL)

        val bundle: Bundle? = intent.extras
        val dataFoto: Int = bundle?.getInt("sumberFoto") ?: 0

        tvSetName.text = dataNama
        Glide.with(this)
            //.load(tImg)
            .load(dataFoto)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetDetail.text = dataDetail
        //tvSetDetail.text = tImg
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}