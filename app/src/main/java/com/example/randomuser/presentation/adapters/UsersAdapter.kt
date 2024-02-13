package com.example.randomuser.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.raiffeisen.databinding.UsersLayoutBinding
import com.example.randomuser.data.models.user.Users
import com.squareup.picasso.Picasso

class UsersAdapter : PagingDataAdapter<Users, UsersAdapter.ViewHolder>(DiffUtilCallBack) {

    inner class ViewHolder(val binding: UsersLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Users) {
            val userPicture = Picasso.with(binding.root.context).load(user.picture.large)
            binding.apply {
                userPicture.into(userImage)
                userName.text = user.name.first + user.name.last
                userExperience.text =
                    user.registered.age.toString() + " from " + user.location.country
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = UsersLayoutBinding.inflate(LayoutInflater.from(viewGroup.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        getItem(position)?.let { viewHolder.bind(it) }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<Users>() {
        override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem == newItem
        }
    }

}