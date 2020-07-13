package impatient

import java.awt

// Title: Objects
object Chapter06 {

  // 1. Write an object Conversions with methods inchesToCentimeters,
  // gallonsToLiters, and milesToKilometers.
  object Conversions {
    def inchesToCentimeters(inches: Double) = inches * 2.54
    def gallonsToLiters(gallons: Double) = gallons * 3.78
    def milesToKilometers(miles: Double) = miles * 1.6
  }

  // 2. The preceding problem wasn’t very object-oriented. Provide a
  // general superclass UnitConversion and define objects
  // InchesToCentimeters, GallonsToLiters, and MilesToKilometers that
  // extend it.
  class UnitConversion(val factor: Double) {
    def apply(value: Double) = value * factor
  }

  object InchesToCentimeters extends UnitConversion(2.54)
  object GallonsToLiters extends UnitConversion(3.78)
  object MilesToKilometers extends UnitConversion(1.6)


  // 3. Define an Origin object that extends java.awt.Point. Why is this
  // not actually a good idea? (Have a close look at the methods of the
  // Point class.)
  // That is not very good idea because x and y componetes are mutable
  // in the awt.Point class, by setLocation and move
  class Origin extends awt.Point(0, 0)


  // 4. Define a Point class with a companion object so that you can
  // construct Point instances as Point(3, 4), without using new.
  class Point(val x: Double, val y: Double) {
    override def toString = s"Point(x=$x, y=$y)"
  }

  object Point {
    def apply(x: Double, y: Double) = new Point(x, y)
  }

  // 5. Write a Scala application, using the App trait, that prints its
  // command-line arguments in reverse order, separated by spaces. For
  // example, scala Reverse Hello World should print World Hello.
  object ReversedApp extends App {
    def apply(args: Array[String]): String = {
      args.reverse.mkString(" ")
    }

    println(apply(args))
  }

  // 6. Write an enumeration describing the four playing card suits so
  // that the toString method returns ♣, ♦, ♥, or ♠.
  object Card extends Enumeration {
    type Card = Value
    val Hearts = Value("♥")
    val Spades = Value("♠")
    val Diamonds = Value("♦")
    val Clubs = Value("♣")
  }
  // make enumeration more C-like
  import Card._

  // 7. Implement a function that checks whether a card suit value
  // from the preceding exercise is red.
  def isRed(card: Card) = card == Hearts || card == Diamonds

  // 8. Write an enumeration describing the eight corners of the RGB
  // color cube. As IDs, use the color values (for example, 0xff0000 for
  // Red).
  object Color extends Enumeration {
    // RGB: (R, G, B)
    type Color = Value
    val White = Value(0xffffff)
    val Black = Value(0x000000)
    val Red = Value(0xff0000)
    val Green = Value(0x00ff00)
    val Blue = Value(0x0000ff)
    val Yellow = Value(0xffff00)
    val Purple = Value(0xff00ff)
    val Cyan = Value(0x00ffff)
  }
}
