package com.example.raiffeisen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.raiffeisen.presentation.screens.UsersFragment

class MainActivity : AppCompatActivity() {

    private val usersFragment = UsersFragment.newInstance()
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.users_fragment, usersFragment)
        fragmentTransaction.commit()
    }
}