package main.scala.programs

import scala.collection.mutable.ListBuffer


object FindSchedules {

  def main(args: Array[String]): Unit ={
    val startList = List(2,2,3,3,4)
    val endList = List(6,2,3,4,5)
    val schedules_date = new ListBuffer[Int]
    val schedules_persons = new ListBuffer[Int]


    val comb = {for( i <- startList.indices ) yield (i, {
        for( j <- startList(i) to endList(i)) yield j
      }.toList)}.toList

    println(comb)

    val comb_map = comb.groupBy(_._2.size)
    println(comb_map)
    println(comb_map.toList.sortWith(_._1 < _._1))
    val comb_list_sorted = comb_map.toList.sortWith(_._1 < _._1)
    comb_list_sorted.foreach( x =>
      x._2.foreach(x => {
          val available_persons = x._2.filterNot(schedules_persons.contains(_))
          println("available persons : " + available_persons)
          if(available_persons.nonEmpty){
            schedules_date.append(x._1)

            schedules_persons.append(available_persons.sortWith( _ < _ ).head)
          }
      })
    )

    println(schedules_date)
    println(schedules_persons)
  }

}
