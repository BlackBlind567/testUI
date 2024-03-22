package com.example.shantanutest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shantanutest.utils.UpdateListener
import java.util.*

abstract class BlindAdapter<T, D> : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    var context: Context
    var arrayList: ArrayList<T>
    var listener: UpdateListener? = null
        private set
    var valueCheck: String? = null
    constructor(context: Context, arrayList: ArrayList<T>) {
        this.context = context
        this.arrayList = arrayList
    }

    constructor(mContext: Context, mArrayList: ArrayList<T>, updateListener: UpdateListener?) {
        context = mContext
        arrayList = mArrayList
        this.listener = updateListener
    }

    constructor(
        mContext: Context,
        mArrayList: ArrayList<T>,
        updateListener: UpdateListener?,
        valueCheck: String?
    ) {
        context = mContext
        arrayList = mArrayList
        this.listener = updateListener
        this.valueCheck = valueCheck
    }

    constructor(mContext: Context, mArrayList: ArrayList<T>, valueCheck: String?) {
        context = mContext
        arrayList = mArrayList
        this.valueCheck = valueCheck
    }






    abstract val layoutResId: Int
    abstract fun onBindData(model: T?, position: Int, dataBinding: D)
    protected abstract fun onBindDataHolder(
        t: T?,
        position: Int,
        mDataBinding: D,
        holder: RecyclerView.ViewHolder?
    )

    abstract fun onItemClick(model: T?, position: Int)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val dataBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutResId,
            parent,
            false
        )
        val holder: RecyclerView.ViewHolder = ItemViewHolder(dataBinding)
        holder.setIsRecyclable(false)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindData(arrayList[position], position, (holder as BlindAdapter<*, *>.ItemViewHolder).mDataBinding as D)
        onBindDataHolder(arrayList[position], position, holder.mDataBinding as D, holder)
        (holder.mDataBinding as ViewDataBinding).root.setOnClickListener(View.OnClickListener {
            onItemClick(
                arrayList[position], position
            )
        })
    }

    override fun getItemCount(): Int {
        return arrayList.size
//        return arrayList.size.coerceAtMost(4);
    }

    fun addItems(arrayList: ArrayList<T>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    fun swapeItem(fromPosition: Int, toPosition: Int) {
        Collections.swap(arrayList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    fun removeItem(removeItemPosition: Int, arrayList: ArrayList<T>) {
        this.arrayList = arrayList
        arrayList.removeAt(removeItemPosition)
        notifyItemRemoved(removeItemPosition)
        notifyItemRangeChanged(removeItemPosition, arrayList.size)
    }

    fun removeWithoutItemList(removeItemPosition: Int) {
        arrayList.removeAt(removeItemPosition)
        notifyItemRemoved(removeItemPosition)
        notifyItemRangeChanged(removeItemPosition, arrayList.size)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun getItem(position: Int): T? {
        return arrayList[position]
    }

    internal inner class ItemViewHolder(binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var mDataBinding: D

        init {
            mDataBinding = binding as D
        }
    }
}