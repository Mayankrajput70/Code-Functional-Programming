# Code-Functional-Programming

## FUNCTIONAL PROGRAMMING

Functional programming is something that existed for much longer than object oriented, dating back to the ancient days of Turing machines. It has seen ebbs and flows in popularity over time, based on whatever programming language and its foundational paradigms have taken over as part of the developer’s toolkit. For a long time, object oriented thinking has dominated the community. It’s one of the first things taught in Computer Science degrees and most talked about when it comes to learning programming.

It cannot depend on any hidden state or global variables. The evaluation of the function should not cause any side effects, such as mutation of mutable objects or output to I/O devices or modify any fields outside of the function scope. And it does not modify its input parameters.

## Functional programming vs Object-oriented programming :-

It’s important to compare these programming ways to identify the differences and identify correct usage of functional programming. Primary concern of functional programming is not ‘ how to do it ’ but rather ‘ what to do ’. Major difference could be identified as using the declarative programming model in functional programming rather than it’s competitor’s imperative programming model.


## Functional Programming is based on Lambda Calculus :-

Lambda calculus is a framework developed by Alonzo Church to study computations with functions. It can be called the smallest programming language in the world. It gives the definition of what is computable. Anything that can be computed by lambda calculus is computable. It is equivalent to the Turing machine in its ability to compute. It provides a theoretical framework for describing functions and their evaluation. It forms the basis of almost all current functional programming languages. 

## Pure Functions :-

A function is called a pure function if it always returns the same result for same argument values and it has no side effects like modifying an argument (or global variable) or outputting something. The only result of calling a pure function is the return value. Examples of pure functions are strlen(), pow(), sqrt() etc. Examples of impure functions are printf(), rand(), time(), etc.

## Example :-

		__attribute__ ((pure)) return-type fun-name(arguments1, …)
		{
                 /* function body */
                }

## 1. Liskov Substitution Principle
    > If S is a subtype of T, then objects of type T in a program may be replaced with objects of type S without altering 
    any of the desirable properties of that program.

- When a child Class cannot perform the same actions as its parent Class, this can cause bugs.
- If you have a Class and create another Class from it, it becomes a parent and the new Class becomes a child. The child Class should be able to do everything the     parent Class can do. This process is called Inheritance.
- The child Class should be able to process the same requests and deliver the same result as the parent Class or it could deliver a result that is of the same type.
  
## Let's take A Look How We Can Impl It in Functional Programming
   
  # Account.scala
       package com.knoldus.LSP
       abstract class Account(var amount: Double)

  # CurrentAccount,scala
       package com.knoldus.LSP
       class CurrentAccount(var name: String, var amount1: Double) extends Account(amount1)
  
  # Printer.scala 
       package com.knoldus.LSP
       case class Printer(message: String) {
       def printMessage = println(message)
       }
       
  # SavingAccount.scala
       package com.knoldus.LSP
       class SavingAccount(var name: String, var amount1: Double) extends Account(amount1)
  
  # TestLsp.scala
       object TestLSP {
       val withdraw = (account: Account, amount:Double)=>{
       account.amount = account.amount - amount
       "ALERT: You've withdrawn Rs. " + amount + " Available Bal Rs.  " + account.amount
       }
       val deposit = (account: Account, amount:Double)=>{
       account.amount = account.amount + amount
       "UPDATE: Rs. " + amount + " has been deposited into your account. Avl Bal INR " + account.amount
    
  # Output :-
       ALERT: You've withdrawn Rs. 1500.0 Available Bal Rs.  43500.89
       ALERT: You've withdrawn Rs. 2000.0 Available Bal Rs.  28000.23
       UPDATE: Rs. 1000.0 has been deposited into your account. Avl Bal INR 44500.89
    
# Experience of functional Programming
In functional programming approach we code less but do more in programming or to execute a task.

## 2. Interface Segregation principle
Clients should not be forced to depend on methods that they do not use.

We made functions related to coffee shop in CoffeeShop class and functions related to customer in Customer class

# Functional programming appraoch

   # CallingRect.scala
        package com.knoldus.ISP
        object CallingRect {
        def main(args: Array[String]): Unit = {
        val rect = new Rectangle(x = 0, y = 3, width = 3, height = 2)
        rect.description
	}
       }

   # DEscription.scala
        trait Description {
        def description: String
	}
        trait Coordinates extends Description {
        def x: Int
	def y: Int
	def description: String ="Coordinates (" + x + ", " + y + ")"
	}
	trait Area {
	def area: Double
	}
	class Rectangle(val x: Int,
                val y: Int,
                val width: Int,
                val height: Int)
	extends Coordinates with Description with Area {
	val area: Double = width * height
	println("The area of rectangle is " + area)
	override def description: String =super.description + " - Rectangle " + width + " * " + height
	}
	  class Square(val width:Int) extends Area {
	  override def area: Double = width * width
	  println("The area of square is " + area)
	}
	
   # Output :-
        The area of rectangle is 6.0
	
## 3. Dependency Inversion
   - High-level modules should not depend on low-level modules. Both should depend on the abstraction.
   - Abstractions should not depend on details. Details should depend on abstractions.
    
     1. High-level Module(or Class): Class that executes an action with a tool.
     2. Low-level Module (or Class): The tool that is needed to execute the action.
     3. Abstraction: Represents an interface that connects the two Classes.

## Code implementation of DIP

  # Cappuccino.scala
        class Cappuccino extends CoffeeMaker {
	override def makeCoffee(): String = {
	"Makes a Cappuccino"
        }
       }

  # CoffeeMaker.scala
       trait CoffeeMaker {
       def makeCoffee(): String
       }

  # CoffeeServer.scala 
       class CoffeeServer {
       def serveCoffee(coffee:CoffeeMaker): Unit ={
       val cup = coffee.makeCoffee()
       println(cup)
       }
      }

      object Main extends App{
      val serve = new CoffeeServer
      serve.serveCoffee(new Cappuccino)
      serve.serveCoffee(new Latte)
      } 
       
  # Latte.scala
       class Latte extends CoffeeMaker {
       override def makeCoffee(): String = {
       "Makes a Latte"
       }
      }
    
  # Output :-
       Makes a Cappuccino
       Makes a Latte
