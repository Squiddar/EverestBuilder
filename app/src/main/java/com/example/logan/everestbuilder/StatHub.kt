package com.example.logan.everestbuilder


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_stat_hub.*


class StatHub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat_hub)

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

        //Initialize values

        val sh_name: TextView = findViewById(R.id.shName)
        val hp_val: TextView = findViewById(R.id.hpVal)
        val heatcap_val: TextView = findViewById(R.id.heatCapVal)
        val repaircap_val: TextView = findViewById(R.id.repairCapVal)
        val speed_val: TextView = findViewById(R.id.speedVal)
        val evasion_val: TextView = findViewById(R.id.evasionVal)
        val edef_val: TextView = findViewById(R.id.eDefVal)
        val sp_val: TextView = findViewById(R.id.spVal)
        val techAttack_val: TextView = findViewById(R.id.techAttackVal)
        val limitedBonus_val: TextView = findViewById(R.id.limitedBonusVal)
        val weaponOne: TextView = findViewById(R.id.weaponOne)
        val systemOne: TextView = findViewById(R.id.systemOne)

        //Takes the name and stats from shared preferences that were chosen in previous activities
        //and places them into values

        val mechName = sharedPreferences.getString(EVEREST_NAME, "Please input mech name.")
        sh_name.text = mechName

        val hullinput = sharedPreferences.getInt(EVEREST_HULL, 0)
        val agiinput = sharedPreferences.getInt(EVEREST_AGI, 0)
        val sysinput = sharedPreferences.getInt(EVEREST_SYS, 0)
        val engiinput = sharedPreferences.getInt(EVEREST_ENGI, 0)

        //These values are then used to calculate secondary stats which are then displayed in the
        //appropriate TextViews

        val hp = (10+(2*hullinput))
        val repaircap = 5+(hullinput/2)
        val evasion = (8+agiinput)
        val speed = 4+(agiinput/2)
        val edef = 8+sysinput
        val techAttack = sysinput
        val sp = 6+(sysinput/2)
        val heatCap = 6+engiinput
        val limitedBonus = engiinput/2

        hp_val.text = hp.toString()
        heatcap_val.text = heatCap.toString()
        repaircap_val.text = repaircap.toString()
        speed_val.text = speed.toString()
        evasion_val.text = evasion.toString()
        edef_val.text = edef.toString()
        sp_val.text = sp.toString()
        techAttack_val.text = techAttack.toString()
        limitedBonus_val.text = limitedBonus.toString()

        //Since we choose the weapon and system from the Stat Hub page, we grab those values from
        //shared preferences here. The addWeapon and addSystem button take us to the activity where
        //we select our respective weapon and system

        weaponOne.text = sharedPreferences.getString(EVEREST_WEAPON, "Empty Weapon slot")
        systemOne.text = sharedPreferences.getString(EVEREST_SYSTEM, "Empty System slot")

        addWeaponButton.setOnClickListener{
            val intent = Intent(this, MechWeapons::class.java)
            startActivity(intent)
        }

        addSystemButton.setOnClickListener{
            val intent = Intent(this, MechSystems::class.java)
            startActivity(intent)
        }
    }
}




