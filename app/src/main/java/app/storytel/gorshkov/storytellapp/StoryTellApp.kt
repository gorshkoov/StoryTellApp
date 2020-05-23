package app.storytel.gorshkov.storytellapp

import android.app.Application
import app.storytel.gorshkov.storytellapp.di.*
import com.github.ajalt.timberkt.Timber
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class StoryTellApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@StoryTellApp)
            modules(
                appModule,
                retrofitModule,
                servicesModule,
                detailsModule,
                scrollingModule
            )
        }
    }
}