package com.example.proyectopersonalizado

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopersonalizado.controler.Controller
import com.example.proyectopersonalizado.databinding.ActivityMainBinding
import com.example.proyectopersonalizado.databinding.FragmentListBinding


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController //nuestro navController, para la navegación
        val toolbar: Toolbar = findViewById(R.id.toolbar) //nuestro objeto toolbar. B. de herra.
        setSupportActionBar(toolbar) //Lo posicionamos en la barra superior

    }
    //método que es llamado después de crear la vista del activity.
    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflar el menú; esto agrega elementos a la barra de acción si está presente.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
    /*
Para controlar los eventos de los items del toolbar
*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_list -> {
                navController.navigate(R.id.fragmentList)
                true
            }
            R.id.toolbar_hotels -> {
                val action = FragmentListDirections.actionFragmentListToFragmentHotels(nombre = "José Andrés Garrido Gutiérrez", curso = "2º de Desarrollo de aplicaiones multiplataforma")
                navController.navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}



