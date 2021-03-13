package com.example.dragger2

import dagger.Component
import javax.inject.Inject
import javax.inject.Scope

/**
 * Dagger 中的作用域限定：
 * 您可以使用作用域注释将某个对象的生命周期限定为其组件的生命周期。这意味着，每次需要提供该类型时，都会使用依赖项的同一实例。
 */

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class MyCustomScope()

@MyCustomScope
class MyCustomScope_ViewModel @Inject constructor()

@MyCustomScope
@Component
interface MyCustomScope_Component {
    fun viewModel(): MyCustomScope_ViewModel
}

fun main() {
    //MyCustomScope_Component的生命周期内，只会有一个MyCustomScope_ViewModel对象实例
    val component = DaggerMyCustomScope_Component.create()
    println(component.viewModel().toString())
    println(component.viewModel().toString())
    println(DaggerMyCustomScope_Component.create().viewModel().toString())

    /**
     * 运行结果：
        com.example.dragger2.MyCustomScope_ViewModel@5e481248
        com.example.dragger2.MyCustomScope_ViewModel@5e481248
        com.example.dragger2.MyCustomScope_ViewModel@66d3c617
     */

}