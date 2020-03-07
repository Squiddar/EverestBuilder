package com.example.logan.everestbuilder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

const val SHARED_PREFS_FILE = "com.example.logan.everestbuilder.SHARED_PREFS"
const val EVEREST_NAME = "com.example.logan.everestbuilder.EVEREST_NAME"
const val FRAME_NAME = "com.example.logan.everestbuilder.FRAME_NAME"
const val FRAME_TRAIT = "com.example.logan.everestbuilder.FRAME_TRAIT"
const val FRAME_CORE_POWER = "com.example.logan.everestbuilder.FRAME_CORE_POWER"
const val EVEREST_HULL = "com.example.logan.everestbuilder.EVEREST_HULL"
const val EVEREST_AGI = "com.example.logan.everestbuilder.EVEREST_AGI"
const val EVEREST_SYS = "com.example.logan.everestbuilder.EVEREST_SYS"
const val EVEREST_ENGI = "com.example.logan.everestbuilder.EVEREST_ENGI"
const val EVEREST_WEAPON = "com.example.logan.everestbuilder.EVEREST_WEAPON"
const val EVEREST_SYSTEM = "com.example.logan.everestbuilder.EVEREST_SYSTEM"
const val BASE_HP = "com.example.logan.everestbuilder.BASE_HP"
const val BASE_ARMOR = "com.example.logan.everestbuilder.BASE_ARMOR"
const val BASE_HEAT_CAP = "com.example.logan.everestbuilder.BASE_HEAT_CAP"
const val BASE_REPAIR_CAP = "com.example.logan.everestbuilder.BASE_REPAIR_CAP"
const val BASE_SPEED = "com.example.logan.everestbuilder.BASE_SPEED"
const val BASE_EVASION = "com.example.logan.everestbuilder.BASE_EVASION"
const val BASE_EDEF = "com.example.logan.everestbuilder.BASE_EDEF"
const val BASE_SENSOR_RANGE = "com.example.logan.everestbuilder.BASE_SENSOR_RANGE"
const val BASE_SAVE_TARGET = "com.example.logan.everestbuilder.BASE_SAVE_TARGET"
const val BASE_SP = "com.example.logan.everestbuilder.BASE_SP"
const val BASE_TECH_ATTACK = "com.example.logan.everestbuilder.BASE_TECH_ATTACK"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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


        //This button selects the Blackbeard as the frame and passes its base stats into shared preferences

        addBlackbeardButton.setOnClickListener {
            var blackbeard = Mech("Blackbeard", resources.getString(R.string.blackbeard_description),
                    12, 1, 4, 5, 5, 8, 6,
                    5, 10, 5, -2)
            var trait = resources.getString(R.string.blackbeard_traits)
            var core = resources.getString(R.string.blackbeard_core_power)
            editor.putInt(BASE_HP, blackbeard.hp)
            editor.putInt(BASE_ARMOR, blackbeard.armor)
            editor.putInt(BASE_HEAT_CAP, blackbeard.heatCap)
            editor.putInt(BASE_REPAIR_CAP, blackbeard.repairCap)
            editor.putInt(BASE_SPEED, blackbeard.speed)
            editor.putInt(BASE_EVASION, blackbeard.evasion)
            editor.putInt(BASE_EDEF, blackbeard.eDefense)
            editor.putInt(BASE_SENSOR_RANGE, blackbeard.sensorRange)
            editor.putInt(BASE_SAVE_TARGET, blackbeard.saveTarget)
            editor.putInt(BASE_SP, blackbeard.sp)
            editor.putInt(BASE_TECH_ATTACK, blackbeard.techAttack)
            editor.putString(FRAME_NAME, blackbeard.name)
            editor.putString(FRAME_TRAIT, trait)
            editor.putString(FRAME_CORE_POWER, core)
            editor.apply()

            val intent = Intent(this, NameConfiguration::class.java)
            startActivity(intent)
        }


        //This button selects the Everest as the frame and passes its base stats into shared preferences

        addEverestButton.setOnClickListener {
            var everest = Mech("Everest", "@string/everest_description",
                    10, 0, 6, 5, 4, 8, 8,
                    10, 10, 6, +0)
            var trait = resources.getString(R.string.everest_traits)
            var core = resources.getString(R.string.everest_core_power)
            editor.putInt(BASE_HP, everest.hp)
            editor.putInt(BASE_ARMOR, everest.armor)
            editor.putInt(BASE_HEAT_CAP, everest.heatCap)
            editor.putInt(BASE_REPAIR_CAP, everest.repairCap)
            editor.putInt(BASE_SPEED, everest.speed)
            editor.putInt(BASE_EVASION, everest.evasion)
            editor.putInt(BASE_EDEF, everest.eDefense)
            editor.putInt(BASE_SENSOR_RANGE, everest.sensorRange)
            editor.putInt(BASE_SAVE_TARGET, everest.saveTarget)
            editor.putInt(BASE_SP, everest.sp)
            editor.putInt(BASE_TECH_ATTACK, everest.techAttack)
            editor.putString(FRAME_NAME, everest.name)
            editor.putString(FRAME_TRAIT, trait)
            editor.putString(FRAME_CORE_POWER, core)
            editor.apply()

            val intent = Intent(this, NameConfiguration::class.java)
            startActivity(intent)
        }


        //This button selects the Sherman as the frame and passes its base stats into shared preferences

        addShermanButton.setOnClickListener {
            var sherman = Mech("Sherman", "@string/sherman_description",
                    10, 1, 8, 4, 3, 7, 8,
                    10, 10, 5, -1)
            var trait = resources.getString(R.string.sherman_traits)
            var core = resources.getString(R.string.sherman_core_power)
            editor.putInt(BASE_HP, sherman.hp)
            editor.putInt(BASE_ARMOR, sherman.armor)
            editor.putInt(BASE_HEAT_CAP, sherman.heatCap)
            editor.putInt(BASE_REPAIR_CAP, sherman.repairCap)
            editor.putInt(BASE_SPEED, sherman.speed)
            editor.putInt(BASE_EVASION, sherman.evasion)
            editor.putInt(BASE_EDEF, sherman.eDefense)
            editor.putInt(BASE_SENSOR_RANGE, sherman.sensorRange)
            editor.putInt(BASE_SAVE_TARGET, sherman.saveTarget)
            editor.putInt(BASE_SP, sherman.sp)
            editor.putInt(BASE_TECH_ATTACK, sherman.techAttack)
            editor.putString(FRAME_NAME, sherman.name)
            editor.putString(FRAME_TRAIT, trait)
            editor.putString(FRAME_CORE_POWER, core)
            editor.apply()

            val intent = Intent(this, NameConfiguration::class.java)
            startActivity(intent)
        }


        //This button selects the Metalmark as the frame and passes its base stats into shared preferences

        addMetalmarkButton.setOnClickListener {
            var metalmark = Mech("Metalmark", "@string/metalmark_description",
                    8, 1, 5, 4, 5, 10, 6,
                    10, 10, 5, +0)
            var trait = resources.getString(R.string.metalmark_traits)
            var core = resources.getString(R.string.metalmark_core_power)
            editor.putInt(BASE_HP, metalmark.hp)
            editor.putInt(BASE_ARMOR, metalmark.armor)
            editor.putInt(BASE_HEAT_CAP, metalmark.heatCap)
            editor.putInt(BASE_REPAIR_CAP, metalmark.repairCap)
            editor.putInt(BASE_SPEED, metalmark.speed)
            editor.putInt(BASE_EVASION, metalmark.evasion)
            editor.putInt(BASE_EDEF, metalmark.eDefense)
            editor.putInt(BASE_SENSOR_RANGE, metalmark.sensorRange)
            editor.putInt(BASE_SAVE_TARGET, metalmark.saveTarget)
            editor.putInt(BASE_SP, metalmark.sp)
            editor.putInt(BASE_TECH_ATTACK, metalmark.techAttack)
            editor.putString(FRAME_NAME, metalmark.name)
            editor.putString(FRAME_TRAIT, trait)
            editor.putString(FRAME_CORE_POWER, core)
            editor.apply()

            val intent = Intent(this, NameConfiguration::class.java)
            startActivity(intent)
        }


        //This button selects the Goblin as the frame and passes its base stats into shared preferences

        addGoblinButton.setOnClickListener {
            var goblin = Mech("Goblin", "@string/goblin_description",
                    6, 0, 4, 2, 5, 10, 12,
                    20, 11, 8, +2)
            var trait = resources.getString(R.string.goblin_traits)
            var core = resources.getString(R.string.goblin_core_power)
            editor.putInt(BASE_HP, goblin.hp)
            editor.putInt(BASE_ARMOR, goblin.armor)
            editor.putInt(BASE_HEAT_CAP, goblin.heatCap)
            editor.putInt(BASE_REPAIR_CAP, goblin.repairCap)
            editor.putInt(BASE_SPEED, goblin.speed)
            editor.putInt(BASE_EVASION, goblin.evasion)
            editor.putInt(BASE_EDEF, goblin.eDefense)
            editor.putInt(BASE_SENSOR_RANGE, goblin.sensorRange)
            editor.putInt(BASE_SAVE_TARGET, goblin.saveTarget)
            editor.putInt(BASE_SP, goblin.sp)
            editor.putInt(BASE_TECH_ATTACK, goblin.techAttack)
            editor.putString(FRAME_NAME, goblin.name)
            editor.putString(FRAME_TRAIT, trait)
            editor.putString(FRAME_CORE_POWER, core)
            editor.apply()

            val intent = Intent(this, NameConfiguration::class.java)
            startActivity(intent)
        }


        //Set up bottom navigation bar to switch activities on press

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btm_nav)

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


//This class is the base for each mech frame

class Mech{
    var name: String
    var description: String
    var hp: Int
    var armor: Int
    var heatCap: Int
    var repairCap: Int
    var speed: Int
    var evasion: Int
    var eDefense: Int
    var sensorRange: Int
    var saveTarget: Int
    var sp: Int
    var techAttack: Int

    constructor(name: String, description: String, hp: Int, armor: Int, heatCap: Int,
                repairCap: Int, speed: Int, evasion: Int, eDefense: Int, sensorRange: Int,
                saveTarget: Int, sp: Int, techAttack: Int) {

        this.name = name
        this.description = description
        this.hp = hp
        this.armor = armor
        this.heatCap = heatCap
        this.repairCap = repairCap
        this.speed = speed
        this.evasion = evasion
        this.eDefense = eDefense
        this.sensorRange = sensorRange
        this.saveTarget = saveTarget
        this.sp = sp
        this.techAttack = techAttack
    }
}
