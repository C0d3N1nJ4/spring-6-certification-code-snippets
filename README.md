# spring-6-certification-code-snippets

AOP with Annotations

Define an aspect by decorating a class with the @Aspect annotation.
The methods in this class are called advices and are executed when a join point is reached. 
Advice methods are annotated with the following annotations from AspectJ:
- @Before
- @After
- @AfterReturning
- @AfterThrowing
- @Around
- @Pointcut
- @DeclareParents

The @Before advice is executed before the join point is reached.
The @After advice is executed after the join point is reached.
The @AfterReturning advice is executed after the join point is reached and the method returns normally.
The @AfterThrowing advice is executed after the join point is reached and the method throws an exception.
The @Around advice is executed before and after the join point is reached.
The @Pointcut annotation defines a pointcut expression that can be used by advice annotations.
The @DeclareParents annotation is used to introduce new functionality to a class.

To enable annotation support in the Spring IoC container, add @EnableAspectJAutoProxy to a configuration class.
To apply AOP, Spring creates a proxy object that wraps the bean to which the aspect is applied and by default uses JDK dynamic proxies that are based on interfaces.
For scenarios where interfaces are not available, use CGLIB proxies and set the proxyTargetClass attribute of the @EnableAspectJAutoProxy annotation to true.

To support AOP with annotations, Spring uses AspectJ annotations. AspectJ is a framework that provides a declarative language for defining aspects and weaving them into the application code as well as for pointcut parsing and matching.
Although AOP with annotations is supported by Spring, it is not a Spring-specific feature. It is a feature of AspectJ that Spring supports so Spring AOP is not dependent on the AspectJ compiler or weaver.

