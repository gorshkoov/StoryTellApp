package app.storytel.gorshkov.storytellapp.di

import app.storytel.gorshkov.storytellapp.features.scrolling.ScrollingFragment
import app.storytel.gorshkov.storytellapp.features.scrolling.ScrollingViewModel
import app.storytel.gorshkov.storytellapp.features.scrolling.repository.ScrollingRepository
import app.storytel.gorshkov.storytellapp.features.scrolling.repository.ScrollingRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val scrollingModule = module {
    scope<ScrollingFragment> {
        scoped { ScrollingRepositoryImpl(get()) as ScrollingRepository }
        viewModel { ScrollingViewModel(get()) }
    }
}