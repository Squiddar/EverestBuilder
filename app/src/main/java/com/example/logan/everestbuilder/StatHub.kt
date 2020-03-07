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

        val frameName = sharedPreferences.getString(FRAME_NAME, "Null")
        val hullinput = sharedPreferences.getInt(EVEREST_HULL, 0)
        val agiinput = sharedPreferences.getInt(EVEREST_AGI, 0)
        val sysinput = sharedPreferences.getInt(EVEREST_SYS, 0)
        val engiinput = sharedPreferences.getInt(EVEREST_ENGI, 0)
        val baseHP = sharedPreferences.getInt(BASE_HP, 0)
        val baseArmor = sharedPreferences.getInt(BASE_ARMOR, 0)
        val baseRepairCap = sharedPreferences.getInt(BASE_REPAIR_CAP, 0)
        val baseEvasion = sharedPreferences.getInt(BASE_EVASION, 0)
        val baseSpeed = sharedPreferences.getInt(BASE_SPEED, 0)
        val baseEDef = sharedPreferences.getInt(BASE_EDEF, 0)
        val baseTechAttack = sharedPreferences.getInt(BASE_TECH_ATTACK, 0)
        val baseSP = sharedPreferences.getInt(BASE_SP, 0)
        val baseHeatCap = sharedPreferences.getInt(BASE_HEAT_CAP, 0)
        val baseSensorRange = sharedPreferences.getInt(BASE_SENSOR_RANGE, 0)
        val baseSaveTarget = sharedPreferences.getInt(BASE_SAVE_TARGET, 0)
        val mechTraits = sharedPreferences.getString(FRAME_TRAIT, "Null")
        val mechCore = sharedPreferences.getString(FRAME_CORE_POWER, "Null")


        //These values are then used to calculate secondary stats which are then displayed in the
        //appropriate TextViews

        val hp = (baseHP+(2*hullinput))
        val armor = baseArmor
        val repaircap = baseRepairCap+(hullinput/2)
        val evasion = (baseEvasion+agiinput)
        val speed = baseSpeed+(agiinput/2)
        val edef = baseEDef+sysinput
        val techAttack = baseTechAttack+sysinput
        val sp = baseSP+(sysinput/2)
        val heatCap = baseHeatCap+engiinput
        val limitedBonus = engiinput/2
        val sensorRange = baseSensorRange
        val saveTarget = baseSaveTarget

        frameTag.text = frameName.toString()
        hp_val.text = hp.toString()
        armorVal.text = armor.toString()
        sensorRangeVal.text = sensorRange.toString()
        saveTargetVal.text = saveTarget.toString()
        heatcap_val.text = heatCap.toString()
        repaircap_val.text = repaircap.toString()
        speed_val.text = speed.toString()
        evasion_val.text = evasion.toString()
        edef_val.text = edef.toString()
        sp_val.text = sp.toString()
        techAttack_val.text = techAttack.toString()
        limitedBonus_val.text = limitedBonus.toString()
        traitsDesc.text = mechTraits.toString()
        coreDesc.text = mechCore.toString()

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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        return true
    }

}




