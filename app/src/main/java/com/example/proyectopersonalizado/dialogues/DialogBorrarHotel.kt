package com.example.proyectopersonalizado.dialogues

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopersonalizado.models.Hotel

class DialogBorrarHotel(val context: Context) {

    private val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)

    fun showConfirmationDialog(pos: Int, listHotels: MutableList<Hotel>, name: String, recyclerView: RecyclerView) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("Confirmar eliminación")
        alertDialogBuilder.setMessage("¿Estás seguro de que quieres eliminar el bar "+name+"?")
        alertDialogBuilder.setPositiveButton("Sí") { dialog, _ ->
            Toast.makeText(context, "Borraremos el bar de posición $pos", Toast.LENGTH_LONG).show()
            listHotels.removeAt(pos)
            recyclerView.adapter?.notifyItemRemoved(pos)
            recyclerView.adapter?.notifyItemRangeChanged(pos, listHotels.size)
            dialog.dismiss()

        }
        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

}