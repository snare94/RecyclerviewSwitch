package io.yoobi.recyclerviewpartialupdate

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.yoobi.recyclerviewpartialupdate.databinding.ItemBinding


class MyAdapter: ListAdapter<TextBoolean, MyAdapter.MyViewHolder>(MyDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class MyViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TextBoolean) {
            binding.tvLabel.text = item.text
            binding.toggle.isChecked = item.boolean
            binding.toggle.setOnCheckedChangeListener { _, isChecked ->
                item.boolean = isChecked
                Log.e("MyAdapter", "$currentList")
            }
            binding.root.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {}

                override fun onViewDetachedFromWindow(v: View) {
                    binding.toggle.setOnCheckedChangeListener(null)
                }
            })
        }
    }

    object MyDiffUtil: DiffUtil.ItemCallback<TextBoolean>() {
        override fun areItemsTheSame(oldItem: TextBoolean, newItem: TextBoolean): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: TextBoolean, newItem: TextBoolean): Boolean {
            return oldItem == newItem
        }
    }
}
