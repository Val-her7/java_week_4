package dev.val;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dev.val")
public class App 
{
    public static void main( String[] args )
    {  
        ApplicationContext context  = new AnnotationConfigApplicationContext(App.class);
        
        for(String bean: context.getBeanDefinitionNames()){
            System.out.println(bean);
        }
        Car myCar = context.getBean(Car.class);
        myCar.drive();

        Dev me = context.getBean(Dev.class);
        me.build();
        
    }
}
