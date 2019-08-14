package com.example.appskeleton.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appskeleton.models.IModel
import com.example.appskeleton.ui.view_holders.ModelAdapterViews
import kotlin.reflect.KClass

open class BaseRecyclerAdapter<M: IModel, VH: ModelAdapterViews>(
        private var klass: KClass<VH>,
        private var items: List<M>,
        private var setRowData: (viewHolder: BaseViewHolder<VH>, model: M, position: Int) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BaseViewHolder(ModelAdapterViews.get(klass as KClass<ModelAdapterViews>, parent))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindData(holder as BaseViewHolder<VH>, items[position], position)
    }

    protected open fun bindData(viewHolder: BaseViewHolder<VH>, model: M, position: Int) {
        setRowData(viewHolder, model, position)
    }

    fun addData(data: List<M>) {
        val existing = items.toMutableList()
        existing.addAll(data)

        items = existing

        notifyDataSetChanged()
    }
}

class BaseViewHolder<out T: ModelAdapterViews> (val views: T): RecyclerView.ViewHolder(views.rootView)