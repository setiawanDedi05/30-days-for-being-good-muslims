package com.example.thirtydayforbeinggoodmuslims.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Activity(
    @StringRes val dayRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descRes: Int,
    @DrawableRes val imgRes: Int
)

