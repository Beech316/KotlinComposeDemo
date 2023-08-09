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

    fun getDetail() : Detail {

        return Detail(
            id = UUID.randomUUID().toString(),
            name = "Monster Energy",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "Here's some words that describe stuff."
        )

    }
}