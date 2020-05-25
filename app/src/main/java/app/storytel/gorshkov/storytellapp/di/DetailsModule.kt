package app.storytel.gorshkov.storytellapp.di

import app.storytel.gorshkov.storytellapp.features.details.DetailsFragment
import app.storytel.gorshkov.storytellapp.features.details.DetailsViewModel
import app.storytel.gorshkov.storytellapp.features.details.repository.CommentsRepository
import app.storytel.gorshkov.storytellapp.features.details.repository.CommentsRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    scope<DetailsFragment> {
        scoped { CommentsRepositoryImpl(get()) as CommentsRepository }
        viewModel { (postId: Int) -> DetailsViewModel(postId, get())}
    }
}