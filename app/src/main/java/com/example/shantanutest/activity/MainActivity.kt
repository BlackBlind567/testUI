package com.example.shantanutest.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.shantanutest.R
import com.example.shantanutest.databinding.ActivityMainBinding
import com.example.shantanutest.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this, com.example.shantanutest.R.layout.activity_main)

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(com.example.shantanutest.R.id.fragment_container, LoginFragment())
        transaction.addToBackStack(null)
        transaction.commit()




    }
}