package com.mandarjoshi.androidnextgen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        ) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.action_list, R.id.shoppingFragment)
        )

        findViewById<MaterialToolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)

        setNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    private fun setNavigation(){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            /*
            if(destination.id == R.id.full_screen_destination) {
                toolbar.visibility = View.GONE
                bottomNavigationView.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
                bottomNavigationView.visibility = View.VISIBLE
            }*/
        }
    }
}
