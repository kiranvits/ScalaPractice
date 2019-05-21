###Variables:

In scala there are two types of attributes. variables and values.

**Variable :** Allows user to modify the value after assignment

**Value :**  Do not allow after initialization

    Syntax: 
        [var | val] <variable_name>[:<data_type] = <value>
        
    example:
    
    var a = 10 // the data type is inferred using the value assigned
    
    var b:Int = 10 // assigning not intergers throws error
    
    a = 30 //updates the value to 30
    
    a = "s" // compile time error
    <console>:8: error: type mismatch;
     found   : String("s")
     required: Int
           a = "s"
               ^
    
    scala> val y = 10
    y: Int = 10
    
    scala> y = 12
    <console>:8: error: reassignment to val
           y = 12
             ^
A variable can be initialized with default value using the '_' symbol. 

    scala> var x:Int = _
    x: Int = 0
    
    scala> var s:String = _
    s: String = null

Note: 
1. Variables can not be declared without initialization except in abstract class or trait

        var empty
        C.E. : Wrong variable declaration 
        
        var empty:Int
        C.E. : Only classes can have declared but undefined members
        
2. While using the _,  the data type should be provided for the variable if not CE will be thrown.
    
        scala> var x = _
        
        <console>:7: error: unbound placeholder parameter
               var x = _
                       ^
3. Initialization to Val gives CE
        
        scala> val x:Int = _
        
        <console>:7: error: unbound placeholder parameter
               val x:Int = _
                           ^
4. Variable types are identified implicitly using initialized value. Assigning non compatible types not allowed.
so while assigning nulls for later use need to provide type or used asInstanceOf 
        
            scala> var test = null
            test: Null = null
            
            scala> test = "kiran"
            <console>:8: error: type mismatch;
             found   : String("kiran")
             required: Null
                   test = "kiran"
                          ^
            
            scala> var test = null.asInstanceOf[String]
            test: String = null
            
            scala> test = "kiran"
            test: String = kiran
            
            scala> var test1:String = null
            test1: String = null
            
            scala> test1 = "test"
            test1: String = test
### DataTypes:
Boolean, Byte, Short, Char, Int, Long, Float, Double, String

### Conditional Statements:

1. IF - ELSE Statement
        
        Syntax:
        
        if(<condition>){
            ... Statements
        } else {
            ... Statements
        }
2. IF - ELSE -IF Statment
        
        Syntax:
        if(condition){
        } 
        else if( condition ){
        }
        else {
        }
        
        Example: The if statment output can also be asigned to function
        scala> def gender(g:Char) = if(g == 'M' || g == 'm') {"MALE"} else if(g == 'f' || g == 'F') {"FEMALE"} else {"THIRD"} 
        gender: (g: Char)String
        
        scala> gender('m')
        res5: String = MALE
        
### Patten Matching:

* Pattern matching is like a switch case in other languages but with some rich features

        syntax:
            <expression> match {
            case value1 => {..statements}
            case value2 => {..statements}
            .
            .
            case _ => {like others/default}
             
            }
         
         example:
            scala> def gen(g:Char) = g.toUpper match {
              case 'M' => "Male"
              case 'F' => "Female"
              case _ => "Third"
            }
            
            scala> gen('m')
            res8: String = Male
            
            scala> gen('F')
            res10: String = Female
            
* Patten matching can be used for different objects also
        
        def number(x:Any) = x match{
          case "one" => 1
          case 1 => "one"
          case _ => "Works for only 1"
        }
        
        scala> number(1)
        res13: Any = one
        
        scala> number("one")
        res14: Any = 1
        
* Patten Matching also works on Case classes