// author Yiqing Wang

fun main(args: Array<String>) 
{
    val sample1: Byte = 0x3A
    var sample2: Byte = 58
    var heartRate: Int = 85
    var deposits = 135002796.0
    val acceleration = 9.800f
    var mass = 14.6f
    var distance = 129.763001
    var lost = true
    var expensive = true
    var choice: Int = 2
    val integral = "\u222B"
    val greeting = "Hello"
    var name = "Karen"
    
    if(sample1 == sample2)
    {
    	println("The samples are equal.")  
    }
    else
    {
        println("The samples are not equal.") 
    }
    
    if(heartRate in 40..80)
    {
        println("Heart rate is normal.") 
    }
    else
    {
        println("Heart rate is not normal.") 
    }
    
    if(deposits >= 100000000)
    {
        println("You are exceedingly wealthy.") 
    }
    else
    {
        println("Sorry you are so poor.") 
    }
    
    var force = mass*acceleration
    println("force = $force")
    
    println("$distance is the distance.")
    
    if(lost && expensive)
    {
        println("I am really sorry! I will get the manager.") 
    }
    
    if(lost && !expensive)
    {
        println("Here is coupon for 10% off.") 
    }
    
    when(choice)
    {
        1 -> println("You chose 1.")
        2 -> println("You chose 2.")
        3 -> println("You chose 3.")
        else -> { println("You made an unknown choice.")
        }
    }
    
    println("$integral is an integral.")
    
    for(i in 5..10)
    {
        println("i = $i")
    }
    
    var age: Int = 0
    
    while(age < 6)
    {
        println("age = $age")
    	age++
    }
    
    println("$greeting $name")
}
