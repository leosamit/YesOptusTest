package com.samit.yesoptustest.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OptusUI(
    val id: Int?,
    val text: String?
) : Parcelable