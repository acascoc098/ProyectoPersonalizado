package com.example.proyectopersonalizado

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopersonalizado.controler.Controller
import com.example.proyectopersonalizado.databinding.ActivityMainBinding
import com.example.proyectopersonalizado.databinding.FragmentListBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    lateinit var appBarConfiguration: AppBarConfiguration
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController //nuestro navController, para la navegación
        val toolbar: Toolbar = findViewById(R.id.toolbar) //nuestro objeto toolbar. B. de herra.
        setSupportActionBar(toolbar) //Lo posicionamos en la barra superior

        //Parte del Drawer
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id. container_fragment) as
                    NavHostFragment //Nuestro NavHostFragment
        val navController = navHostFragment. navController //Nuestro navController

        setSupportActionBar(binding.appBarMain.myToolbar)

        //Necesitamos nuestro componente principal del Drawer.
        val navView = binding.myNavView

        /*
        Con appBarConfiguration, nos aseguramos la CONFIGURACIÓN mediante un drawer y sus destinos.
        1.- Administra el botón de navegación. Consideramos primer nivel todos excepto el listado de
        hoteles. Por tanto, configura destinos.
        2.- Como tenemos un DrawerLayout, lo configuramos para que el icono cambie con el icono de la
        hamburguesa cuando esté en el home y con la
        flecha <- cuando esté en un nivel inferior.
        3.- Hacemos que se sincronice o funcione con el navigation drawer.
        */
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.settingsFragment, R.id.shareFragment, R.id.aboutFragment), binding.myDrawer
        )

        /*
        1.- Aplica la configuración del appBarConfiguration, vinculándolo con la navegación a
        partir del navController.
        2.- !!!!!Sin esto, no veríamos el botón de navegación !!!!!!
        */
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)

        /*
Hacemos que el componente de navegación, funcione correctamente con cada uno de los
elementos del Bottom
1.- Sin esto, no podrá navegar a ningún destino.
*/
        binding.appBarMain.appBottomBar.myBottonNavigation.setupWithNavController( navController )

    }
    //método que es llamado después de crear la vista del activity.
    /*@SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflar el menú; esto agrega elementos a la barra de acción si está presente.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }*/
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

    /*
    Con este método, hacemos que funcione correctamente el botón de navegación hacia arriba.
    1.- Esto hace que que responda a los eventos de navegación. Controlará la apertura de abrir
    la barra lateral del drawer y su cierre.
    2.- Sin esto, no se abre/cierra el Drawer.
    */
    override fun onSupportNavigateUp(): Boolean{
        val navController = findNavController(R.id.container_fragment)
        return navController. navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    private fun initFab(){
        binding.appBarMain.appBottomBar.fab.setOnClickListener {
            Toast.makeText(this, "Pulso + ", Toast.LENGTH_LONG).show()
        }
    }

}



