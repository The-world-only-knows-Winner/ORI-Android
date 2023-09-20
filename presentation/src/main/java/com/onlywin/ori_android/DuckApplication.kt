package com.onlywin.ori_android

import android.app.Application
import com.onlywin.ori_android.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.module

class DuckApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val viewModelModule = module {
            viewModelOf(::SignInViewModel)
        }

        startKoin {
            modules(viewModelModule)
        }
    }
}