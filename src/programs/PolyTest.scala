package programs

import java.util.logging.{Level, Logger}

import scala.collection.mutable
import scala.collection.mutable.{HashSet, ListBuffer}



/**
  * Created by raki6002 on 26-11-2018.
  */
object PolyTest {

  val log = Logger.getLogger("PolyTest")
  log.setLevel(Level.INFO)

  def main(args: Array[String]): Unit ={
   findPolyndromes("MMaddaMM")
  }

  def findPolyndromes(str:String): Unit ={
    if(str.length<2){
      println("String length is less than 2. Ployndrome test will need atleast string of 2 chars")
      return
    }
    var strLen = str.length-1
    var intermStr:StringBuilder = new StringBuilder()
    var possibleWords = new ListBuffer[String]
    var possWords = mutable.ArrayBuffer.empty[String]
    var possSet:HashSet[String] = HashSet.empty[String]
    str.foreach(char => {
//      intermStr.append(char)
        intermStr += char
//      (0 to intermStr.length-2).map(index => isPolyndrome(intermStr.substring(index).toString))
      (0 to intermStr.length-2).map(index => {
        possibleWords.append(intermStr.substring(index).toString)
        possSet.add(intermStr.substring(index).toString)
      })
    })
    var polyWords = possibleWords.filter(isPolyndrome)
    var nonPolyWords = possibleWords.filter(x => !isPolyndrome(x))
//    var polyWords = possibleWords.filter(str => str.equals(str.reverse))
    log.info(possibleWords.toString())
    println(possibleWords)
    println(possSet)
    println(polyWords)
    println(nonPolyWords)
    println("number of Polyndromes : " + polyWords.size)
  }

  def isPolyndrome(str:String): Boolean ={
    if (str.equals(str.reverse)){
      println(str)
      return true
    }
    return false
  }
}
