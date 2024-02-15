fun main() {
    //Opgave 1
    //De to employee objekter
    val employee1 = Employee("Lucas", "Jacobsen", 8579.0)
    val employee2 = Employee("Christine", "Tofft", 9000.0)
    //Vis årlige løn for hver employee
    println("${employee1.firstName} ${employee1.lastName}'s yearly salary: ${employee1.yearlySalary()}")
    println("${employee2.firstName} ${employee2.lastName}'s yearly salary ${employee2.yearlySalary()}")
    println()
    //Employee raise
    employee1.raise(0.12)
    employee2.raise(0.12)
    //Vis årlige løn efter lønstigning
    println("After 12% raise")
    println("${employee1.firstName} ${employee1.lastName}'s yearly salary: ${employee1.yearlySalary()}")
    println("${employee2.firstName} ${employee2.lastName}'s yearly salary ${employee2.yearlySalary()}")


println()

    //Opgave 2
    //Laptop og Smartphone
    val laptop = Laptop("Macbook Air", "M2", 12000.0, 13.6)
    val smartphone = Smartphone("Iphone", "13 Pro Max",9000.0, 204.0)

    println("Laptop information")
    println("Brand: ${laptop.brand}")
    println("Model: ${laptop.model}")
    println("Price: ${laptop.price}")
    println("Screen Sizee: ${laptop.screenSize} tomer")
    laptop.device()
println()
    println("Smartphone information")
    println("Brand: ${smartphone.brand}")
    println("Model: ${smartphone.model}")
    println("Price: ${smartphone.price}")
    println("Weight: ${smartphone.weight} gram")
    smartphone.device()

println()

    //Opgave 3
    val shoe = Shoe("Nike Air Max", 2000, 2)
    val thshirt = Tshirt("Halo", 500, 1)
    val book = Book("Biblem", 100,1)

    shoe.identifyProductCategory()
    thshirt.identifyProductCategory()
    book.identifyProductCategory()


    println()


    //Opgave 4
    //Circle
    val circle = Circle(9.0,"Blue", false)
    println("Circle perimeter: ${circle.calculatePerimeter()}")
    println("Circle area: ${circle.calculateArea()}")

    //Rectangle
    val rectangle = Rectangle(6.0, 5.0, "Green", true)
    println("Rectangle perimeter: ${rectangle.calculatePerimeter()}")
    println("Rectangle area: ${rectangle.calculateArea()}")

    //Triangle
    val triangle = Triangle(3.5, 4.8, 7.8, "Red", false)
    println("Triangle perimeter: ${triangle.calculatePerimeter()}")
    println("Triangle area: ${triangle.calculateArea()}")
}






//  OPGAVE 1
// Create a class called Employee that includes three pieces of information as instance variables
//A first name
//A last name
//A monthly salary
//Your class should have a constructor that initializes the three instance variables.
//If the monthly salary is not positive, set it to 0.0.
//Create two Employee objects and display each object’s yearly salary.
//Then give each Employee a 10% raise and display each Employee’s yearly salary again.

class Employee(val firstName: String, val lastName: String, var monthlySalary: Double) {
    init {
        if (monthlySalary < 0) {
            monthlySalary = 0.0
        }
    }
    fun yearlySalary(): Double {
        return monthlySalary * 12
    }
    fun raise(raisePercentage: Double) {
        monthlySalary *= (1 + raisePercentage)
    }
}



// OPGAVE 2
//Create a new class called Computer. Before you add any more code,
// know that you will need to add two additional classes: Laptop and SmartPhone
//For a parent class add 3 properties, 2 methods, and a constructor.
//For a child class add at least 1 additional property and 1 additional method.
//In the main method create a Laptop and a SmartPhone

open class Computer(val brand: String, val model: String, var price: Double) {
    fun device() {
        println("$brand $model is starting")
        }
    }
class Laptop(brand: String, model: String, price: Double, val screenSize: Double): Computer(brand, model, price)
class Smartphone(brand: String,model: String,price: Double, val weight: Double): Computer(brand, model, price)




// OPGAVE 3
//Create a base class Product with attributes like name, price, and quantity
// and a function identifyProductCategory. Subclass it to create specific product
// types like Shoe, T-shirt, and Book. Override the function such that:
//The shoe outputs "I am a shoe" .
//The T-shirt outputs "I am a T-shirt"
//The book outputs "I am a book"

open class Product(val name: String, val price: Int, val quantity: Int) {
    open fun identifyProductCategory() {
        println("I am a product" )
    }
}

class Shoe(name: String, price: Int, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
       println("I am a shoe")
    }
}

class Tshirt(name: String, price: Int, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a T-shirt")
    }
}

class Book(name: String, price: Int, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a book")
    }
}



//OPGAVE 4
//Create 3 classes Circle, Rectangle & Triangle with a parent class: Shape.
//Every shape has two attributes
//color
//isTransparent
//Furthermore every class has private attributes to calculate
// perimeter and area for each shape.
//E.g. a Rectangle has the attributes: height, width, color & isTransparent
//The attributes are set in the constructor
//The 3 classes all overrides the following abstract methods from their parent class:
//calculatePerimeter
//calculateArea
//The functions will return the permeter or area of the shape.

abstract class Shape(val color: String, val isTransparrent: Boolean) {
    abstract fun calculatePerimeter(): Double
    abstract fun calculateArea(): Double
}

//Circle
class Circle(val radius: Double, color: String, isTransparrent: Boolean): Shape(color, isTransparrent){
    override fun calculatePerimeter(): Double {
        return 2* Math.PI*radius
    }
    override fun calculateArea(): Double {
        return Math.PI*radius*radius
    }
}

//Rectangle
class Rectangle(val height: Double, val width: Double, color: String, isTransparrent: Boolean): Shape(color, isTransparrent){
    override fun calculatePerimeter(): Double {
        return 2* (width+height)
    }
    override fun calculateArea(): Double {
        return width*height
    }
}

//Triangle
class Triangle(val side1: Double, val side2: Double, val side3: Double, color: String, isTransparrent: Boolean): Shape(color, isTransparrent) {
    override fun calculatePerimeter(): Double {
        return side1 + side2 + side3
    }

    override fun calculateArea(): Double {
        //For at beregne arealet af en trekant, tager jeg brug af Herons formel
        val s = (side1 + side2 + side3)/2
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3))
    }
}

