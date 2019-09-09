package com.tombayley.dropdowntipslist

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ImageView

class ColorUtil {

    companion object {

        fun setImageColor(image: ImageView?, color: Int) {
            setColorFilter(image, color)
//            setColorFilter(image, removeColorAlpha(color))
//            image?.alpha = Color.alpha(color) / 255f
        }

        fun removeColorAlpha(color: Int): Int {
            return Color.rgb(Color.red(color), Color.green(color), Color.blue(color))
        }

        private fun setColorFilter(imageView: ImageView?, color: Int) {
            imageView?.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }

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

}