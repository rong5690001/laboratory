package com.example.dragger2

import com.example.dragger2.manual_dependency_injection.LoginActivity
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    userRepository: UserRepository
)

class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
)

// @Inject lets Dagger know how to create instances of these objects
class UserLocalDataSource @Inject constructor()
class UserRemoteDataSource @Inject constructor()

@Subcomponent
interface SubComponent {
    fun inject(loginActivity: LoginActivity2)

    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): SubComponent
    }

}


@Module(subcomponents = [SubComponent::class])
class SubModule {
}


class LoginActivity2 {

    @Inject
    lateinit var loginViewModel: LoginViewModel

    fun test() {
        DaggerApplicationGraph.create().subComponent().create().inject(this)
        println("loginViewModel:${loginViewModel}")
    }
}


// @Component makes Dagger create a graph of dependencies
@Component(modules = [SubModule::class])
interface ApplicationGraph {
    // The return type  of functions inside the component interface is
    // what can be provided from the container
    fun repository(): UserRepository

    fun subComponent(): SubComponent.Factory
}

fun main() {
    LoginActivity2().test()
}