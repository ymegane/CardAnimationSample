package org.ymegane.android.cardanimationsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.ymegane.android.cardanimationsample.databinding.ViewListItemBinding

class ItemAdapter(
    context: Context,
    private val clickEvent: (position: Int, itemBinding: ViewListItemBinding, item: Item) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = Item.values().size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Item.values()[position]

        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickEvent(position, holder.binding, item)
        }
    }

    class ViewHolder(val binding: ViewListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.resourceId = item.resId
            binding.executePendingBindings()
        }
    }
}