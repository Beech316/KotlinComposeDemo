package com.brokenprotocol.kotlincomposedemo.data.models

import android.location.Location

data class Detail(
    val id : String,
    val name : String,
    val imageUrlStrings : List<String>,
    val phone : String,
    val email : String,
    val website : String,
    val desc : String,
    val location : Location
) {
    fun getFirstImage(): String {
        return imageUrlStrings.firstOrNull() ?: return ""
    }

    fun getImages() : List<String> {

        if (imageUrlStrings.isEmpty()) {

            val fakeList = mutableListOf<String>()
            fakeList.add("")
            fakeList.add("")
            fakeList.add("")
            return fakeList

        }

        return imageUrlStrings

    }

}
