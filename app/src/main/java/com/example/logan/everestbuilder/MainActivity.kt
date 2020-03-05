package com.example.logan.everestbuilder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

const val SHARED_PREFS_FILE = "com.example.logan.everestbuilder.SHARED_PREFS"
const val EVEREST_NAME = "com.example.logan.everestbuilder.EVEREST_NAME"
const val EVEREST_HULL = "com.example.logan.everestbuilder.EVEREST_HULL"
const val EVEREST_AGI = "com.example.logan.everestbuilder.EVEREST_AGI"
const val EVEREST_SYS = "com.example.logan.everestbuilder.EVEREST_SYS"
const val EVEREST_ENGI = "com.example.logan.everestbuilder.EVEREST_ENGI"
const val EVEREST_WEAPON = "com.example.logan.everestbuilder.EVEREST_WEAPON"
const val EVEREST_SYSTEM = "com.example.logan.everestbuilder.EVEREST_SYSTEM"
const val SAVED_MECHS = "com.example.logan.everestbuilder.LOADABLE_MECHS"

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Establish shared preferences and grab them in case the user switches activities using
        //the bottom navigation bar

        val sharedPreferences =
                getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val name = sharedPreferences.getString(EVEREST_NAME, "No name selected")
        val hull = sharedPreferences.getInt(EVEREST_HULL, 0)
        val agility = sharedPreferences.getInt(EVEREST_AGI, 0)
        val systems = sharedPreferences.getInt(EVEREST_SYS, 0)
        val engineering = sharedPreferences.getInt(EVEREST_ENGI, 0)
        editor.putString(EVEREST_NAME, name)
        editor.putInt(EVEREST_HULL, hull)
        editor.putInt(EVEREST_AGI, agility)
        editor.putInt(EVEREST_SYS, systems)
        editor.putInt(EVEREST_ENGI, engineering)
        editor.apply()

        //Set up bottom navigation bar to switch activities on press

        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){

                R.id.name_configuration -> {
                    val intent = Intent(this, NameConfiguration::class.java)
                    startActivity(intent)
                }

                R.id.mech_skills -> {
                    val intent = Intent(this, MechSkills::class.java)
                    startActivity(intent)
                }

                R.id.stat_hub -> {
                    val intent = Intent(this, StatHub::class.java)
                    startActivity(intent)
                }

                R.id.mech_weapons -> {
                    val intent = Intent(this, MechWeapons::class.java)
                    startActivity(intent)
                }

                R.id.mech_systems -> {
                    val intent = Intent(this, MechSystems::class.java)
                    startActivity(intent)
                }
            }

            true
        }

        //This button goes to the NameConfiguration activity

        createnewbutton.setOnClickListener{
            val intent = Intent(this, NameConfiguration::class.java)
            startActivity(intent)
        }
    }
}
