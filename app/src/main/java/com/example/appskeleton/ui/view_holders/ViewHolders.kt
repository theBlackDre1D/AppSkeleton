package com.example.appskeleton.ui.view_holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appskeleton.R
import kotlinx.android.synthetic.main.item_starwars_person.view.*
import kotlin.reflect.KClass

abstract class ModelAdapterViews(parent: ViewGroup, layoutResourceId: Int, attachToRoot: Boolean = false): RecyclerView.ViewHolder(parent) {

    companion object {
        fun get(klass: KClass<ModelAdapterViews>, parent: ViewGroup): ModelAdapterViews =
            when (klass) {
                Person::class -> Person(parent)
                else -> throw Exception("Unknown ViewHolder class")
            }
    }

    val rootView = LayoutInflater.from(parent.context).inflate(layoutResourceId, parent, attachToRoot)!!

    class Person(parent: ViewGroup): ModelAdapterViews(parent, R.layout.item_starwars_person) {
        val name = rootView.tvName
    }
}