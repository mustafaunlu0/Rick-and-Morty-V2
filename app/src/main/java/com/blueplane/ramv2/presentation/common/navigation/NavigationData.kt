package com.blueplane.ramv2.presentation.common.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.fragment.FragmentNavigator

data class NavigationData(
    @IdRes val destinationId: Int,
    @IdRes val popupTo: Int? = null,
    val popupToInclusive: Boolean = false,
    val args: Bundle? = null,
    val fragmentNavigationExtras: FragmentNavigator.Extras? = null
)