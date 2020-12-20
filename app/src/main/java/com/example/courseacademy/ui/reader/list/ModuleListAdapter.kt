package com.example.courseacademy.ui.reader.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.courseacademy.data.ModuleEntity
import com.example.courseacademy.databinding.CustomItemModuleListBinding


class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener) :
    RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>() {

    private val listModules = arrayListOf<ModuleEntity>()

    internal fun setModules(modules: ArrayList<ModuleEntity>?) {
        if (modules == null) return
        this.listModules.clear()
        this.listModules.addAll(modules)
    }

    inner class ModuleViewHolder(private val binding: CustomItemModuleListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val binding =
            CustomItemModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(
                holder.adapterPosition,
                listModules[holder.adapterPosition].moduleId
            )
        }
    }

    override fun getItemCount(): Int = listModules.size
}

interface MyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}
