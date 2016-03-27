import java.util.Arrays
import scala.collection.JavaConverters._
val x = 3
val javaList = Arrays.asList(1,2,3,4)
javaList.get(0)
val scalaList = javaList.asScala
scalaList.head
scalaList(3)
val javaListAgain = scalaList.asJava
javaList.equals(javaListAgain)
javaList == javaListAgain
javaList == scalaList


class Company(var name : String)
val sun = new Company("Sun")
val moon = new Company("Sun")
sun == moon
sun eq moon
sun.hashCode()
moon.hashCode()


class Customer (var customerId : Int, var zip : String) {
  def getCustomerId() = customerId
  def setCustomerId(cust : Int) : Unit = {
    customerId = cust
  }
}

val customer = new Customer(1, "23")
customer.zip






