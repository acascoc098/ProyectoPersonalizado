package com.example.proyectopersonalizado.objets_models

import com.example.proyectopersonalizado.models.Hotel

object Repository {
    var listHotels : List<Hotel> = listOf(
        Hotel(
            "Antiguo Palacio de Atienza" , "Atienza", "Guadalajara" ,
            "975 45 54 45" , "https://www.tuscasasrurales.com/imagenes/galeria/8619_g28/ico_8619.jpg"
        ),
        Hotel(
            "La Casa del Vaquero" , "Abiada", "Cantabria" ,
            "978 65 56 65" , "https://www.tuscasasrurales.com/imagenes/galeria/9472_g98/ico_9472.jpg"
        ),
        Hotel(
            "Hotel Ritz Carlton" , "Ciudad de México", "Ciudad de México" ,
        "+52 55 2121 1818" , "https://media.hrs.com/media/image/c7/fa/3e/Moscow_The_Ritz-Carlton-Moskau-Aussenansicht-223214_600x600.jpg"
        ),
        Hotel(
            "Hotel W Barcelona" , "Barcelona", "España" ,
            "+34 932 95 28 00" , "https://cf.bstatic.com/xdata/images/hotel/max1024x768/439254613.jpg?k=ea6c76df54497fb1882fe03f96cbc4e774b4898ada95323cafb6042a292e935b&o=&hp=1"
        ),
        Hotel(
            "Hotel Burj Al Arab" , "Dubái", "Emiratos Árabes Unidos" ,
            "+971 4 301 7777" , "https://cf.bstatic.com/xdata/images/hotel/max1024x768/457389536.jpg?k=1b5b93930a67d2372178da9df3c090ec47fb1f5622f5664dde18c4362f31b355&o=&hp=1"
        ),
        Hotel(
            "Hotel Eden Roc" , "Miami Beach", "Florida" ,
            "+1 305-531-0000" , "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/25/14/03/14/eden-roc-by-brava-hoteles.jpg?w=700&h=-1&s=1"
        ),
        Hotel(
            "Hotel The Oberoi Udaivilas" , "Udaipur", " India" ,
            "+91 294 243 3300" , "https://cf.bstatic.com/xdata/images/hotel/max1024x768/48812893.jpg?k=a034ea2f5c5431b95bedb68ac0aaa9507f6d2ba261a3182554b1dc81b4ab0f52&o=&hp=1"
        ),
        Hotel(
            "Hotel Four Seasons George V" , "París", "Francia" ,
            "+33 1 49 52 70 00" , "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/07/b0/ce/four-seasons-hotel-george.jpg?w=700&h=-1&s=1"
        ),
        Hotel(
            "Hotel The Ritz London" , "Londres", "Reino Unido" ,
            "+44 20 7493 8181" , "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/0f/0d/04/the-ritz-london-exterior.jpg?w=700&h=-1&s=1"
        ),
        Hotel(
            "Hotel Bali Mandira " , "Bali", "Indonesia" ,
            "+62 361 751381" , "https://cf.bstatic.com/xdata/images/hotel/max1024x768/499893968.jpg?k=fb69544b39e3cd55136ae50322fbe9974ab46d24cc3eef65ba4ebfcf6750d243&o=&hp=1"
        )
    )
    fun addHotel(hotel: Hotel) {
        val updatedList = listHotels.toMutableList()
        updatedList.add(hotel)
        listHotels = updatedList.toList()
    }




}