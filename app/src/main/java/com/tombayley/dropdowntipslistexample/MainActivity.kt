package com.tombayley.dropdowntipslistexample

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tombayley.dropdowntipslist.DropDownList
import java.util.*

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

        val dropDownListItems = LinkedList<DropDownList.Item>()
        var item: DropDownList.Item

        item = DropDownList.Item(
            title = "Enter a title",
            description = "Enter a description",
            actionText = getString(android.R.string.ok),
            action = Runnable {
                // ...
            }
        )
        item.setAppearAfter(appInstallTime, 0, "drop_list_example1")
        dropDownListItems.add(item)

        item = DropDownList.Item(
            title = "Example Item 2",
            description = "Example Description 2",
            actionText = "Action 2",
            action = Runnable {
                // ...
            }
        )
        item.setAppearAfter(appInstallTime, 0, "drop_list_example2")
        dropDownListItems.add(item)

        item = DropDownList.Item(
            title = "Tip with no action",
            description = "Tip description"
        )
        item.setAppearAfter(appInstallTime, 12, "drop_list_example2")
        dropDownListItems.add(item)

        dropDownList.addAll(dropDownListItems)
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
