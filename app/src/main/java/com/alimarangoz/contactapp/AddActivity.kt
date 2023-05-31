package com.alimarangoz.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.alimarangoz.contactapp.configs.ContactDatabase
import com.alimarangoz.contactapp.models.Contact
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    private lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val groups = resources.getStringArray(R.array.groups)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, groups)
        autoCompleteTextView.setAdapter(arrayAdapter)

        database = ContactDatabase.getDatabase(this)

        val saveButton = findViewById<Button>(R.id.add_new_contact_btn)
        saveButton.setOnClickListener {
            val groupName = autoCompleteTextView.text.toString()
            val name = findViewById<AutoCompleteTextView>(R.id.name_txt).text.toString()
            val lastName = findViewById<AutoCompleteTextView>(R.id.last_name_txt).text.toString()
            val phoneNumber = findViewById<AutoCompleteTextView>(R.id.phone_txt).text.toString()
            val address = findViewById<AutoCompleteTextView>(R.id.address_txt).text.toString()

            val contact = Contact(0,groupName, name, lastName, phoneNumber, address)

            // Save the contact to the database
            insertContact(contact)
        }
    }

    private fun insertContact(contact: Contact) {
        GlobalScope.launch {
            database.contactDao().insertContact(contact)
            finish()
        }
    }
}