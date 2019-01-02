package basics

/**
  * Created by raki6002 on 02-01-2019.
  *
  */
object Basics {

  /**
    * The parameters are by default private and val. To access the parameters using object need to declare as var
    * @param empName
    * @param empId
    */

  class Emp(var empName:String, var empId:Int){
    /**
      *
      * @param name
      */
    def setEmpName(name:String): Unit ={
      empName = name
    }

    /**
      *
      * @return
      */
    def getEmpName():String = {
      return empName
    }
  }

  case class EmpCase(empName:String, empId:Int)

  /**
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    /** Creating varaiables Var and Val
      * Var --> mutable variable
      * Val --> Immmutable variables like final in Java
    */
    var mutableIntVar = 10
    val immutableIntVar = 20
    mutableIntVar = 20
      // immutableIntVar = 30 --> Compile Error Reassignment to val
    val emp = new Emp("Kiran",100)
    println(emp.getEmpName())
    println(emp.empName)

//    emp.empName
    val empCase = new EmpCase("Kiran",100)
    println(empCase.empName)

    val arr = Array(1,2,3,4)
//    println(arr(4))
    arr(3) = 10
    arr.foreach(println)
  }

}
