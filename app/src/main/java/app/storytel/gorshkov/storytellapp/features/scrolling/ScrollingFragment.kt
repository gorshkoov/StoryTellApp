package app.storytel.gorshkov.storytellapp.features.scrolling

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.base.BaseFragment
import app.storytel.gorshkov.storytellapp.features.scrolling.adapter.ScrollingAdapter
import kotlinx.android.synthetic.main.fragment_scrolling.*
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.ext.scope

class ScrollingFragment: BaseFragment() {
    private val viewModel: ScrollingViewModel by scope.viewModel(this)

    override val layoutRes = R.layout.fragment_scrolling

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.postsViewModel.observe(viewLifecycleOwner, Observer {
            scrolling_recycler.adapter = ScrollingAdapter(it) {

            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrolling_recycler.layoutManager = LinearLayoutManager(requireContext())
    }
}