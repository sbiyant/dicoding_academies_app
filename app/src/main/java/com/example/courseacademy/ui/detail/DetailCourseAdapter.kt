package com.example.courseacademy.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.courseacademy.data.ModuleEntity
import com.example.courseacademy.databinding.ItemModuleListBinding

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {

    inner class ModuleViewHolder(private val binding: ItemModuleListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }

    }

    private val listModules = arrayListOf<ModuleEntity>()

    fun setModules(modules: ArrayList<ModuleEntity>?) {
        if (modules == null) return
        this.listModules.clear()
        this.listModules.addAll(modules)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val itemModuleListBinding =
            ItemModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ModuleViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
    }

    override fun getItemCount(): Int = listModules.size

}