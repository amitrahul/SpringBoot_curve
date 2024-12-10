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
     * */
}
