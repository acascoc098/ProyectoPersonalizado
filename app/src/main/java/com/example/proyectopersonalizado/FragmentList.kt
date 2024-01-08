package com.example.proyectopersonalizado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopersonalizado.controler.Controller
import com.example.proyectopersonalizado.databinding.FragmentListBinding

class FragmentList : Fragment() {
    lateinit var controlador: Controller
    lateinit var enlace: FragmentListBinding
    lateinit var botonFlotante: ImageButton
    private lateinit var myRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enlace = FragmentListBinding.inflate(inflater, container, false)
        val rootView = enlace.root
        botonFlotante = rootView.findViewById(R.id.btn_add)
        myRecyclerView = enlace.myRecyclerView // Asigna el RecyclerView

        init()
        return rootView
    }

    fun init() {
        initRecyclerView()
        controlador = Controller(requireContext())
        controlador.setAdapter(myRecyclerView) // Pasa la referencia del RecyclerView
        controlador.setAddButton(botonFlotante, myRecyclerView)
    }

    private fun initRecyclerView() {
        myRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

}
