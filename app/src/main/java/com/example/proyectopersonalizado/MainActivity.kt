package com.example.proyectopersonalizado

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.proyectopersonalizado.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    //lateinit var appBarConfiguration: AppBarConfiguration
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = findViewById(R.id.fragmentContainerView)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController //nuestro navController, para la navegación
        val toolbar: Toolbar = findViewById(R.id.toolbar) //nuestro objeto toolbar. B. de herra.
        setSupportActionBar(toolbar) //Lo posicionamos en la barra superior

        //Parte del Drawer
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment //Nuestro NavHostFragment
        //val navController = navHostFragment.navController //Nuestro navController

        //setSupportActionBar(binding.toolbar)

        //Necesitamos nuestro componente principal del Drawer.
        val navView = binding.navigationView

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.anim.slide_in,R.anim.slide_on)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { menuItem ->
            val currentFragmentId = navController.currentDestination?.id

            when (menuItem.itemId) {
                R.id.fragmentList -> {
                    navController.navigate(R.id.fragmentList)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.fragmentHotels -> {
                    if (currentFragmentId == R.id.fragmentList) {
                        val action = FragmentListDirections.actionFragmentListToFragmentHotels(
                            nombre = "Andrea Castilla Cocera",
                            curso = "Programación multimedia"
                        )
                        navController.navigate(action)
                    } else if (currentFragmentId == R.id.infoFragment) {
                        val action = FragmentInformacionDirections.actionFragmentInformacionToFragmentHotels(
                            nombre = "Andrea Castilla Cocera",
                            curso = "Programación multimedia"
                        )
                        navController.navigate(action)
                    }else if  (currentFragmentId == R.id.homeFragment) {

                        val action = FragmentHomeDirections.actionHomeFragmentToFragmentHotels(
                            nombre = "Andrea Castilla Cocera",
                            curso = "Programación multimedia"
                        )
                        navController.navigate(action)
                    }
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_logout -> {
                    val intent = Intent(this@MainActivity, Login::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }

        /*appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.fragmentList, R.id.hospedajeFragment, R.id.aboutFragment), binding.myDrawer
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)

        binding.appBottomBar.myBottonNavigation.setupWithNavController( navController )

        initFab()*/

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_list -> {
                navController.navigate(R.id.fragmentList)
                true
            }
            R.id.toolbar_hotels -> {
                val action = FragmentListDirections.actionFragmentListToFragmentHotels(nombre = "Andrea Castilla Cocera", curso = "2º de Desarrollo de aplicaiones multiplataforma")
                navController.navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    /*override fun onSupportNavigateUp(): Boolean{
        return navController. navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }*/

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    /*private fun initFab(){
        binding.appBarMain.appBottomBar.fab.setOnClickListener {
            Toast.makeText(this, "Pulso + ", Toast.LENGTH_LONG).show()
        }
    }*/

}



