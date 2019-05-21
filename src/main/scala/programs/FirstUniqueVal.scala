package programs

import scala.collection.mutable

/**
  * Created by raki6002 on 27-12-2018.
  */
object FirstUniqueVal {
//  var RepList = new mutable.HashSet[Int]()

  def main(args: Array[String]): Unit ={
    val intArr = Array(1, 2, 3, 1, 2, 4, 5, 4, 0, 3, 5, 6)
    println(findFirstNonRepVal(intArr))
    println(findFirstNonRepValHashSet(intArr)) //Gives in correct results
    println(findUniqNum(intArr))
  }

  /**
    *
    * @param intArr
    * @param RepList
    * @return
    */
  def findUniqNum(intArr: Array[Int], RepList:mutable.HashSet[Int] = new mutable.HashSet[Int]()): Option[Int] ={

    if(intArr.isEmpty)
      return None
    var headNum = intArr.head
    var tailList = intArr.tail
    if(RepList.contains(intArr.head)) {
      return findUniqNum(tailList, RepList)
    }
    else{
      if(intArr.tail.contains(intArr.head)){
        RepList.add(intArr.head)
        return findUniqNum(tailList,RepList )
      }
      else
        return Some(intArr.head)
    }
  }

  def findFirstNonRepVal(vals: Array[Int]): Option[Int] ={
    var list = mutable.LinkedHashSet[Int]()
    for (num:Int <- vals){
      if(list.contains(num))
        list.remove(num)
      else
        list.add(num)
    }

    if(list.isEmpty)
      return None
    else
      return  Some(list.head)
//    return 0
  }
  def findFirstNonRepValHashSet(vals: Array[Int]): Option[Int] ={
    var list = new mutable.HashSet[Int]()
    for (num:Int <- vals){
      if(list.contains(num))
        list.remove(num)
      else
        list.add(num)
    }
    if(list.isEmpty)
      return None
    else
      return  Some(list.head)
    //    return 0
  }
}
