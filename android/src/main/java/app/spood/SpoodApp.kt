package app.spood

import android.app.Application
import app.spood.screens.signUp.SignUpReducer
import app.spood.screens.signUp.SignUpStore
import app.spood.screens.signUp.effect.SignUpNetworkingEffect
import app.spood.screens.signUp.effect.SignUpValidationEffect
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