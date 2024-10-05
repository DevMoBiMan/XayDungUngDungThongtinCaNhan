package com.example.quanlythongtincanhan

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var userList: MutableList<User> = mutableListOf()

        val hoten: EditText = findViewById(R.id.etxtHoVaTen)
        val email: EditText = findViewById(R.id.etxtEmail)
        val sdt: EditText = findViewById(R.id.etxtSDT)
        val radioGroup: RadioGroup = findViewById(R.id.rdGioiTinh)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val gioitinh = findViewById<RadioButton>(checkedId)
        }

    }
}