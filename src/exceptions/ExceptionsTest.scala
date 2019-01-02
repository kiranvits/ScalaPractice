package exceptions

/**
  * Created by raki6002 on 24-11-2018.
  */
object ExceptionsTest {

  def main(args: Array[String]): Unit ={

    try{

//      var s:String = null
//      println(s.length)
      println(10/0)

    }catch {
      case e:Exception => {
        println("General Exception")
        e.printStackTrace()
      }
      case e:ArithmeticException => {
        println("Arithmetic Exception")
        e.printStackTrace()
      }
      case e:NullPointerException => {
        println("Null Pointer Exception")
        e.printStackTrace()
      }
      case t:Throwable => {
        t.printStackTrace()
      }
    }finally {
      println("Final Block is called")
    }

  }

}
