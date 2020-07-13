package impatient

// Title: Packages and Imports

// package object can hold constants, variables and functions
package object Chapter07 {
  val x = 10
  val y = 20
}

/////////////////////////////////////////////////////
// 1. Write an example program to demonstrate that //
//     package com.horstmann.impatient             //
// is not the same as                              //
//     package com                                 //
//     package horstmann                           //
//     package impatient                           //
/////////////////////////////////////////////////////


package Chapter07 {
  package foo {
    object FooSum {
      // x + y cames from Chapter07 package
      def apply() = x + y
    }
    package bar {
      object BarSumFromFoo {
        // available from package foo
        def apply() = FooSum()
      }
    }
  }
}

package Chapter07.foo.bar {
  object BarSum {
    // NOTE:
    // not available from package foo!
    // def sum() = FooSum.sum() // will fail

    // NOTE:
    // x and y not available directly too
    // use qualified name
    def apply() = Chapter07.x + Chapter07.y

  }
}

/////////////////////////////////////////////////////////////////////////
// 2. Write a puzzler that baffles your Scala friends, using a package //
// com that isn’t at the top level.                                    //
/////////////////////////////////////////////////////////////////////////

// LOL (?)
// NOTE: this will be avaiable as impatient.com, not com root
// this occurrs because the top-level statement: package impatient
package com {
  object LOL {
    def apply() = "LOL"
  }
}

////////////////////////////////////////////////////////////////////////////
// 3. Write a package random with functions nextInt(): Int, nextDouble(): //
// Double, and setSeed(seed: Int): Unit. To generate random numbers, use  //
// the linear congruential generator                                      //
//                                                                        //
//     next = (previous × a + b) mod 2n,                                  //
//                                                                        //
// where a = 1664525, b = 1013904223, n = 32, and the initial value of    //
// previous is seed.                                                      //
////////////////////////////////////////////////////////////////////////////


package Chapter07 {
  package object random {
    private var seed = 42
    val a = 1664525
    val b = 1013904223
    val n = 32

    def setSeed(seed: Int) {
      this.seed = seed
    }
    def nextInt(): Int = {
      val value = math.abs((seed * a + b) % math.pow(2, n).toInt)
      this.seed = value
      value
    }
    def nextDouble(): Double = {
      nextInt().toDouble
    }
  }
}


///////////////////////////////////////////////////////////////////////////
// 4. Why do you think the Scala language designers provided the package //
// object syntax instead of simply letting you add functions and         //
// variables to a package?                                               //
///////////////////////////////////////////////////////////////////////////

// Answer: To make isolated the problems tied with JVM package issues.
// package object generates a class with static fields and methods,
// different  of a package of itself that don't allow containing
// that. Allowing adding functions and variables to a package // will
// probably mess-up the rules at generating code for JVM.


////////////////////////////////////////////////////////////////////////////
// 5. What is the meaning of private[com] def giveRaise(rate: Double)? Is //
// it useful?                                                             //
////////////////////////////////////////////////////////////////////////////

// Answer: Can be useful. it's declare the method giveRaise private,
// unless if the client it's inside of the package com. It's like friend
// fields/methods in C++ but instead class friends, we have package
// friends.

///////////////////////////////////////////////////////////////////////////
// 6. Write a program that copies all elements from a Java hash map into //
// a Scala hash map. Use imports to rename both classes.                 //
///////////////////////////////////////////////////////////////////////////

package Chapter07 {
  object MapConversor {
    import collection.mutable.{HashMap => ScalaMap}
    import java.util.{HashMap => JavaMap}

    def java2scala[A, B](fromMap: JavaMap[A, B]): ScalaMap[A, B] = {
      val toMap = ScalaMap[A, B]()
      fromMap.forEach {(k, v) =>
        toMap(k) = v
      }
      toMap
    }
  }
}

///////////////////////////////////////////////////////////////////////
// 7. In the preceding exercise, move all imports into the innermost //
// scope possible.                                                   //
///////////////////////////////////////////////////////////////////////

// Answer: pretty nice, I moved from package body to object MapConversor body.


//////////////////////////////
// 8. What is the effect of //
//     import java._        //
//     import javax._       //
// Is this a good idea?     //
//////////////////////////////

// Answer: wildcard imports never is a good idea, I prefer explicit imports.
// In that case the effect is the implicit override of inner packages.
// The last import has higher priority: javax. Example of packages:
// - net
// - sql
// - lang
// This is not nice and not obvious.


////////////////////////////////////////////////////////////////////////////
// 9. Write a program that imports the java.lang.System class, reads the  //
// user name from the user.name system property, reads a password from    //
// the StdIn object, and prints a message to the standard error stream if //
// the password is not "secret". Otherwise, print a greeting to the       //
// standard output stream. Do not use any other imports, and do not use   //
// any qualified names (with dots).                                       //
////////////////////////////////////////////////////////////////////////////


package Chapter07 {
  object UselessProgram extends App {
    import java.lang.System
    // alternative:
    // package scala.io
    import scala.io
    val userName = System.getProperty("user.name")
    print(f"Hello, ${userName}! Type your password: ")
    val password = StdIn.readLine()
    if (password != "secret") {
      System.err.println("Access denied.")
    } else {
      System.out.println("Access granted.")
    }
  }
}

////////////////////////////////////////////////////////////////////////////
// 10. Apart from StringBuilder, what other members of java.lang does the //
// scala package override?                                                //
////////////////////////////////////////////////////////////////////////////

// Answer: the following names are override:

// - AbstractMethodError
// - annotation
// - ArrayIndexOutOfBoundsException
// - Boolean
// - Byte
// - ClassCastException
// - Cloneable
// - Error
// - Exception
// - Float
// - IllegalArgumentException
// - IndexOutOfBoundsException
// - InterruptedException
// - Iterable
// - Long
// - NullPointerException
// - NumberFormatException
// - ref
// - reflect
// - RuntimeException
// - Short
// - StringBuilder
// - StringIndexOutOfBoundsException
// - Throwable
// - UnsupportedOperationException
