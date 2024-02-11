package com.example.raiffeisen.presentation.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raiffeisen.R
import com.example.raiffeisen.databinding.FragmentUsersBinding

class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private lateinit var viewModel: UsersViewModel
    private lateinit var viewBinding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentUsersBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}