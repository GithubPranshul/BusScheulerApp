package com.example.busschedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.busschedule.databinding.BusStopItemBinding
import java.text.SimpleDateFormat

class BusStopAdapter(private val onItemClcked: (Schedule) -> Unit): ListAdapter<Schedule, BusStopAdapter.BusStopViewHolder>(DiffCallback) {
    @SuppressLint("SimpleDateFormat")
    fun bind(schedule: Schedule) {
        binding.stopNameTextView.text = schedule.stopName
        binding.arrivalTimeTextView.text = SimpleDateFormat(
            "h:mm a").format(Date(schedule.arrivalTime.toLong() * 1000)
        )
    }
}
override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): BusStopViewHolder {
    val viewHolder = BusSopViewHolder(
        BusStopItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )
    viewHolder.item.setOnClickListener  {
        val  position = viewHolder.adapterPosition
        onItemClicked(getItem(position))
    }
    return viewHolder
}
override fun onBindViewHolder(holder: BusStopViewHolder, position: Int) {
    holder.bind(getItem(position))
}
companion object {
    private val DiffCallback = object : DiffUtil.ItemCallback<Schedule>() {
        override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean
           return oldItem.id == newItme.id
        }
       override fun areContentsTheSame(oldItme: Schedule,newItem: Schedule): Boolean
       return oldItem== newItem
    }
