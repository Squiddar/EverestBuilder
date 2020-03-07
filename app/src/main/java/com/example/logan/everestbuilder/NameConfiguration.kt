package com.example.logan.everestbuilder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomnavigation.BottomNavigationView

class NameConfiguration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_configuration)

        //Add an action bar with a button that will return us to mech selection

        val actionbar = supportActionBar
        actionbar!!.title = "Home"
        actionbar.setDisplayHomeAsUpEnabled(true)


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


        //Sets up the configButton to store the entered configName into shared preferences, then go to
        //the Mech Skills activity

        val configButton: Button = findViewById(R.id.configButton)
        val configName: EditText = findViewById(R.id.configName)

        configButton.setOnClickListener{

            val mechName = configName.text.toString()
            editor.putString(EVEREST_NAME, mechName)
            editor.apply()
            val intent = Intent(this, MechSkills::class.java)
            startActivity(intent)
        }


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
    }


    //This function tells the home button to take the user to mech selection when pressed

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        return true
    }
}
