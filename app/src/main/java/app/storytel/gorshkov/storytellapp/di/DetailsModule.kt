package app.storytel.gorshkov.storytellapp.di

import app.storytel.gorshkov.storytellapp.features.details.DetailsFragment
import org.koin.core.qualifier.named
import org.koin.dsl.module

val detailsModule = module {
    scope(named<DetailsFragment>()) {

    }
}