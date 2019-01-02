package oops

/**
  * Created by raki6002 on 09-12-2018.
  */
object CaseClassExample {

  case class Book(title: String, pages: Int = 200)
  case class BookList(books: List[Book])

  class Book1(title: String, pages: Int = 200){

  }

  def main(args:Array[String]): Unit = {

    var b1 = new Book("Book Name", 12)
    var b2 = new Book("second Book")
    var b3 = new Book("second Book")


    var b4 = new Book1("second Book")
    var b5 = new Book1("second Book")

    var l1 = List(b3)
    var l2 = List(b2)

    var bl1 = BookList(l1)
    var bl2 = BookList(l2)
    println(b2.pages)

    println("comparing b2 and b3 :" + b2.equals(b3)) // Case classes by default override equals method to compare data
    println("comparing b4 and b5 :" + b4.equals(b5)) // Need to override equals method for normal classes
    println("comparing lists :" + l1.equals(l2))
    println("comparing BookList objects :" + bl1.equals(bl2))
  }

}
