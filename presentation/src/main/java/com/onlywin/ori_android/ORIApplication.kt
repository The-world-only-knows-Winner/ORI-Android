package com.onlywin.ori_android

import android.app.Application
import com.onlywin.data.datasource.auth.local.LocalAuthDataSource
import com.onlywin.data.datasource.auth.local.LocalAuthDataSourceImpl
import com.onlywin.data.datasource.auth.remote.RemoteAuthDataSource
import com.onlywin.data.datasource.auth.remote.RemoteAuthDataSourceImpl
import com.onlywin.data.datasource.user.RemoteUserDataSource
import com.onlywin.data.datasource.user.RemoteUserDataSourceImpl
import com.onlywin.data.repository.AuthRepositoryImpl
import com.onlywin.data.repository.UserRepositoryImpl
import com.onlywin.data.utils.ApiProvider
import com.onlywin.data.utils.ORIInterceptor
import com.onlywin.domain.repository.AuthRepository
import com.onlywin.domain.repository.UserRepository
import com.onlywin.domain.usecase.auth.SendAuthCodeUseCase
import com.onlywin.domain.usecase.auth.VerifyAuthCodeUseCase
import com.onlywin.domain.usecase.user.SignUpUseCase
import com.onlywin.ori_android.viewmodel.SignInViewModel
import com.onlywin.ori_android.viewmodel.user.SignUpViewModel
import okhttp3.Interceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ORIApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val apiModule = module {
            single { ORIInterceptor(get()) }
            single { ApiProvider.getAuthApi(get()) }
            single { ApiProvider.getUserApi(get()) }
        }

        val dataSourceModule = module {
            single<RemoteAuthDataSource> { RemoteAuthDataSourceImpl(get()) }
            single<LocalAuthDataSource> { LocalAuthDataSourceImpl(androidContext()) }
            single<RemoteUserDataSource> { RemoteUserDataSourceImpl(get()) }
        }

        val repositoryModule = module {
            single<AuthRepository> {
                AuthRepositoryImpl(
                    remoteAuthDataSource = get(),
                    localAuthDataSource = get(),
                )
            }
            single<UserRepository> { UserRepositoryImpl(get()) }
        }

        val useCaseModule = module {
            single { SignUpUseCase(get()) }
            single { SendAuthCodeUseCase(get()) }
            single { VerifyAuthCodeUseCase(get()) }
        }

        val viewModelModule = module {
            single { SignInViewModel(get()) }
            single {
                SignUpViewModel(
                    signUpUseCase = get(),
                    sendAuthCodeUseCase = get(),
                    verifyAuthCodeUseCase = get()
                )
            }
        }

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    apiModule,
                    dataSourceModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}