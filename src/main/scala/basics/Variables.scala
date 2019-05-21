package main.scala.basics

object Variables extends App {

  var x = 10
  var y:Int = 20
  val A = 30

  // _ assigns default value
  var i:Int = _
  var l:Long = _
  var s:String = _

  println("x = " + x)
  println("y = " + y)
  println("Int Default value " + i)
  println("Long Default value " + l)
  println("String Default value " + s)

  // update variable value
  x = 40
  println("x = " + x)

  //Updating Value cause CE
  //  A = 40  // --> CE : Reassignment to Val

  var empty:Int;
}

class Test{
  var empty:Int

}
