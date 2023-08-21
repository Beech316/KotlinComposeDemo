package com.brokenprotocol.kotlincomposedemo.data

import android.location.Location
import android.location.LocationManager
import com.brokenprotocol.kotlincomposedemo.data.models.Category
import com.brokenprotocol.kotlincomposedemo.data.models.Detail
import java.util.UUID

object DataManager {

    fun getCategoryList() : List<Category> {

        var categoryList : MutableList<Category> = mutableListOf()
        categoryList.add(Category("1", "Forest", ""))
        categoryList.add(Category("2", "Ocean", ""))
        categoryList.add(Category("3", "Mountain", ""))
        categoryList.add(Category("4", "Lake", ""))
        return categoryList

    }

    fun getDetailList() : List<Detail> {

        val targetlocation = Location(LocationManager.GPS_PROVIDER)
        targetlocation.latitude = 48.42678121419683
        targetlocation.longitude = -123.36438634866388

        val first = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Forest",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe a very cool forest, with nice trees.",
            location = targetlocation
        )

        val second = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Lake",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe a beautiful lake, with glassy water.",
            location = targetlocation
        )

        val third = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Ocean",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe a lovely ocean, with beautiful swells.",
            location = targetlocation
        )

        val detailList : MutableList<Detail> = mutableListOf()
        detailList.add(first)
        detailList.add(second)
        detailList.add(third)

        return detailList

    }

    fun getDetail() : Detail {

        val targetlocation = Location(LocationManager.GPS_PROVIDER)
        targetlocation.latitude = 48.42678121419683
        targetlocation.longitude = -123.36438634866388

        return Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Forest",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe stuff.",
            location = targetlocation
        )

    }
}