package com.codingjourney.backend.basic.springbootStartJourney;

public class BeanLearning {
    /*
    * =>> Beans can be created in two ways.
    *  1. by using @Component annotation.
    *  2. by using @Configuration annotation with @Bean annotation.
    *
    *
    * ==============================================================================================================
    *                                       Life cycle of Beans
    *
    * -> it means beans goes through different life cycles before it is being destroyed.
    * -> creation a bean and destroy a bean is done by spring framework.
    *
    * ==> Following steps are taking for Life cycle of Beans :-
    * a. Bean Creation :- (1st step)
    *  -> bean is being created, at bean creation steps.
    *  -> the bean instance is created by invoking :-
    *     > static method factory method or
    *     > an instance factory method ( for annotation - based configuration).
    *
    * b. After creation of bean, dependency is being injected (Dependency Injected) :-
    *  -> spring sets the bean's properties and dependency either through setter
    *      injection, constructor injection or field injection.
    *
    * c. later on bean will be initialized ( Bean Initialized) :-
    *  -> here bean is being ready to use.
    *  -> if the bean implements the initializingBean interface or define a custom Initialization method
    *       annotated with @PostConstruct, spring invokes the initialization method after the bean
    *       has been configured.
    *
    * d.Now Bean is being used (Bean is Used) :-
    *   -> the bean is fully initialized and ready to be used by application.
    *
    *
    * e.Bean Destroyed :-
    *  -> spring invokes the destruction method when bean is no longer needed or when application
    *   context is being shut down.
    *
    *
    *
     * ==============================================================================================================
     *                                          Bean LifeCycle Hooks
     *
     * -> The @PostConstruct annotation is used to mark a method that should be invoked immediately after a bean
     *      has been constructed and all of its dependency have been injected.
     *
     * -> The @PreDestroy annotation is used to mark a method that should be invoked just before bean is destroyed
     *      by the container. this method can perform any necessary cleanup or resource releasing tasks.
     *
     *
     * ==============================================================================================================
     *                                          Scope of Beans
     * 1. singleton :- (Default)
     *  -> scopes a single bean definition to a single object instance for each spring IOC container.
     *
     * 2. prototype :-
     * -> Scopes a single bean definition to any number of object creation.
     *
     * 3. request :-
     * -> scopes a single bean definition to the lifecycle of single HTTP request.that is, each Http request
     *      has its own instance of a bean created off the back of a single bean definition.only valid in
     *      the context of s web-aware spring application context.
     *
     *
     *
     * ==============================================================================================================
     *                                          Dependency Injection
     *
     * -> Dependency Injection (DI) in the context of the Spring Framework is a design pattern and
     *    technique used to achieve loose coupling between components in a software application.
     *    In a DI scenario, instead of a component creating its dependencies directly, the dependencies are injected
     *    into the component from an external source, typically managed by a framework like Spring.
     *
     * Benefits of Dependency Injection : ===>
     * 1. Loose Coupling:
     *          Components are decoupled from their dependencies,making them easier to maintain and test.
     * 2. Flexible Configuration:
     *          Dependencies can be configured externally,allowing for easier customization and swapping of components.
     * 3. Improved Testability:
     *          Components can be easily mocked or replaced during testing, allowing for more thorough and
     *           isolated unit tests.
     *
     * =============================>  How to Inject Dependencies  <================================================
     *
     * 1.Constructor Injection :-
     *      Dependencies are provided through a class constructor.
     * 2.Field Injection :-
     *      Dependencies are provided directly into the fields of a class using @Autowired annotation.
     *
     *
     *
     * =============================>  pom.xml  <================================================
     *-> Maven is a popular build automation tool used in many Java projects. In a Spring Boot project,
     *    dependencies are specified in the pom.xml file. Maven then resolves these dependencies and
     *    includes them in the classpath.
     *
     * -> Starters like spring-boot-starter-parent include a ton of third party libraries into your
     *    project - by default. Its AutoConfigurations use these dependencies to setup and preconfigure
     *     these libraries automatically.
     *
     * -> The spring-boot-dependencies pom.xml contains every 3rd party library (and version) that Spring Boot knows.
     *  These libraries are predefined in a dependenciesManagement section, so you do not need to specify
     *  the version numbers in your own project, anymore.
     *
     * =============================>  What is Auto Configuration <================================================
     * -> Autoconfiguration refers to the mechanism that automatically configures Spring applications based on the
     * dependencies present on the classpath and other application-specific settings.
     *
     * -> This feature simplifies the setup and development process, allowing developers to focus more on writing
     * business logic rather than configuring the framework.
     *
     *
     * ====================    How Autoconfiguration Works    ====================================
     * --> 1.Classpath Scanning :-
     *  Spring Boot scans the classpath for the presence of certain libraries and classes.Based on what it finds, it
     *  applies corresponding configurations.
     *
     * --> 2.Configuration Classes :-
     *  Spring Boot contains numerous autoconfiguration classes, each responsible for configuring a specific
     *  part of the application.
     *
     * --> 3.Conditional Beans :-
     *  Each autoconfiguration class uses conditional checks to decide if it should be applied. These
     *  conditions include the presence of specific classes, the absence of user-defined beans, and
     *   specific property settings.
     *
     *
     * ====================    Core Features of AutoConfiguration   ====================================
     *
     * ->1. @PropertySources Auto-registration :-
     *  When you run the main method of your Spring Boot Application, Spring Boot will automatically register 17 of
     * the PropertySources for you.
     *
     * -> 2. METAINF / spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
     *  Every Spring Boot project has a dependency on the following
     *  library: org.springframework.boot:spring-boot-autoconfigure. It is a simple .jar file containing
     *  pretty much all of Spring Boot’s magic.
     *
     * -> 3. Enhanced Conditional Support
     *  Spring Boot comes with its own set of additional @Conditional annotations, which make developers' lives easier.
            ○ @ConditionalOnBean(DataSource.class). The condition is true
            only if the user specified a DataSource @Bean in a
            @Configuration.
            ○ @ConditionalOnClass(DataSource.class). The condition is true
            if the DataSource class is on the classpath.
            ○ @ConditionalOnProperty("my.property"). The condition is true
            if my.property is set.
     *
     *
     *
     * ====================    Spring Boot Internal Flow   ====================================
     *
     * 1. Initialization: When you start a Spring Boot application, the main entry point is typically
     *  a class annotated with @SpringBootApplication (or its meta-annotations). This annotation
     *  combines several other annotations such as @Configuration, @EnableAutoConfiguration, and @ComponentScan.
     *
     * 2. Spring Application Context Creation: Spring Boot creates an application context, which serves
     *  as the container for managing beans and their dependencies. It scans the classpath for components,
     * configurations, and auto-configurations, and initializes the application context based on the
     *  detected classes and dependencies.
     *
     * 3. Auto-Configuration: Spring Boot auto-configures beans and components based on the classpath
     *  and detected dependencies. It uses conditional annotations (@ConditionalOnClass, @ConditionalOnBean,
     *  etc.) to conditionally configure beans only if certain conditions are met.
     *
     * 4. Externalized Configuration: Spring Boot loads configuration properties from various sources,
     *   such as property files, YAML files, environment variables, and command-line arguments. It provides
     *  sensible default values for configuration properties and allows them to be easily overridden or customized.
     *
     * 5. Embedded Web Server Initialization: If the application is a web application,
     *  Spring Boot initializes the embedded web server (such as Tomcat, Jetty, or Undertow)
     *  based on the application's dependencies and configurations. It configures the server with sensible
     *  defaults and starts it to listen for incoming requests.
     *
     *6. Application Startup: Spring Boot invokes lifecycle callbacks such as @PostConstruct methods and
     *   initialization callbacks on beans as the application context is being initialized. Beans are
     *  instantiated, dependencies are injected, and any necessary initialization logic is executed.
     *
     * 7. Application Ready: Once the initialization process is complete, the application context
     *  is fully initialize and ready to handle requests. The embedded web server is up and running,
     *   and the application is ready to serve incoming HTTP requests.
     *
     * */
}
