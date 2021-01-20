package com.dicoding.picodiploma.hewan

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ListHewanAdapter(val listHewan: ArrayList<Hewan>) :
    RecyclerView.Adapter<ListHewanAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_hewan, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, detail, foto) = listHewan[position]
        Glide.with(holder.itemView.context)
            .load(foto)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = nama
        holder.tvDetail.text = detail

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailHewanActivity::class.java)
            moveDetail.putExtra(DetailHewanActivity.EXTRA_NAME, nama)
            moveDetail.putExtra(DetailHewanActivity.EXTRA_DETAIL, detail)
            //moveDetail.putExtra(DetailHewanActivity.EXTRA_PHOTO, foto) //gagal send image
            moveDetail.putExtra("sumberFoto", foto)//send image
            mContext.startActivity(moveDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hewan)
    }

    override fun getItemCount(): Int {
        return listHewan.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}