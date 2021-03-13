package com.example.dragger2.command;

import dagger.Module;
import dagger.Provides;

@Module
abstract class SystemOutModule {
    @Provides
    static Outputter textOutputter() {
        return System.out::println;
    }
}
