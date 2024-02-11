package com.example.raiffeisen.presentation.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.raiffeisen.R
import com.example.raiffeisen.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UsersFragment @Inject constructor() : Fragment() {

    private val viewModel: UsersViewModel by viewModels()
    private lateinit var viewBinding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentUsersBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            Toast.makeText(requireContext(), "Users: $users", Toast.LENGTH_SHORT).show()
        })
    }
}