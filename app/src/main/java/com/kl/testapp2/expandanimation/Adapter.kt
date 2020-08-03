package com.kl.testapp2.expandanimation

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.core.view.doOnLayout
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.kl.testapp2.databinding.ItemExpandTestListBinding

class Adapter(val users: List<User>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var originalHeight = -1
    private var expandedHeight = -1
    private var expandedUser: User? = null
    private lateinit var _recyclerView: RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemExpandTestListBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = users[position]
        holder.binding.executeAfter {
            this.user = user
            this.textExpanded.isVisible = expandedUser == user
        }

        holder.binding.setOnClickItem {
            if (user != expandedUser) {
                // Collapse previous selected item.
                val expandedPosition = users.indexOf(expandedUser)
                val oldViewHolder =
                    _recyclerView.findViewHolderForAdapterPosition(expandedPosition) as? ViewHolder
                if (oldViewHolder != null) {
                    expandedUser?.let {
                        expandItem(oldViewHolder, true, true)
                    }
                }

                // Expand selected item.
                expandItem(holder, false, true)
                expandedUser = user
            }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        _recyclerView = recyclerView
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (expandedHeight < 0) {
            expandedHeight = 0
            holder.binding.container.doOnLayout { view ->
                originalHeight = view.height
                holder.binding.textExpanded.isVisible = true
                view.doOnPreDraw {
                    expandedHeight = view.height
                    holder.binding.textExpanded.isVisible = false
                }
            }
        }
    }

    fun expandItem(holder: ViewHolder, isExpanded: Boolean, animate: Boolean) {
        if (animate) {
            val animator = getValueAnimator(
                isExpanded.not(),
                100L,
                AccelerateDecelerateInterpolator()
            ) { progress ->
                holder.binding.container.layoutParams.height =
                    (originalHeight + (expandedHeight - originalHeight) * progress).toInt()
                holder.binding.container.requestLayout()
            }
            if (isExpanded.not()) {
                animator.doOnStart {
                    holder.binding.textExpanded.isVisible = true
                }
            } else {
                animator.doOnEnd {
                    holder.binding.textExpanded.isVisible = false
                }
            }
            animator.start()
        }
    }

    private fun getValueAnimator(
        forward: Boolean = true,
        duration: Long,
        interpolator: TimeInterpolator,
        updateListener: (progress: Float) -> Unit
    ): ValueAnimator {
        val animator =
            if (forward) ValueAnimator.ofFloat(0f, 1f) else ValueAnimator.ofFloat(1f, 0f)
        return animator.apply {
            this.addUpdateListener {
                updateListener(it.animatedValue as @kotlin.ParameterName(name = "progress") Float)
            }
            this.duration = duration
            this.interpolator = interpolator
        }
    }

    class ViewHolder(
        val binding: ItemExpandTestListBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

fun <T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}