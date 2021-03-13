package com.example.dragger2.command;

import dagger.Component;

@Component(modules = {CommandModule.class, SystemOutModule.class})
interface CommandRouterFactory {
    CommandRouter router();
}