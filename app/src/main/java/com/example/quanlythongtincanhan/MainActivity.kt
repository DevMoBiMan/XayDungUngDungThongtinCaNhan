package com.example.quanlythongtincanhan

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quanlythongtincanhan.databinding.ActivityMainBinding
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var radioGrp: RadioGroup
    lateinit var statusTV: TextView

    private val userList = mutableListOf<User>()
    private lateinit var UserAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()

        setupSaveButton()
    }

    private fun setupRecyclerView() {
        UserAdapter = UserAdapter(userList)
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewUsers.adapter = UserAdapter
    }

    private fun setupSaveButton() {
        binding.btnLuu.setOnClickListener {
            val name = binding.etxtHoVaTen.text.toString().trim()
            val email = binding.etxtEmail.text.toString().trim()
            val phone = binding.etxtSDT.text.toString().trim()

            val selectedGenderId = binding.rdGioTinh.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.rdNam -> "Nam"
                R.id.rdNu -> "Nữ"
                R.id.rdKhac -> "Khác"
                else -> ""
            }

            if (!binding.cbDieuKhoan.isChecked) {
                Toast.makeText(this, "Bạn cần đồng ý với điều khoản sử dụng", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty()) {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(name, email, phone, gender)
            userList.add(user)

            UserAdapter.notifyItemInserted(userList.size - 1)
            binding.recyclerViewUsers.scrollToPosition(userList.size - 1) // Cuộn xuống cuối danh sách

            clearInputFields()

            Toast.makeText(this, "Thông tin đã được lưu", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearInputFields() {
        binding.etxtHoVaTen.text.clear()
        binding.etxtEmail.text.clear()
        binding.etxtSDT.text.clear()
        binding.rdGioTinh.clearCheck()
        binding.cbDieuKhoan.isChecked = false
    }
}