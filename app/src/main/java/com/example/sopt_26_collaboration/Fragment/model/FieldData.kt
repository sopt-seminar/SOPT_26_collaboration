package com.example.sopt_26_collaboration.Fragment.model

import android.content.res.ColorStateList
import android.graphics.Color

data class FieldData(val name: String, val color: String) {
    val colorState: Int
        get() = Color.parseColor(color)

}