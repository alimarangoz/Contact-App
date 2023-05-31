package com.alimarangoz.contactapp.ui.work

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alimarangoz.contactapp.AddActivity
import com.alimarangoz.contactapp.configs.ContactDatabase
import com.alimarangoz.contactapp.contactDAO.IContactDAO
import com.alimarangoz.contactapp.models.Contact

class WorkViewModel(application: Application) : AndroidViewModel(application) {

    private val contactDao: IContactDAO
    private val allContacts: LiveData<List<Contact>>

    init {
        val database = ContactDatabase.getDatabase(application)
        contactDao = database.contactDao()
        allContacts = contactDao.getAllContacts()
    }

    fun getAllContacts(): LiveData<List<Contact>> {
        return allContacts
    }

    suspend fun insertContact(contact: Contact) {
        contactDao.insertContact(contact)
    }

    suspend fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}