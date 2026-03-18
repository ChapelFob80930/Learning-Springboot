package com.sarbo.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

// Marks this class as a Spring-managed service bean
// Automatically detected via component scanning
@Service
// Loads additional property files into Spring Environment
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {

//    @Autowired
//    @Qualifier("bean1")

// 🔑 DEPENDENCY
// This is a Spring Bean that will be injected
    private MyFirstClass myFirstClass;

    // 🔑 @Autowired:
    // - Tells Spring to automatically inject required dependencies
    // - Spring looks into ApplicationContext and finds a matching bean
    // - Works with constructor, setter, or field injection

    // 🔑 CONSTRUCTOR INJECTION (BEST PRACTICE)
    // - Spring injects dependency via constructor
    // - @Qualifier specifies WHICH bean to inject (bean2)
    // - Used when multiple beans of same type exist
    @Autowired
    public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    // Business method using injected dependency
    public String tellAStory(){
        return "the dependency is saying : " + myFirstClass.sayHello();
    }

    // 🔑 PROPERTY INJECTION USING @Value

    // Injects value from properties file: my.prop=value
    @Value("${my.prop}")
    private String customProperty;

    // Injects another property
    @Value("${my.prop.2}")
    private String customProperty2;

    // Injects from custom property file
    @Value("${my.custom.property}")
    private String customProperty3;

    // Getters to access injected properties
    public String getCustomProperty() {
        return customProperty;
    }

    public String getCustomProperty2() {
        return customProperty2;
    }


    public String getCustomProperty3() {
        return customProperty3;
    }

    // 🔑 KEY CONCEPTS:

    // Dependency Injection (DI):
    // - Spring provides required objects instead of manual creation
    // - Promotes loose coupling and easier testing

    // Constructor Injection (Preferred):
    // - Ensures dependency is available at object creation
    // - Makes class immutable and safer

    // @Qualifier:
    // - Required when multiple beans of same type exist
    // - Explicitly selects the correct bean

    // @Value:
    // - Injects values from properties files into variables

    // @PropertySource(s):
    // - Adds external property files to Spring Environment
    // - Useful for custom configs

    // ⚠️ Other Injection Types (commented above):
    // - Field Injection (@Autowired directly on variable) ❌ not recommended
    // - Setter Injection ✔️ optional dependencies

    // 🔥 Best Practice:
    // - Always prefer constructor injection over field/setter injection


// =========================================================
    // 🔽 ALTERNATIVE INJECTION METHODS (COMMENTED OUT)
    // =========================================================

    // ❌ FIELD INJECTION (NOT RECOMMENDED)
    // - Injects dependency directly into field
    // - Hard to test (no constructor control)
    // - Not immutable
//    @Autowired
//    @Qualifier("bean1")
//    private MyFirstClass myFirstClass;

    // ⚠️ SETTER INJECTION (OPTIONAL DEPENDENCIES)
    // - Dependency injected after object creation
    // - Useful if dependency is optional or changeable
//    @Autowired
//    public void setMyFirstClass(@Qualifier("bean1") MyFirstClass myFirstClass){
//        this.myFirstClass = myFirstClass;
//    }

    // ⚠️ GENERIC METHOD INJECTION
    // - Similar to setter injection but with custom method name
//    @Autowired
//    public void injectDependencies(@Qualifier("mySecondBean") MyFirstClass myFirstClass)
//    {
//        this.myFirstClass = myFirstClass;
//    }

    // ❌ NO ANNOTATION CONSTRUCTOR (NOT USED BY SPRING AUTOMATICALLY)
    // - Without @Autowired (in older Spring versions), this constructor is ignored
//    public MyFirstService(MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

    // =========================================================
    // 🔽 ENVIRONMENT-BASED PROPERTY ACCESS (COMMENTED OUT)
    // =========================================================

    // Spring Environment object gives access to all properties
//    private Environment environment;

    // Inject Environment object
//    @Autowired
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//    }

    // Reading system property (Java version)
//    public String getJavaVersion(){
//        return environment.getProperty("java.version");
//    }

    // Reading OS name
//    public String getOsName(){
//        return environment.getProperty("os.name");
//    }

    // Reading custom property manually
//    public String readProp(){
//        return environment.getProperty("my.custom.property");
//    }

    // =========================================================
    // 🔑 SUMMARY
    // =========================================================

    // @Autowired → tells Spring to inject dependencies automatically
    // Constructor Injection → best practice (used here)
    // @Qualifier → resolves multiple beans
    // @Value → injects property values
    // @PropertySource → loads external property files


}
