package com.example.dragger2.manual_dependency_injection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UserRepository constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
)

// @Inject lets Dagger know how to create instances of these objects
class UserLocalDataSource
class UserRemoteDataSource

class LoginUserData
class LoginViewModel(private val userRepository: UserRepository)

interface Factory<T> {
    fun create(): T
}

class LoginViewModelFactory(private val userRepository: UserRepository) : Factory<LoginViewModel> {

    override fun create(): LoginViewModel {
        return LoginViewModel(userRepository)
    }
}

//login flow container
class LoginContainer(userRepository: UserRepository) {

    val loginUserData = LoginUserData()
    val loginViewModelFactory = LoginViewModelFactory(userRepository)

}

object AppContainer {

    private val localDataSource: UserLocalDataSource = UserLocalDataSource()
    private val remoteDataSource: UserRemoteDataSource = UserRemoteDataSource()

    val userRepository = UserRepository(localDataSource, remoteDataSource)

    var loginContainer: LoginContainer? = null
}


class LoginActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    private var loginViewModel: LoginViewModel? = null
    private var loginData: LoginUserData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Login flow has started. Populate loginContainer in AppContainer
        AppContainer.loginContainer = LoginContainer(AppContainer.userRepository)

        loginViewModel = AppContainer.loginContainer?.loginViewModelFactory?.create()
        loginData = AppContainer.loginContainer?.loginUserData
    }

    override fun onDestroy() {
        // Login flow is finishing
        // Removing the instance of loginContainer in the AppContainer
        AppContainer.loginContainer = null
        super.onDestroy()
    }
}