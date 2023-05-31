package com.alimarangoz.contactapp.contactDAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.alimarangoz.contactapp.models.Contact

@Dao
interface IContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE groupName = :groupName")
    fun getContactsByGroup(groupName: String): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>
}