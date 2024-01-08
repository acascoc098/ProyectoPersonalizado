package com.example.proyectopersonalizado.dao

import com.example.proyectopersonalizado.interfaces.InterfaceDao
import com.example.proyectopersonalizado.models.Hotel
import com.example.proyectopersonalizado.objets_models.Repository

class DaoHotels private constructor(): InterfaceDao{
    companion object{
        val myDao: DaoHotels by lazy {
            DaoHotels()
        }
    }
    override
    fun getDataHotels(): List<Hotel> = Repository.listHotels
}