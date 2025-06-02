package dev.val;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommandService {
    private Map<String, Command> commandMap;

    @Autowired
    public CommandService(List<Command> commandList) {
        this.commandMap = commandList.stream()
                .collect(Collectors.toMap(Command::getName, command -> command));
    }

    public void executeCommand(String commandName){
        Command command = commandMap.get(commandName);

        if (command != null){
            command.execute();
        }
        else{
            System.out.println("Invalid command");
        }
    }
}