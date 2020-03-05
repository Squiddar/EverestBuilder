package com.example.logan.everestbuilder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_mech_skills.*


class MechSkills : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mech_skills)

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

        //Sets up the spinners to display acceptable values between 0 and 6

        val hullValue: Spinner = findViewById(R.id.hullValue)
        val agiValue: Spinner = findViewById(R.id.agiValue)
        val sysValue: Spinner = findViewById(R.id.sysValue)
        val engiValue: Spinner = findViewById(R.id.engiValue)

        val mechSkillsArray = arrayOf(0, 1, 2, 3, 4, 5, 6)

        val adapter = ArrayAdapter(
                this, // Context
                android.R.layout.simple_spinner_item, // Layout
                mechSkillsArray // Array
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        hullValue.adapter = adapter;
        agiValue.adapter = adapter;
        sysValue.adapter = adapter;
        engiValue.adapter = adapter;

        //mechSkillsButton takes the values selected from each of the spinners and places them into
        //the appropriate shared preferences variable, then goes to the Stat Hub activity

        mechSkillsButton.setOnClickListener {

            val hullInput = hullValue.selectedItem.toString().toInt()
            val agiInput = agiValue.selectedItem.toString().toInt()
            val sysInput = sysValue.selectedItem.toString().toInt()
            val engiInput = engiValue.selectedItem.toString().toInt()
            editor.putInt(EVEREST_HULL, hullInput)
            editor.putInt(EVEREST_AGI, agiInput)
            editor.putInt(EVEREST_SYS, sysInput)
            editor.putInt(EVEREST_ENGI, engiInput)
            editor.apply()

            val intent = Intent(this, StatHub::class.java)
            startActivity(intent)
        }
    }
}
