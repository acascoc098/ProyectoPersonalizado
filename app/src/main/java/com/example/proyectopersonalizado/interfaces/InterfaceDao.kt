package com.example.proyectopersonalizado.interfaces

import com.example.proyectopersonalizado.models.Hotel

interface InterfaceDao {
    fun getDataHotels(): List<Hotel>
}