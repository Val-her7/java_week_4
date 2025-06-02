package dev.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class CommandHospitalService {
    private Map<String, HospitalCommand> commandMap;

    @Autowired
    public CommandHospitalService(List<HospitalCommand> commandList) {
        this.commandMap = commandList.stream()
                .collect(Collectors.toMap(HospitalCommand::getName, command -> command));
    }

    public void executeHospitalCommand(String commandName){
        HospitalCommand command = commandMap.get(commandName);

        if(command != null){
            command.execute();
        }
        else{
            System.out.println("Invalid command!");
        }
    }
}