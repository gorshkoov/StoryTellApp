package app.storytel.gorshkov.storytellapp.features.details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import app.storytel.gorshkov.storytellapp.R
import app.storytel.gorshkov.storytellapp.base.BaseFragment
import app.storytel.gorshkov.storytellapp.features.details.adapter.CommentsAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.ext.scope

class DetailsFragment : BaseFragment() {
    private val args: DetailsFragmentArgs by navArgs()

    private val viewModel: DetailsViewModel by scope.viewModel(this) {
        parametersOf(args.postId)
    }

    override val layoutRes = R.layout.fragment_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.commentsViewModel.observe(viewLifecycleOwner, Observer {
            appbar.visibility = View.VISIBLE
            comments_recycler.adapter = CommentsAdapter(it)
        })
        viewModel.progressLiveData.observe(viewLifecycleOwner, Observer {
            progress_bar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            network_error_wrapper.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comments_recycler.layoutManager = LinearLayoutManager(requireContext())
        Picasso.get()
            .load(args.imageUrl)
            .into(backdrop_image)
        toolbar.title = args.postTitle

        network_error_button.setOnClickListener { viewModel.onNetworkErrorClicked() }
    }
}