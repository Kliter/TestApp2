package com.kl.testapp2.listadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityListAdapterBinding

class ListAdapterTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListAdapterBinding

    private val listItems = users.mapIndexed { index, user ->
        if (index == 1) {
            ListItem(
                user,
                true
            )
        } else {
            ListItem(
                user,
                false
            )
        }
    }.toMutableList()

    private val adapter = ListAdapter(listItems)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_adapter)

        binding.recyclerView.apply {
            this.adapter = this@ListAdapterTestActivity.adapter
            this.itemAnimator = DefaultItemAnimator()
            this.layoutManager = object : LinearLayoutManager(context) {
                override fun scrollVerticallyBy(
                    dy: Int,
                    recycler: RecyclerView.Recycler?,
                    state: RecyclerView.State?
                ): Int {
                    val scrollRange = super.scrollVerticallyBy(dy, recycler, state)
                    if (state?.isPreLayout == true) {
                        val overScroll = dy - scrollRange
                        if (overScroll > 5) {
                            (adapter as ListAdapter).expandNextItem()
                        } else if (overScroll < -5) {
                            (adapter as ListAdapter).expandPreviousItem()
                        }
                    }
                    return scrollRange
                }
            }
            this.addItemDecoration(
                DividerItemDecoration(
                    this@ListAdapterTestActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            this.itemAnimator = DefaultItemAnimator()
        }
    }
}

data class ListItem(
    val user: User,
    var isExpanded: Boolean
)