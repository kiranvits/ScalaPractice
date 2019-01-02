package oops

/**
  * Created by raki6002 on 10-12-2018.
  */
object TraitExample {

  // We can not extends two different traits . If so override implementation is required.

  trait Base {
    def op: String
  }

  trait Foo extends Base {
    override def op = "foo"
  }

  trait Bar extends Base {
    override def op = "bar"
  }

  class E extends Foo with Bar
  class F extends Bar with Foo

  trait A{
  def hello(): Unit ={
    println("Hello A")
  }
  }

  trait C extends A {
    override def hello(): Unit ={
      println("Hello C")
    }
  }

  trait B extends A {
    override def hello(): Unit ={
      println("Hello B")
    }
  }

  class K extends A{
    override def hello(): Unit ={
      println("Hello K")
    }
  }

  class H extends C with B
  class I extends B with C
  class J extends K with C
//  class C extends A with B{
//
//  }
//
//  class D extends B with A{
//
//  }

  def main(args: Array[String]): Unit ={
    val e = new E()
    val f = new F()
    println(e.op)
    println(f.op)
    (new H).hello()
    (new I).hello()
  }

}
