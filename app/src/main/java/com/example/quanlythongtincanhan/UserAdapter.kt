package com.example.quanlythongtincanhan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        /*holder.HoVaTen.text = user.hovaten
        holder.email.text = user.email
        holder.sdt.text = user.sdt*/
        /*holder.tvGender.text = user.gender*/
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val HoVaTen : EditText = itemView.findViewById(R.id.etxtHoVaTen)
        val email : EditText = itemView.findViewById(R.id.etxtEmail)
        val sdt : EditText = itemView.findViewById(R.id.etxtSDT)
        /*val gioitinh : EditText = itemView.findViewById(R.id.etxtHoVaTen)*/
    }

}