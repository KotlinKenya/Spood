package app.spood

import android.app.Application
import app.spood.domain.usecase.SignUpUseCase
import app.spood.screens.signUp.SignUpStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SpoodApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private val appModule = module {
        single { SignUpUseCase() }
        single { SignUpStore(get()) }
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@SpoodApp)
            modules(appModule)
        }
    }
}