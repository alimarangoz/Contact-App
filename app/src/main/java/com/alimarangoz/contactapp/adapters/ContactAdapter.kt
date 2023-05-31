package com.alimarangoz.contactapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alimarangoz.contactapp.R
import com.alimarangoz.contactapp.models.Contact

class ContactAdapter : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(ContactDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val surnameTextView: TextView = itemView.findViewById(R.id.surnameTextView)
        private val phoneNumberTextView: TextView = itemView.findViewById(R.id.phoneNumberTextView)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        private val groupNameTextView: TextView = itemView.findViewById(R.id.groupNameTextView)

        fun bind(contact: Contact) {
            nameTextView.text = contact.name
            surnameTextView.text = contact.surname
            phoneNumberTextView.text = contact.phoneNumber
            addressTextView.text = contact.address
            groupNameTextView.text = contact.groupName
        }
    }

    private class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }
}