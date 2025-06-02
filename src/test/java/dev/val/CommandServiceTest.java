package dev.val;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

public class CommandServiceTest {

    private Hello helloCommand;
    private Time timeCommand;
    private CommandService commandService;

    @BeforeEach
    void setup(){

        helloCommand = mock(Hello.class);
        when(helloCommand.getName()).thenReturn("hello");

        timeCommand = mock(Time.class);
        when(timeCommand.getName()).thenReturn("time");

        commandService = new CommandService(Arrays.asList(helloCommand, timeCommand));
    }

    @Test
    void testExecuteCommandHello(){
        commandService.executeCommand("hello");
        verify(helloCommand).execute();
    }

    @Test
    void testExecuteCommandTime(){
        commandService.executeCommand("time");
        verify(timeCommand).execute();
    }

    @Test
    void testExecuteUnknownCommand(){
        commandService.executeCommand("invalid");
        verify(helloCommand, never()).execute();
        verify(timeCommand, never()).execute();
    }
}