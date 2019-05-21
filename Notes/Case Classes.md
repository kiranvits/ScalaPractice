##Case Classes

* Case classes are like regular classes with a few key differences. Case classes are good for modeling immutable data
   
       Syntax: case class <class_name>(<class attributes>)
       
       example:
        scala> case class Emp(emp_name:String, emp_sal:Int, dep_id:Int)
          defined class Emp
    
* case class objects can be created with or without using the new Keyword. Where as general class can only be created using new key word
          
         scala> val emp1 = Emp("Kiran",100000,1)
         emp1: Emp = Emp(Kiran,100000,1)
         
         scala> val emp2 = new Emp("Kiran",100000,1)
         emp2: Emp = Emp(Kiran,100000,1)

Note: 
1. The case class have an apply method by default which takes care of object construction.
2. When you create a case class with parameters, the parameters are public vals. Reassignment to case class attributes is not allowed 
    
        scala> val emp1 = Emp("Kiran",100000,1)
                 emp1: Emp = Emp(Kiran,100000,1)
                 
        scala> emp1.emp_name = "Kumar"
        <console>:10: error: reassignment to val
               emp1.emp_name = "Kumar"
                             ^
3. But, case class attributes also can be defined as vars explicitly to allow changes.
         
         scala> case class EmpTest(var x:Int, var y:Int)
         defined class EmpTest
         scala> var empTemp1 = EmpTest(1,2)
         empTemp1: EmpTest = EmpTest(1,2)
         
         scala> empTemp1.x
         res5: Int = 1
         
         scala> empTemp1.x = 10
         empTemp1.x: Int = 10
         

* case class objects are compared by value unlike normal classes which by reference
        
        ***** Class objects comparison ************ 
        scala> class EmpClass(emp_name:String, emp_sal:Int, dep_id:Int){}
        defined class EmpClass
        
        scala> val emp3 = new EmpClass("Kiran",100000,1)
        emp3: EmpClass = EmpClass@51850751
        
        scala> val emp4 = new EmpClass("Kiran",100000,1)
        emp4: EmpClass = EmpClass@21d8bcbe
        
        scala> emp3 == emp4
        res1: Boolean = false
        
        ********* Case class objects comparison ***********
        scala> val emp1 = Emp("Kiran",100000,1)
        emp1: Emp = Emp(Kiran,100000,1)
        
        scala> val emp2 = new Emp("Kiran",100000,1)
        emp2: Emp = Emp(Kiran,100000,1)
        
        scala> emp1 == emp2
        res0: Boolean = true

* Copying: Case class objects can be copied using copy method.
        
        #### Copy Emp object by modifying only some attributes
        scala> val emp1 = Emp("Kiran",100000,1)
        emp1: Emp = Emp(Kiran,100000,1)
        
        scala> val emp5 = emp1.copy(dep_id = 2)
        emp5: Emp = Emp(Kiran,100000,2)
        
* case classes can also have methods in it
        
        scala> case class Bird(color:String, sound: String){
          def wish(): Unit ={
            println("Wishing you : " + sound)
          }
          def show(): Unit ={
            println(color)
          }
        }
        
        scala> var crow = Bird("Black","KawKaw")
        crow: Bird = Bird(Black,KawKaw)
        
        scala> crow.wish()
        Wishing you : KawKaw