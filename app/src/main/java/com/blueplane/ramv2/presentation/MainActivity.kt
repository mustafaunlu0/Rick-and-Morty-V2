package com.blueplane.ramv2.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.blueplane.ramv2.R
import com.blueplane.ramv2.databinding.ActivityMainBinding
import com.blueplane.ramv2.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel : MainViewModel by viewModels()
    private val navController by lazy (LazyThreadSafetyMode.NONE){
        findNavController(R.id.fragmentContainerView)
    }


    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel.navigateToDestination.observe(this){
           navigateDestination(navController,it)
        }
    }
}