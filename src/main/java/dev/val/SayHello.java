package dev.val;

import java.util.ResourceBundle;

public class SayHello {
    public static String greet(){
        ResourceBundle rd = ResourceBundle.getBundle("langages");

        String configuredLangage = rd.getString("configured_language").trim();

        if(!rd.containsKey(configuredLangage + "_hello_world") && !configuredLangage.isEmpty()){
            System.out.println("Langage unavailable!");
            System.out.println("Native langage selected by default!");
            configuredLangage = "";
        }

        String configuredMessage = configuredLangage.isEmpty() ? "" : rd.getString(configuredLangage + "_hello_world");
        String nativeMessage = rd.getString("native_hello_world");
        
        return configuredMessage.isEmpty() ? nativeMessage : configuredMessage;
        }
}