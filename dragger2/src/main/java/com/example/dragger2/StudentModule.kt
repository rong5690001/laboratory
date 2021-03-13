package com.example.dragger2

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StudentModule {
//
    @Singleton
    @Provides
    fun getStudent(name:String, age:Int): Student {
        return Student(name, age)
    }

    @Provides
    fun getName(): String {
        return "name"
    }

    @Provides
    fun getAge():Int{
        return 99
    }
}