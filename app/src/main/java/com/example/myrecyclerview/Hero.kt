package com.example.myrecyclerview

import android.os.Parcelable

class Hero {
    val photo: Any

    @Parcelize
    data class Hero(
        var name: String,
        var description: String,
        var photo: String
    ) : Parcelable
}