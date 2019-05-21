package programs

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by raki6002 on 27-12-2018.
  */
object FindSeqWithSum {

  def main(args: Array[String]): Unit ={
    val intArr = Array(1, 2, 3, 1, 2, 4, 5, 4, 0, 3, 0, 1)
    val sum:Int = 6
    findSeqMatchesSum1(intArr,sum).foreach(println)
    println(")((123)345) -->   " + isValidExp(")((123)345)"))
    println("((123345) --->   " + isValidExp("((123345)"))
    var test = "Ki" :: Nil
    print(test)


  }

  def findSeqMatchesSum1(vals: Array[Int],sum:Int): Array[String] = {
    {for( i <- vals.indices; j <- i+1 until vals.length if vals(i) + vals (j) == sum  )
      yield vals(i)+","+vals(j)}.toArray
  }

  def findSeqMatchesSum(vals:Array[Int],sum:Int): Array[String] = {
    var poosibleComb = new ListBuffer[String]
    for (i <- vals.indices){
      var num1 = vals(i)
      for (j <- i+1 until vals.length){
        var num2 = vals(j)
        if((num1 + num2) == sum)
          if(!poosibleComb.contains(num1 +","+num2))
            poosibleComb.append(num1 +","+num2)
      }

    }
    println(poosibleComb)
    if (poosibleComb.isEmpty)
      return Array.empty[String]
    else
      return poosibleComb.toArray
  }

  def isValidExp(exp:String):String={
    val stack = new mutable.Stack[Char]
    var dequeueChar:Char = ','
    for(char <- exp){
      if(char == ')'){
        do{
          if(stack.isEmpty)
            return "No"
        } while(stack.pop() != '(')
      }
      else
        stack.push(char)
    }
    if(!stack.isEmpty)
      return "No"
    return "Yes"
  }
}
