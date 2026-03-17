package com.sarbo.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {

//    @Autowired
//    @Qualifier("bean1")
    private MyFirstClass myFirstClass;

    @Autowired
    public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying : " + myFirstClass.sayHello();
    }


    @Value("${my.prop}")
    private String customProperty;

    @Value("${my.prop.2}")
    private String customProperty2;

    @Value("${my.custom.property}")
    private String customProperty3;

    public String getCustomProperty() {
        return customProperty;
    }

    public String getCustomProperty2() {
        return customProperty2;
    }


    public String getCustomProperty3() {
        return customProperty3;
    }



//    @Autowired
//    public void setMyFirstClass(@Qualifier("bean1") MyFirstClass myFirstClass){
//        this.myFirstClass = myFirstClass;
//    }






//    @Autowired
//    public void injectDependencies( @Qualifier("mySecondBean") MyFirstClass myFirstClass)
//    {
//        this.myFirstClass = myFirstClass;
//    }


//    public MyFirstService(MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

//    private Environment environment;

    //    @Autowired
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//    }

//    public String getJavaVersion(){
//        return environment.getProperty("java.version");
//    }
//
//    public String getOsName(){
//        return environment.getProperty("os.name");
//    }
//
//    public String readProp(){
//        return environment.getProperty("my.custom.property");
//    }


}
