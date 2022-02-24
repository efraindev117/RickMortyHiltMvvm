package com.example.rickmortyhiltmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmortyhiltmvvm.databinding.ItemCharacterBinding
import com.example.rickmortyhiltmvvm.model.ResultApi

class AdapterCharacter : RecyclerView.Adapter<AdapterCharacter.MyViewHolder>() {

    inner class MyViewHolder(
        val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object :DiffUtil.ItemCallback<ResultApi>(){
        override fun areItemsTheSame(oldItem: ResultApi, newItem: ResultApi): Boolean {
        return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultApi, newItem: ResultApi): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(list: List<ResultApi>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
       )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curreImage =differ.currentList[position]
        holder.binding.apply {
            tvNombre.text = curreImage.name
            tvGenero.text = curreImage.gender
            tvSpecie.text = curreImage.species
        }
    }

    override fun getItemCount() = differ.currentList.size

}