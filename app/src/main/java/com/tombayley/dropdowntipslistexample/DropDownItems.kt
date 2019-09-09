package com.tombayley.dropdowntipslistexample

import com.tombayley.dropdowntipslist.DropDownList
import java.util.*

class DropDownItems {

    companion object {
        fun getItems(APP_INSTALL_TIME: Long): LinkedList<DropDownList.Item> {
            val dropDownListItems = LinkedList<DropDownList.Item>()
            var item: DropDownList.Item

            item = DropDownList.Item(
                title = "title",
                description = "desc",
                actionText = "action",
                action = Runnable {  }
            )
            item.setAppearAfter(APP_INSTALL_TIME, 0, "drop_list_gestures_cust_handle")
            dropDownListItems.add(item)

            item = DropDownList.Item(
                title = "title",
                description = "desc",
                actionText = "action",
                action = Runnable {  }
            )
            item.setAppearAfter(APP_INSTALL_TIME, 12, "drop_list_qs_tile_toggle_service")
            dropDownListItems.add(item)

            item = DropDownList.Item(
                title = "title",
                description = "desc"
            )
            item.setAppearAfter(APP_INSTALL_TIME, 0, "drop_list_open_from_shortcut")
            dropDownListItems.add(item)

            return dropDownListItems
        }

    }

}
