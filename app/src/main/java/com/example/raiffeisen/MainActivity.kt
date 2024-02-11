package com.example.raiffeisen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.raiffeisen.presentation.screens.UsersFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var usersFragment: UsersFragment
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.users_fragment, usersFragment)
        fragmentTransaction.commit()
    }
}