package com.tombayley.dropdowntipslistexample

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tombayley.dropdowntipslist.DropDownList

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREFS_FILENAME = "prefs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences: SharedPreferences = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val appInstallTime = getAppInstallTime()

        val dropDownList: DropDownList = findViewById(R.id.drop_down_list)
        dropDownList.preferences = preferences
        dropDownList.addAll(DropDownItems.getItems(appInstallTime))
    }

    private fun getAppInstallTime(): Long {
        try {
            return packageManager.getPackageInfo(BuildConfig.APPLICATION_ID, 0).firstInstallTime
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return 0
    }

}
