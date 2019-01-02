package programs

import scala.collection.mutable.ListBuffer
import scala.io.Source


/**
  * Created by raki6002 on 09-12-2018.
  */

object MissingNum {

  case class Book(title: String, pages: Int = 200)
  case class BookList(books: List[Book])

  class Book1(title: String, pages: Int = 200){

  }

  def main(args:Array[String]): Unit ={

    var b1 = new Book("Book Name",12)
    var b2 = new Book("second Book")
    var b3 = new Book("second Book")


    var b4 = new Book1("second Book")
    var b5 = new Book1("second Book")

    var l1 = List(b3)
    var l2 = List(b2)

    var bl1 = BookList(l1)
    var bl2 = BookList(l2)
    println(b2.pages)

    println("comparing b2 and b3 :" + b2.equals(b3))
    println("comparing b4 and b5 :" + b4.equals(b5))
    println("comparing lists :" + l1.equals(l2))
    println("comparing BookList objects :" + bl1.equals(bl2))

    var list_num = new ListBuffer[Int]
    val fs = Source.fromFile("C:\\Users\\raki6002\\git\\ndx-data-model\\ndx\\ScalaPractice\\resources\\Numbers.txt")
      .getLines()
    fs.foreach( x => list_num.append(x.toInt))
    println(list_num)
//    val list = List(2,10,5,12,7,8,9)
    findMissingNum(list_num.toList,1,30)

    var list1 = list_num ++ list_num
    println(list1)
//    println("Scenario 2")
//    findMissingNum(list,5,15)
//    println("Scenario 3")
//    findMissingNum(list,4,15)
  }

  def findMissingNum(list: List[Int], startNum: Int, lastNum:Int): Unit ={
    val list_sorted = list.filter(x => (x >=startNum && x <=lastNum)).sortWith(_ < _)
    var missing_num = ListBuffer[Int]()
    println(list_sorted)
    var prevVal = startNum-1
    list_sorted.foreach(x => {
      missing_num ++= (prevVal+1 to x-1).toList
      prevVal=x
    })
    missing_num ++= (prevVal+1 to lastNum).toList
    println(missing_num)
    println(prevVal)
  }

}
