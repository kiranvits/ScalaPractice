package main.scala.programs

object FindBestMeasurements {

  def minLoss(x:Int, m: List[Int]):Option[Int] = {
    var min = None:Option[Int]
    for(i <- m){
      if (i >= x)
        if(min.isEmpty){
          min = Some(i - x)
        }else{
          if(min.get > (i-x))
            min = Some(i-x)
        }
    }
    min
  }

  def loss(toM:List[Int], m:List[Int]):Option[Int] = {
    var totalLoss = None:Option[Int]
    for(i <- toM){
      val minloss = minLoss(i,m)
      if(minloss.isEmpty)
        return None
      if(totalLoss.isEmpty)
        totalLoss = minloss
      else if(minloss.isDefined){
        totalLoss = Some(totalLoss.get + minloss.get)
      }
    }
    totalLoss
  }

  def main(args: Array[String]): Unit ={
    val toMeasureList = List(4,3,6,7)
    val measurementsList = List(List(2,4,3),List(5,8,9), List(4,5,7))

    def minList(list:List[Option[Int]]):Option[Int] ={
      var min = None:Option[Int]
      for (x <- list){
        if(x.isDefined && (min.isEmpty || (min.isDefined && x.get < min.get)))
          min = x
      }
      min
    }

    def minIndexList(list:List[Option[Int]]):Int = {
      var (minIndex, index, minVal) = (-1, -1, None:Option[Int])
      for (x <- list){
        index += 1
        x match{
          case Some(a) if minVal.isEmpty => {
            minVal = x
            minIndex = index
          }
          case Some(a) if minVal.isDefined && minVal.get > x.get => {
            minVal = x
            minIndex = index
          }
          case _ => {}
        }
      }
      minIndex
    }

    def sumList(list:List[Option[Int]]):Option[Int] = {
      var total = None:Option[Int]
      for (x <- list){
        if(x.isEmpty)
          return None
        else if (total.isEmpty)
          total = x
        else
          total = Some(total.get + x.get)
      }
      total
    }

    val possibleList = for ( m <- measurementsList) yield {
      sumList({for (toM <- toMeasureList) yield {
        minList({
          for (mv <- m) yield {
            if (mv >= toM)
              Some(mv - toM)
            else
              None: Option[Int]
          }
        })
      }})
    }

    // Improvised version with existing list functions, map amd aggregations
    val possibleList_new = for ( m <- measurementsList) yield {
      val total_loss_list = {for (toM <- toMeasureList) yield {
        val loss_list = {
          for (mv <- m) yield {
            if (mv >= toM)
              Some(mv - toM)
            else
              None: Option[Int]
          }
        }.filter(_.isDefined)
        if(loss_list.isEmpty)
          None
        else
          loss_list.min
      }}
        if(total_loss_list.contains(None))
          None
        else
          Some(total_loss_list.filter(_.isDefined).map(_.get).sum)
    }

    println(possibleList)
    println(possibleList_new)
    println("min Index : " + minIndexList(possibleList))
    val minIndex = {
      if (possibleList_new.exists(_.isDefined))
        possibleList_new.indexOf(possibleList_new.filter(_.isDefined).min)
      else
        None
    }
    println("min Index : " + minIndex)
  }
}
