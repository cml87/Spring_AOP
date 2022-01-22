# Spring AOP
In this project I will put my notes about Spring AOP. It will include notes from the following courses:
- <span style="color:aquamarine">Spring Framework: Aspect Oriented Programming with Spring AOP</span>, by Catalin Tudose. **pluralsight**

The course will cover:
- What is Aspect Oriented Programming, AOP
- Introducing Spring AOP
- Implementing cross-cutting concerns for normal execution using Spring AOP
- Implementing crosscutting concerns for cashing and exceptions using Spring AOP
- Using Spring AOP introductions

Spring AOP is all about separating the real business problem from the cross-cutting functionalities. Cross-cutting functionalities are functionalities commonly needed in our code, regardless of the specific business logic being performed. Example of cross-cutting concerns are:
1. logging: always present in our methods body
2. exceptions handling: business methods will throw exceptions because of the operations they need to do. Eg. sql exceptions if they work with a db
3. user rights check: some users of our app may not be authorized to call some methods
4. caching: we don't want to call again the db for data that has been retrieved recently
5. transactions
6. tweaking legacy applications

For example:
```java
publica static Passenger getPassenger (int id){
    if (!SecurityContext.hasRight("getPassenger")){
        throw new RuntimeException("Permission denied!");
    }
    log.debug("Call method getPassenger with id " + id);
    Passenger passenger;
    try {
        if (cache.contains(id)){
            passenger = cache.get(id);
        } else {
            passenger = Database.getPassenger(id);
            cache.put(id,passenger);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    log.debug("Passenger info: " + passenger.toString());
    return passenger;
}    
```
With AOP we take all these cross-cutting logic and move it separate classes called "aspects". In general, an aspect does something before (eg. a log message) a method, the runs the method, then does something after the method (eg. another log). Logging is a classical example of an aspect, it is "logging aspect". It is an example of orthogonal or cross-cutting concern in Java applications.

Spring implements AOP in two ways:
1. Schema based approach, which uses regular classes
2. AspectJ approach, which uses regular classes annotated with the aspect annotations

## Key AOP terms

What we do before the main function is called a `@Before` advice, and that made after, an `@After` advice.
```java
public static Passenger getPassenger(int id) {
    log.debug("Call method getPassenger with id " + id);  // @Before advice
    Passenger passenger = Database.getPassenger(id);
    log.debug("Passenger info: " + passenger.toString()); // @After advice
    return passenger;
}
```
The more important AOP concepts are:
- Join point: effective execution of a method, where the aspect will be applied.
- Advice: the action taken by an aspect at a particular join point. There are different types, such as @Before, @After, @Around, @AfterReturning, @AfterThrowing. Spring AOP may create chain of advices for one single join point. 
- Pointcut: a predicate that matches join points. An advice is associated with a pointcut expression and runs at any join point matching that point cut, for example, the execution of a method with a certain name.
  
- Target object: the object being advised by one or more aspects. Spring AOP will create a runtime proxy for the target object in order to add the aspect to the execution.
- Introduction: used to declare additional methods, or fields, for a given class. Spring AOP makes possible the advised object to receive new interfaces to implement. We can have a given class that receive additional behaviour at runtime with the help of Introductions.
- AOP Proxy: the object created by the AOP framework so that it can add the aspects in the execution. Spring AOP provides two ways to create the AOP proxy: 
  1. JDK dynamic proxy, which is the standard mechanism of proxy creation. 
  2. Code Generation Library (CGLIB) proxy.
- Weaving: operation of program transformation that applies the aspect to the target object in order to create the advice object. Spring AOP performs weaving at runtime.

![image info](./pictures/weaver.jpg)

## XML based Spring AOP

