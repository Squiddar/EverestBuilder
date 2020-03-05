package com.example.logan.everestbuilder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_mech_systems.*
import kotlinx.android.synthetic.main.activity_stat_hub.*

class MechSystems : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mech_systems)

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

        //Each of these buttons assigns places the appropriate string into the System shared
        //preference value, then goes back to the StatHub activity

        ccButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.comcponAI)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        cpjButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.paintJob)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        exCompartmentButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.exCompartment)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        manipulatorsButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.manipulators)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        smokeButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.smokeCharges)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        coverButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.depCover)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        hexButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.hexCharges)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        personalizationsButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.personalizations)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        ssButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.stableStructure)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        turretDronesButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.turretDrones)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        ccButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.comcponAI)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        shieldButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.t1shield)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        evaButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.evaModule)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        jjButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.jumpJets)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }

        flightButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val system = resources.getString(R.string.flightSystem)
            editor.putString(EVEREST_SYSTEM, system)
            editor.apply()
            startActivity(intent)
        }
    }
}
