package com.tombayley.dropdowntipslist

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ImageView

object ColorUtil {

    fun giveColorAlpha(color: Int, alpha: Float): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Color.argb(
                    alpha,
                    Color.red(color).toFloat() / 255,
                    Color.green(color).toFloat() / 255,
                    Color.blue(color).toFloat() / 255
            )
        } else {
            Color.argb(
                    (alpha * 255f).toInt(),
                    Color.red(color),
                    Color.green(color),
                    Color.blue(color)
            )
        }
    }

}
