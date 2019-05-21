/**
  * Created by Kiran on 02-01-2019.
  * This class giving information on variable declaration and initialization
  */
object Variables {

  def main(args: Array[String]): Unit = {
    /** In Scala variables can be created in 2 ways using Var and Val.
      * Var --> mutable variable
      * Val --> Immutable variables like final in Java
      *
      * In Scala the variable type is identified/assigned implicitly based on the value assigned
      */

    //Name created as immutable re assignment to the variable cause C.E.
    val myName = "Kiran"
    //myName = "Kumar" --> caused CE. Reassignment to Val

    //The age is created as mutable anc can be re assigned
    var age = 20
    println(age) //O.P. --> 20

    //Changing the value from 20 to 30
    age = 30
    println(age) //O.P. --> 30

    /** We can also provide the type of the variable while declaration for better control of the flow
      * Unlike Java, All data types including primitives are classes in Scala. So by mentioning the type
      * we can allow only of its own class or subclasses. For example String type will not accept Int values also
      */

    var marks: Int = 90
    // marks = "" --> Since marks variable created as type Integer. Assigning non integer value causes CE
    var subject: String = "Maths"
  }
}
