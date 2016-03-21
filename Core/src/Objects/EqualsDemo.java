package Objects;

/**
 * Created by Tim Wang on 3/20/2016.
 */
public class EqualsDemo {
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

        
         */


}
