package app.storytel.gorshkov.storytellapp.di

import app.storytel.gorshkov.storytellapp.features.scrolling.ScrollingFragment
import org.koin.core.qualifier.named
import org.koin.dsl.module

val scrollingModule = module {
    scope(named<ScrollingFragment>()) {

    }
}