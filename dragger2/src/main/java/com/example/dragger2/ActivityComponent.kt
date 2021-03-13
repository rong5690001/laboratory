package com.example.dragger2

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StudentModule::class])
interface ActivityComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}