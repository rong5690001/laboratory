package com.example.dragger2.command;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CommandModule {

    @Binds
    public abstract Command helloWorldCommand(HelloWorldCommand helloWorldCommand);

}
