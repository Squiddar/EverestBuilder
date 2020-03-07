package com.example.logan.everestbuilder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_mech_weapons.*
import kotlinx.android.synthetic.main.activity_stat_hub.*

class MechWeapons : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mech_weapons)

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


        //Each of these buttons assigns places the appropriate string into the Weapon shared
        //preference value, then goes back to the StatHub activity

        val amrButton: Button = findViewById(R.id.amrButton)
        amrButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.antiMaterialRifle)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        asrButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.assaultRifle)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        cbButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.chargedBlade)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        cprButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.cyclonePulseRifle)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        hcbButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.heavyChargedBlade)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        hmgButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.heavyMachineGun)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        hmwButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.heavyMeleeWeapon)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        howitzerButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.howitzer)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        mrButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.missileRack)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        hknButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.hunterKillerNexus)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        lnButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.lightNexus)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        pistolButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.pistol)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        pkButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.progressiveKnife)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        rpgButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.rpg)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        shotgunButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.shotgun)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        tkButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.tacticalKnife)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        tmwButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.tacticalMeleeWeapon)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        tlButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.thermalLance)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        tpButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.thermalPistol)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
            startActivity(intent)
        }

        trButton.setOnClickListener {
            val intent = Intent(this, StatHub::class.java)
            val weapon = resources.getString(R.string.thermalRifle)
            editor.putString(EVEREST_WEAPON, weapon)
            editor.apply()
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

