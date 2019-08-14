package com.example.appskeleton.ui.fragments

import androidx.lifecycle.Observer
import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseFragment
import com.example.appskeleton.core.extension.getFullText
import com.example.appskeleton.models.Person
import com.example.appskeleton.ui.adapters.BaseRecyclerAdapter
import com.example.appskeleton.ui.adapters.BaseViewHolder
import com.example.appskeleton.ui.view_holders.ModelAdapterViews
import com.example.appskeleton.use_case.GetPerson
import com.example.appskeleton.utils.LayoutManagerUtils
import com.example.appskeleton.view_models.GetPersonViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.view_search_field.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment: BaseFragment() {

    override val layoutResource: Int
        get() = R.layout.fragment_main

    private val getPersonVM: GetPersonViewModel by viewModel()

    private val people = listOf<Person>()
    private val adapter: BaseRecyclerAdapter<Person, ModelAdapterViews.Person> by lazy {
        BaseRecyclerAdapter(ModelAdapterViews.Person::class, people
        ) { v, m, p -> setRowData(v, m, p)}
    }

    override fun setupUI() {
        super.setupUI()

        setupRV()
    }

    override fun setupViewModelsObservers() {
        getPersonVM.liveData.observe(this, Observer {
            it?.let { adapter.addData(listOf(it)) }
            showOrHideLoading(false)
        })
    }

    override fun setupListeners() {
        vSearchContainer.bSearch.setOnClickListener {
            val id = vSearchContainer.etSearch.getFullText()
            getPersonVM.loadData(GetPerson.Params(id))
            showOrHideLoading(true)
        }
    }

    private fun setupRV() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LayoutManagerUtils.vertical
    }

    private fun setRowData(viewHolder: BaseViewHolder<ModelAdapterViews.Person>, model: Person, position: Int) {
        viewHolder.views.name.text = model.name
    }
}