package com.example.cinergy.domain.movieList.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AvailableDate(
    val day: String,
    val date: String,
    val availableTimeList: List<String>
) : Parcelable