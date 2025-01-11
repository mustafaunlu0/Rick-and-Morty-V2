package com.blueplane.ramv2.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.blueplane.ramv2.R
import com.blueplane.ramv2.presentation.common.navigation.NavigationData

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: DB

    protected abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResId())
    }


    open fun buildNavOptions(
        popUpToDestinationId: Int? = null,
        inclusive: Boolean = false
    ): NavOptions {
        /**
         * Animasyon eklenebilir
         */

        val builder = NavOptions.Builder()
            .setLaunchSingleTop(true)
        popUpToDestinationId?.let {
            builder.setPopUpTo(it, inclusive)
        }
        return builder.build()
    }

    open fun navigateDestination(navController: NavController, navigationData: NavigationData) {
        navController.navigate(
            navigationData.destinationId,
            navigationData.args,
            buildNavOptions(navigationData.popupTo, navigationData.popupToInclusive),
            navigationData.fragmentNavigationExtras
        )

    }


}