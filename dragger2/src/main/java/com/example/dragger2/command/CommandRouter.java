package com.example.dragger2.command;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

final class CommandRouter {
    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    CommandRouter(Command helloWorldCommand) {
        commands.put(helloWorldCommand.key(), helloWorldCommand);
    }

//    @Inject
//    CommandRouter(HelloWorldCommand helloWorldCommand) {
//        commands.put(helloWorldCommand.key(), helloWorldCommand);
//    }
}
