package Objects;

import org.apache.tools.ant.taskdefs.condition.Equals;

/**
 * Created by Tim Wang on 3/20/2016.
 */
public class EqualsDemo extends EqualsBase {
    // Lazily initialized, cached hashCode
    private volatile int hashCode; // (See Item 71)
    /*
    When not to override equals function
    1. Each instance of the class is inherently unique.
    2. You don’t care whether the class provides a “logical equality” test.
    3. A superclass has already overridden equals, and the superclass behavior is appropriate for this class.
    4. The class is private or package-private, and you are certain that its equals method will never be invoked.

     */

    /*
        definition of overriding equals:c The Equals Contract

        • Reflexive: For any non-null reference value x, x.equals(x) must return true.

        • Symmetric: For any non-null reference values x and y, x.equals(y) must return
        true if and only if y.equals(x) returns true.

        • Transitive: For any non-null reference values x, y, z, if x.equals(y) returns
        true and y.equals(z) returns true, then x.equals(z) must return true.

        • Consistent: For any non-null reference values x and y, multiple invocations
        of x.equals(y) consistently return true or consistently return false, provided
        no information used in equals comparisons on the objects is modified.

        • For any non-null reference value x, x.equals(null) must return false.
     */

     /*
        The Liskov substitution principle:
        #! The Liskov substitution principle says that any important property of a type
        should also hold for its subtypes, so that any method written for the type should
        work equally well on its subtypes.

         */


    /*
        Putting it all together, here’s a recipe for a high-quality equals method:
        1, Use the == operator to check if the argument is a reference to this object.
        2, Use the instanceof operator to check if the argument has the correct type.
        3, Cast the argument to the correct type.
        4, For each “significant” field in the class, check if that field of the argument
            matches the corresponding field of this object.
        5, When you are finished writing your equals method, ask yourself three
            questions: Is it symmetric? Is it transitive? Is it consistent?
        6, 
    */
    
    /* Also need to do!
    1. Always override hashCode when you override equals
    2. Don’t try to be too clever.
    3. Don’t substitute another type for Object in the equals declaration.
    Do Not: public boolean equals(MyClass o), overload equals
    Do: @Override public boolean equals(MyClass o)
    */
    public EqualsDemo() {
        super();
    }

    public EqualsDemo(int num) {
        super(num);
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof EqualsDemo))
            return false;
        EqualsDemo m = (EqualsDemo) o;
        return this.getType1() == m.getType1();
    }

    //always override hashCode when you override equals
    /*
        This HashCode Contract
        Whenever it is invoked on the same object more than once during an execution
    of an application, the hashCode method must consistently return the
    same integer, provided no information used in equals comparisons on the
    object is modified. This integer need not remain consistent from one execution
    of an application to another execution of the same application.

        If two objects are equal according to the equals(Object) method, then calling
    the hashCode method on each of the two objects must produce the same
    integer result.

        It is not required that if two objects are unequal according to the equals(Object)
    method, then calling the hashCode method on each of the two objects
    must produce distinct integer results. However, the programmer should be
    aware that producing distinct integer results for unequal objects may improve
    the performance of hash tables.
     */
    @Override public int hashCode() {

       /* int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
        */
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + this.getType1();
            hashCode = result;
        }
        return result;
    }

    public static void main(String[] args){
        EqualsDemo eqd = new EqualsDemo();
        System.out.println(eqd.getType1());
        EqualsDemo eqd2 = new EqualsDemo(3);
        System.out.println(eqd2.getType1());
        EqualsBase eb1 = new EqualsBase(3);
    }

}

class EqualsBase {
    private int type1;
    public EqualsBase() {
        this.type1 = Integer.MIN_VALUE;
        System.out.println("base");
    }
    public EqualsBase(int num) {
        this.type1 = num;
        System.out.println(type1);
    }
    public int getType1() {
        return this.type1;
    }
}
