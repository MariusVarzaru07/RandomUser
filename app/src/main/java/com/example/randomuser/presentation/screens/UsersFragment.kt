package com.example.randomuser.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raiffeisen.databinding.FragmentUsersBinding
import com.example.randomuser.presentation.adapters.UsersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UsersFragment @Inject constructor() : Fragment() {

    private val viewModel: UsersViewModel by viewModels()
    private lateinit var usersAdapter: UsersAdapter
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

        initUserAdapter()
        initObservers()
    }

    private fun initUserAdapter() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.usersList.layoutManager = layoutManager
        usersAdapter = UsersAdapter()
        viewBinding.usersList.adapter = usersAdapter
        viewBinding.usersList.addItemDecoration(
            DividerItemDecoration(
                context,
                layoutManager.orientation
            )
        )
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getUsers().observe(viewLifecycleOwner) {
                usersAdapter.submitData(lifecycle, it)
            }
        }
    }
}