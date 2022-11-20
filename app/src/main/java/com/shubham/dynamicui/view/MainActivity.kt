package com.shubham.dynamicui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.shubham.dynamicui.databinding.ActivityMainBinding
import com.shubham.dynamicui.model.Data
import com.shubham.dynamicui.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        initObserver()
    }

    private fun initObserver() {
        mainViewModel.uiData.observe(this) {
        }
        mainViewModel.data.observe(this) {
            addDynamicForm(it)
        }

    }

    private fun addDynamicForm(data: List<Data>) {

        for (item in data) {
            val textView = TextView(this).apply {
                text = item.displayName
                textSize = 20f
            }
            val editText = EditText(this).apply {
                hint = item.placeholder
                inputType = inputType(item.fieldType)
            }
            binding.apply {
                scrollLinear.addView(textView)
                scrollLinear.addView(editText)
            }
        }

    }


    private fun inputType(inputType: String): Int {
        var type = InputType.TYPE_CLASS_TEXT
        when (inputType) {
            "textField" -> {
                type = InputType.TYPE_CLASS_TEXT
            }
            "password" -> {
                type = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
            }
        }
        return type
    }
}