# spring-6-certification-code-snippets

## Creating Unit Tests for dependent classes using stubs and mocks

Testing an independent class is easy, because you don't have to consider how it's dependencies work and how to set them up properly.
Although when testing a class that depends on the output of other classes or services (eg. database or network services), it is a little more tricky.

If we consider the AccountService interface in the service layer, this service is implemented by the SimpleAccountService class and depends on the 
AccountDao object in the persistence layer to persist the account objects.

The InsufficientBalanceException is a subclass of the RuntimeException class and is thrown by the withdraw method of the AccountService interface when the 
amount to be withdrawn is greater than the balance of the account.

A common technique used in unit testing to reduce complexity caused by dependencies is to use stubs. A stub must implement the same interface as the target object so that it can substitute for the target object.
By creating a stub for the AccountDao that stores a single customer account and implements the findAccount() and updateAccount() methods since it is required for the deposit() and withdraw() methods.

## Mockito

Writing stubs requires alot of coding and is not a very efficient way of testing. Mockito is a mocking framework that allows you to create mock objects dynamically at runtime.
The Mockito library dynamically creates mock objects that work in a record/playback mechanism similar to EasyMock. 
