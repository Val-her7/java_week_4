package dev.val;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import java.util.Arrays;

public class CommandHospitalServiceTest {

    private ReportCommand reportCommand;
    private RegisterCommand registerCommand;
    private CommandHospitalService commandHospitalService;

    @BeforeEach
    void setup(){

        reportCommand = mock(ReportCommand.class);
        when(reportCommand.getName()).thenReturn("report");

        registerCommand = mock(RegisterCommand.class);
        when(registerCommand.getName()).thenReturn("register");

        commandHospitalService = new CommandHospitalService(Arrays.asList(registerCommand, reportCommand));
    }

    @Test
    void testExecuteCommandRegister(){
        commandHospitalService.executeHospitalCommand("register");
        verify(registerCommand).execute();
    }

    @Test
    void testExecuteCommandReport(){
        commandHospitalService.executeHospitalCommand("report");
        verify(reportCommand).execute();
    }

    @Test
    void testExecuteInvalidCommand(){
        commandHospitalService.executeHospitalCommand("Invalid");
        verify(registerCommand, never()).execute();
        verify(reportCommand, never()).execute();
    }
}