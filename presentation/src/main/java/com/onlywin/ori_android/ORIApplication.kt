package com.onlywin.ori_android

import android.app.Application
import com.onlywin.data.datasource.auth.local.LocalAuthDataSource
import com.onlywin.data.datasource.auth.local.LocalAuthDataSourceImpl
import com.onlywin.data.datasource.auth.remote.RemoteAuthDataSource
import com.onlywin.data.datasource.auth.remote.RemoteAuthDataSourceImpl
import com.onlywin.data.repository.AuthRepositoryImpl
import com.onlywin.data.utils.ORIInterceptor
import com.onlywin.data.utils.getAuthApi
import com.onlywin.domain.repository.AuthRepository
import com.onlywin.ori_android.viewmodel.SignInViewModel
import okhttp3.Interceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ORIApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val apiModule = module {
            single<Interceptor> { ORIInterceptor(get()) }
            single { getAuthApi(get()) }
        }

        val dataSourceModule = module {
            single<RemoteAuthDataSource> { RemoteAuthDataSourceImpl(get()) }
            single<LocalAuthDataSource> { LocalAuthDataSourceImpl(androidContext()) }
        }

        val repositoryModule = module {
            single<AuthRepository> {
                AuthRepositoryImpl(
                    remoteAuthDataSource = get(),
                    localAuthDataSource = get(),
                )
            }
        }

        val viewModelModule = module {
            single { SignInViewModel(get()) }
        }

        startKoin {
            androidContext(applicationContext)
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