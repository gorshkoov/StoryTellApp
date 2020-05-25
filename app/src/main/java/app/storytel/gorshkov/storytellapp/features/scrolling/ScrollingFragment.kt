package app.storytel.gorshkov.storytellapp.features.scrolling

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.base.BaseFragment
import app.storytel.gorshkov.storytellapp.features.scrolling.adapter.ScrollingAdapter
import app.storytel.gorshkov.storytellapp.features.scrolling.items.ScrollingItem
import kotlinx.android.synthetic.main.fragment_scrolling.*
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.ext.scope

class ScrollingFragment : BaseFragment() {
    private val viewModel: ScrollingViewModel by scope.viewModel(this)

    override val layoutRes = R.layout.fragment_scrolling

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.postsLiveData.observe(viewLifecycleOwner, Observer {
            scrolling_recycler.adapter = ScrollingAdapter(it) { view ->
                val item = view.getTag(R.id.tag_item) as ScrollingItem
                val action =
                    ScrollingFragmentDirections.openDetailsAction(
                        item.id, item.title, item.fullImageUrl ?: ""
                    )

                findNavController().navigate(action)
            }
        })
        viewModel.progressLiveData.observe(viewLifecycleOwner, Observer {
            progress_bar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            if (it) {
                network_error_text.visibility = View.VISIBLE
                network_error_button.visibility = View.VISIBLE
                scrolling_recycler.visibility = View.INVISIBLE
            } else {
                network_error_text.visibility = View.INVISIBLE
                network_error_button.visibility = View.INVISIBLE
                scrolling_recycler.visibility = View.VISIBLE
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrolling_recycler.layoutManager = LinearLayoutManager(requireContext())
        network_error_button.setOnClickListener { viewModel.onNetworkErrorClicked() }
    }
}