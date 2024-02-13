package com.example.randomuser.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raiffeisen.databinding.FragmentUsersBinding
import com.example.randomuser.data.models.user.Users
import com.example.randomuser.presentation.adapters.UsersAdapter
import dagger.hilt.android.AndroidEntryPoint
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

        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            initUserAdapter(users)
        })
    }

    private fun initUserAdapter(users: List<Users>) {
        viewBinding.usersList.layoutManager = LinearLayoutManager(context)
        usersAdapter = UsersAdapter(users)
        viewBinding.usersList.adapter = usersAdapter
    }
}