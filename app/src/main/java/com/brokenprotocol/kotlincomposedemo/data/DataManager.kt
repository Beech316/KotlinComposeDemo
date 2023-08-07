package com.brokenprotocol.kotlincomposedemo.data

import com.brokenprotocol.kotlincomposedemo.data.models.Category

object DataManager {

    fun getCategoryList() : List<Category> {

        var categoryList : MutableList<Category> = mutableListOf()
        categoryList.add(Category("1", "Forest", ""))
        categoryList.add(Category("2", "Ocean", ""))
        categoryList.add(Category("3", "Mountain", ""))
        categoryList.add(Category("4", "Lake", ""))
        return categoryList

    }
}