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
            desc = "A forest is an area of land dominated by trees. Hundreds of definitions of forest are used throughout the world, incorporating factors such as tree density, tree height, land use, legal standing, and ecological function. The United Nations' Food and Agriculture Organization (FAO) defines a forest as, \"Land spanning more than 0.5 hectares with trees higher than 5 meters and a canopy cover of more than 10 percent, or trees able to reach these thresholds in situ. It does not include land that is predominantly under agricultural or urban use.\" Using this definition, Global Forest Resources Assessment 2020 (FRA 2020) found that forests covered 4.06 billion hectares (10.0 billion acres; 40.6 million square kilometres; 15.7 million square miles), or approximately 31 percent of the world's land area in 2020.",
            location = targetlocation
        )

        val second = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Lake",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "A lake is a naturally occurring, relatively large body of water localized in a basin surrounded by dry land. A lake generally has a slower-moving flow than the inflow or outflow stream(s) that serve to feed or drain it. Lakes lie completely on land and are separate from the ocean, although, like the much larger oceans, they form part of the Earth's water cycle by serving as large standing pools of storage water. Most lakes are freshwater and account for almost all the world's surface freshwater, but some are salt lakes with salinities even higher than that of seawater. ",
            location = targetlocation
        )

        val third = Detail(
            id = UUID.randomUUID().toString(),
            name = "Cool Ocean",
            imageUrlStrings = listOf(),
            phone = "17782157845",
            email = "test@test.com",
            website = "https://www.google.ca",
            desc = "The ocean (also known as the sea or the world ocean) is a body of salt water that covers approximately 70.8% of the Earth and contains 97% of Earth's water. The term ocean also refers to any of the large bodies of water into which the world ocean is conventionally divided.[10] Distinct names are used to identify five different areas of the ocean: Pacific (the largest), Atlantic, Indian, Southern, and Arctic (the smallest). Seawater covers approximately 361,000,000 km2 (139,000,000 sq mi) of the planet. The ocean is the primary component of the Earth's hydrosphere, and thus essential to life on Earth. The ocean influences climate and weather patterns, the carbon cycle, and the water cycle by acting as a huge heat reservoir. ",
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