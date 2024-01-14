package com.example.proyectopersonalizado.objets_models

import com.example.proyectopersonalizado.models.Hotel

object Repository {
    var listHotels : List<Hotel> = listOf(
        Hotel(
            "El Paso", "Cazorla", "Jaén", "123456789", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcazorla.es%2Fturismo%2Fbars-and-tapas%2F&psig=AOvVaw2v0_aP_crCs4_ZOaS9PiDT&ust=1705177563076000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCKC0-frX2IMDFQAAAAAdAAAAABAD"
        ),
        Hotel(
            "La Toba", "Cazorla", "Jaén", "123456789", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.turismoencazorla.com%2Fdondecomer%2Flatoba.php&psig=AOvVaw2kS_NLvV-43Xdhxs5vdYqO&ust=1705177622219000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPCq3ZTY2IMDFQAAAAAdAAAAABAD"
        ),
        Hotel(
            "Casa Tino", "Cazorla", "Jaén", "123456789", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fguiadecazorlayubeda.com%2Fcasa-tino%2F&psig=AOvVaw2h34F5K3ppwrPSsMx0a8ks&ust=1705177667267000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCIDnnqvY2IMDFQAAAAAdAAAAABAD"
        ),
        Hotel(
            "La Cantina", "Cazorla", "Jaén", "123456789", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fguiadecazorlayubeda.com%2Fcafe-bar-la-cantina%2F&psig=AOvVaw3e_kkzUEjvrlBnBFNknw2d&ust=1705177721392000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCJCYtMPY2IMDFQAAAAAdAAAAABAD"
        ),
        Hotel(
            "La Yedra", "Cazorla", "Jaén", "123456789", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fgastroranking.es%2Fr%2Frestaurante-la-yedra_24681%2F&psig=AOvVaw3Gln0NU0_SSHntJjLy2DiC&ust=1705177747150000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPjV_s7Y2IMDFQAAAAAdAAAAABAD"
        )
    )
    fun addHotel(hotel: Hotel) {
        val updatedList = listHotels.toMutableList()
        updatedList.add(hotel)
        listHotels = updatedList.toList()
    }




}