package com.tombayley.dropdowntipslistexample

import android.animation.LayoutTransition
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.tombayley.dropdowntipslist.DropDownList
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREFS_FILENAME = "prefs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appInstallTime = getAppInstallTime()

        val dropDownList = findViewById<DropDownList>(R.id.drop_down_list)
        dropDownList.preferences = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

        // Allow a smooth animation of content below the tips list when expanding/collapsing
        findViewById<LinearLayout>(R.id.content_area)
            .layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        val dropDownListItems = LinkedList<DropDownList.Item>()

        dropDownListItems.add(
            DropDownList.Item(
                title = "Enter a title",
                description = "Enter a description",
                actionText = getString(android.R.string.ok),
                action = Runnable {
                    // ...
                }
            ).apply {
                setAppearAfter(appInstallTime, 0, "drop_list_example1")
            }
        )

        dropDownListItems.add(
            DropDownList.Item(
                title = "Example Item 2",
                description = "Example Description 2",
                actionText = "Action 2",
                action = Runnable {
                    // ...
                }
            ).apply {
                setAppearAfter(appInstallTime, 0, "drop_list_example2")
            }
        )

        dropDownListItems.add(
            DropDownList.Item(
                title = "Tip with no action",
                description = "Tip description"
            ).apply {
                setAppearAfter(appInstallTime, 12, "drop_list_example3")
            }
        )

        dropDownList.addAll(dropDownListItems)
    }

    private fun getAppInstallTime(): Long {
        return try {
             packageManager.getPackageInfo(BuildConfig.APPLICATION_ID, 0).firstInstallTime
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            0
        }
    }

}
