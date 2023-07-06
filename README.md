# spring-6-certification-code-snippets

Create POJOs by invoking a constructor

Problem : 
You would like to create a POJO instance or bean in the Spring IoC container by invoking it's construcotr which is the most common and direct way of creating beans.
It is equivalent to using the new operator to create objects in Java.

Solution: 
1. Define a POJO class with a constructor or constructors.
2. Create a Java configuration class to configure POJO instance values with constructors for the Spring IoC container.
3. Instantiate the Spring IoC container to scan for Java classes with annotations. 
   The POJO instances or bean instances become accessible to the application.

Considerations:

Suppose you're going to develop a shop application to sell products online. Firstly, you create the Product class which has several properties such as the product name and price.
As there are many types of products in your shop, you make the Product class abstract to extend it for different product subclasses.
