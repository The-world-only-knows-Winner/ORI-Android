package com.onlywin.ori_android

import android.app.Application
import com.onlywin.data.datasource.auth.AuthDataSource
import com.onlywin.data.datasource.auth.AuthDataSourceImpl
import com.onlywin.data.repository.AuthRepositoryImpl
import com.onlywin.data.utils.getAuthApi
import com.onlywin.domain.repository.AuthRepository
import com.onlywin.ori_android.viewmodel.SignInViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ORIApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val apiModule = module {
            single { getAuthApi() }
        }

        val dataSourceModule = module {
            single<AuthDataSource> { AuthDataSourceImpl(get()) }
        }

        val repositoryModule = module {
            single<AuthRepository> { AuthRepositoryImpl(get()) }
        }

        val viewModelModule = module {
            single { SignInViewModel(get()) }
        }

        startKoin {
            modules(
                listOf(
                    apiModule,
                    dataSourceModule,
                    repositoryModule,
                    viewModelModule,
                )
            )
        }
    }
}