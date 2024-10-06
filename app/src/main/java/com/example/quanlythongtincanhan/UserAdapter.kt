package com.example.quanlythongtincanhan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quanlythongtincanhan.databinding.ActivityMainBinding
import com.example.quanlythongtincanhan.databinding.ItemUserBinding

class UserAdapter(private val userList: List<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.textViewItemName.text = user.hovaten
            binding.textViewItemEmail.text = user.email
            binding.textViewItemPhone.text = user.sdt
            binding.textViewItemGender.text = user.gioitinh
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size
}