package com.brokenprotocol.kotlincomposedemo.data

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

        val first = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Forest",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe a very cool forest, with nice trees."
        )

        val second = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Lake",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe a beautiful lake, with glassy water."
        )

        val third = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Ocean",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe a lovely ocean, with beautiful swells."
        )

        val detailList : MutableList<Detail> = mutableListOf()
        detailList.add(first)
        detailList.add(second)
        detailList.add(third)

        return detailList

    }

    fun getDetail() : Detail {

        return Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Forest",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe stuff."
        )

    }
}