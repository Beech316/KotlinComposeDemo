package com.brokenprotocol.kotlincomposedemo.data.models

data class Detail(
    val id : String,
    val name : String,
    val imageUrlStrings : List<String>,
    val phone : String,
    val email : String,
    val website : String,
    val desc : String
)
