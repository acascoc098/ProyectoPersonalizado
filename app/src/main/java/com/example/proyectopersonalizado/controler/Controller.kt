package com.example.proyectopersonalizado.controler

import android.content.Context
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopersonalizado.MainActivity
import com.example.proyectopersonalizado.adapter.AdapterHotel
import com.example.proyectopersonalizado.dao.DaoHotels
import com.example.proyectopersonalizado.dialogues.DialogAñadirHotel
import com.example.proyectopersonalizado.dialogues.DialogBorrarHotel
import com.example.proyectopersonalizado.dialogues.DialogEditarHotel
import com.example.proyectopersonalizado.models.Hotel

class Controller (val context : Context){
    lateinit var listHotels : MutableList<Hotel> //lista de objetos
    private lateinit var addButton: ImageButton
    private lateinit var recyclerView: RecyclerView

    init {
        initData()
    }
    fun initData(){
        // listHotels = DaoHotels2.myDao.toMutableList()
        listHotels = DaoHotels.myDao.getDataHotels().toMutableList() //llamamos al singleton.
    }
    fun loggOut() {
        Toast.makeText(context,"He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listHotels.forEach{
            println(it)
        }
    }
    fun setAdapter(recyclerView: RecyclerView) {
        recyclerView.adapter = AdapterHotel(
            listHotels,
            { pos -> delHotel(pos, recyclerView) },
            { pos -> updateHotel(pos, recyclerView) }
        )
    }
    fun delHotel(pos: Int, recyclerView: RecyclerView) {
        val alertDialogHelper = DialogBorrarHotel(context)
        alertDialogHelper.showConfirmationDialog(pos, listHotels, listHotels[pos].name, recyclerView)
    }
    fun setRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
    }
    fun updateHotel(pos: Int, recyclerView: RecyclerView){
        val dialog = DialogEditarHotel(context)
        val alertDialog = dialog.showConfirmationDialog(pos, listHotels, recyclerView, ::updateHotelConfirm)
        alertDialog?.show()
    }
    fun updateHotelConfirm(pos: Int, recyclerView: RecyclerView){
        val myActivity = context as MainActivity
        recyclerView.adapter?.notifyItemChanged(pos)
    }
    fun setAddButton(addButton: ImageButton, recyclerView: RecyclerView) {
        this.addButton = addButton
        this.addButton.setOnClickListener {
            addHotel(recyclerView)
        }
    }
    private fun addHotel(recyclerView: RecyclerView) {
        val dialog = DialogAñadirHotel(context)
        val alertdialog = dialog.onCreateDialog(listHotels, recyclerView, ::addHotelConfirm)
        alertdialog.show()
    }
    private fun addHotelConfirm(pos: Int, myRecyclerView: RecyclerView){
        myRecyclerView.adapter?.notifyItemInserted(pos)
        myRecyclerView.smoothScrollToPosition(pos)
    }
}