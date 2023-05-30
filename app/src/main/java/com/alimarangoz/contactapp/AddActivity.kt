package com.alimarangoz.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val autoCompleteTextView =  findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val groups = resources.getStringArray(R.array.groups)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item,groups)
        autoCompleteTextView.setAdapter(arrayAdapter)

    }
}