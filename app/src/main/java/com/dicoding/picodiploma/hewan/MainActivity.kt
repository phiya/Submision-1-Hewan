package com.dicoding.picodiploma.hewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHewan: RecyclerView
    private var list: ArrayList<Hewan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Nama Hewan"

        rvHewan = findViewById(R.id.rv_hewan)
        rvHewan.setHasFixedSize(true)

        list.addAll(DataHewan.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvHewan.layoutManager = LinearLayoutManager(this)
        val listHewanAdapter = ListHewanAdapter(list)
        rvHewan.adapter = listHewanAdapter

        /*
        listHewanAdapter.setOnItemClickCallback(object : ListHewanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hewan) {
                showSelectedHewan(data)
            }
        })
        */
    }

    /*
    private fun showSelectedHewan(hewan: Hewan) {
        //Toast.makeText(this, "Kamu memilih " + hewan.nama, Toast.LENGTH_SHORT).show()
        val dataHewaKirim = Intent(this@MainActivity, DetailHewanActivity::class.java)
        dataHewaKirim.putExtra(hewan.nama, "Hallo")
        dataHewaKirim.putExtra(hewan.detail, "HAHA")
        startActivity(dataHewaKirim)
    }
     */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val AboutMe = Intent(this@MainActivity,
                    About::class.java)
                startActivity(AboutMe)
            }
        }
    }
}