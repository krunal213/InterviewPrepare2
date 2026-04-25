package com.app.interviewprepare.viewmodel.savestatehandle

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@kotlinx.parcelize.Parcelize
sealed class Result<out T> : Parcelable {
    @Parcelize
    data class Success<out T>(val data : @RawValue T) : Result<T>()
    @Parcelize
    data class Error(val exception: Exception) : Result<Nothing>()
    @Parcelize
    object Loading : Result<Nothing>()
}