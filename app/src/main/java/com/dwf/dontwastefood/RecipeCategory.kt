package com.dwf.dontwastefood

import android.graphics.drawable.Drawable

class RecipeCategory(val drawable: Drawable, val name: String) {

    override fun toString(): String {
        return name
    }
}
