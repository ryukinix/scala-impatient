package impatient

import scala.beans.BeanProperty

// Title: Classes
object Chapter05 {

  // 1. Improve the Counter class in Section 5.1, “Simple Classes and
  // Parameterless Methods,” on page 55 so that it doesn’t turn negative
  // at Int.MaxValue.
  class SafeCounter(from: Int = 0) {
    private var value = from
    def increment() {
      if (value < Int.MaxValue) {
        value += 1
      }
    }
    def current() = value
  }

  // 2. Write a class BankAccount with methods deposit and withdraw, and
  // a read-only property balance.
  class BankAccount(startBalance: Double = 0) {
    private var money: Double = startBalance

    def deposit(value: Double) {
      money += value
    }

    def withdraw(value: Double) {
      money -= value
    }

    def balance() = money
  }

  // 3. Write a class Time with read-only properties hours and minutes
  // and a method before(other: Time): Boolean that checks whether this
  // time comes before the other. A Time object should be constructed as
  // new Time(hrs, min), where hrs is in military time format (between 0
  // and 23).
  class Time(val hours: Int, val minutes: Int) {
    assert(hours >= 0 && hours <= 23)
    assert(minutes >= 0 && minutes <= 60)

    def before(other: Time): Boolean = {
      (
        hours == other.hours && minutes < other.minutes
        || hours < other.hours
      )
    }
  }

  // 4. Reimplement the Time class from the preceding exercise so that
  // the internal representation is the number of minutes since midnight
  // (between 0 and 24 × 60 – 1). Do not change the public
  // interface. That is, client code should be unaffected by your change.
  class TimeFancy(val hours: Int, val minutes: Int) {
    assert(hours >= 0 && hours <= 23)
    assert(minutes >= 0 && minutes <= 60)
    private val internalTime = hours * 60 + minutes

    def before(other: TimeFancy): Boolean = {
      internalTime < other.internalTime
    }
  }

  // 5. Make a class Student with read-write JavaBeans properties name
  // (of type String) and id (of type Long). What methods are generated?
  // (Use javap to check.) Can you call the JavaBeans getters and setters
  // in Scala? Should you?
  // Yes, I can call. Yes, I should.
  // NOTE: setting properties as
  // > instance.name = "random namber"
  // generates a message: mutated instance.name
  class Student(@BeanProperty var name: String, @BeanProperty var id: Int) {

  }

  // 6. In the Person class of Section 5.1, “Simple Classes and
  // Parameterless Methods,” on page 55, provide a primary constructor
  // that turns negative ages to 0.
  class Person(_age: Int) {
    var age = if (_age > 0) _age else 0
  }

  // 7. Write a class Person with a primary constructor that accepts a
  // string containing a first name, a space, and a last name, such as
  // new Person("Fred Smith"). Supply read-only properties firstName and
  // lastName. Should the primary constructor parameter be a var, a val,
  // or a plain parameter? Why?
  // Answer: val.
  // why not var: will create inconsistent state between name/firstName/lastName
  // why not plain parameter: name will not available and can be useful
  // why val: name will be available as field as well.
  class PersonName(val name: String) {
    private val names = name.split(' ')
    val firstName = names.head
    val lastName = names.last
  }

  // 8. Make a class Car with read-only properties for manufacturer,
  // model name, and model year, and a read-write property for the
  // license plate. Supply four constructors. All require the
  // manufacturer and model name. Optionally, model year and license
  // plate can also be specified in the constructor. If not, the model
  // year is set to -1 and the license plate to the empty string. Which
  // constructor are you choosing as the primary constructor? Why?
  //
  // Answer: primary constructor with manufacturer and model as val
  // fields, because they are need always. I found only three
  // constructors are need.
  // But I can build the class using only the primary constructor
  // with default parameters
  class Car(val manufacturer: String, val model: String) {
    private var _year = -1
    var licensePlate = ""

    def this(manufacturer: String, model: String, year: Int) {
      this(manufacturer, model)
      _year = year
    }
    def this(manufacturer: String, model: String, year: Int, license: String) {
      this(manufacturer, model, year)
      licensePlate = license
    }

    def year() = _year
  }

  class CarSimplified(
    val manufacturer: String,
    val model: String,
    val year: Int = -1,
    var licensePlate: String = ""
  )

  // 9. Reimplement the class of the preceding exercise in Java, C#,
  // or C++ (your choice). How much shorter is the Scala class?
  // No, thanks.

  // 10. Consider the class
  //
  //     class Employee(val name: String, var salary: Double) {
  //       def this() { this("John Q. Public", 0.0) }
  //     }
  //
  // Rewrite it to use explicit fields and a default primary
  // constructor. Which form do you prefer? Why?
  // I prefer the shorter one! Don't need to declare explicit fields
  class Employee(_name: String = "John Q. Public", _salary: Double = 0.0) {
    val name = _name
    val salary = _salary
  }
}
