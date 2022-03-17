package com.mandarjoshi.androidnextgen.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.mandarjoshi.androidnextgen.databinding.FragmentActionBinding

import com.mandarjoshi.androidnextgen.model.Action

class MyActionAdapter(
    private val items: List<Action>,
    private val onItemClickListener: (String) -> Unit
) : RecyclerView.Adapter<MyActionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            onItemClickListener,
            FragmentActionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = items[position]
        holder.description.text = holder.mItem.description
        holder.date.text = holder.mItem.date
        holder.id = holder.mItem.id
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(onItemClickListener: (String) -> Unit, binding: FragmentActionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val description: TextView = binding.actionDescription
        val date: TextView = binding.actionDate
        lateinit var id: String
        lateinit var mItem: Action
        override fun toString(): String {
            return super.toString() + " '" + date.text + "'"
        }

        init {
            binding.root.setOnClickListener { onItemClickListener(id) }
        }
    }
}
