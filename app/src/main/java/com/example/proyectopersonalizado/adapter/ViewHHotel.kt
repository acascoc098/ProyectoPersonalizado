package com.example.proyectopersonalizado.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectopersonalizado.databinding.ItemHotelBinding
import com.example.proyectopersonalizado.models.Hotel


class ViewHHotel (view: View,
                  var deleteOnClick: (Int) -> Unit,
                  var updateOnClick: (Int) -> Unit
): RecyclerView.ViewHolder (view){
    var binding: ItemHotelBinding
    init {
        binding = ItemHotelBinding.bind(view)
    }
    fun renderize(hotel : Hotel, position: Int){
        binding.txtviewName.setText(hotel. name)
        binding.txtviewCity.setText(hotel. city)
        binding.txtviewProvince.setText(hotel. province)
        binding.txtviewPhone.setText(hotel. phone)
        Glide
            .with( itemView.context)
            .load(hotel. image)
            .centerCrop()
            .into( binding.ivHotel)
        setOnClickListener(position)
    }
    private fun setOnClickListener(position : Int) {
        binding.btnEdit.setOnClickListener {
            updateOnClick(position )
        }
        binding.btnDelete.setOnClickListener {
            deleteOnClick(position)
        }
    }
}