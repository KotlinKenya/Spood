package app.spood

import android.app.Application
import app.spood.common.screens.signUp.*
import app.spood.common.screens.signUp.effect.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SpoodApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private val appModule = module {
        single { SignUpReducer() }
        single {
            val effects = listOf(
                SignUpValidationEffect(),
                SignUpNetworkingEffect()
            )
            SignUpStore(get(), effects)
        }
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@SpoodApp)
            modules(appModule)
        }
    }
}