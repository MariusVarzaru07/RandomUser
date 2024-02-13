package com.example.randomuser.presentation.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.raiffeisen.R
import com.example.raiffeisen.databinding.UsersLayoutBinding
import com.example.randomuser.data.models.user.Users

class UsersAdapter(private val users: List<Users>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: UsersLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Users) {
            //val picture = getUserPicture.invoke(user)
            binding.apply {
                userImage.setImageResource(R.drawable.ic_launcher_background)
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
        viewHolder.bind(users[position])
    }

    override fun getItemCount() = users.size

}