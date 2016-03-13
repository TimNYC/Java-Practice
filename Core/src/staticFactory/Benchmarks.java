package staticFactory;

import java.util.*;

/**
 * Created by Tim Wang on 3/12/2016.
 */
public class Benchmarks {

    public static void main(String[] args) {
        RegularCalss rc = new RegularCalss();
        System.out.println(rc.hashCode());
        StaticClass sc = StaticClass.getNewInstance();
        System.out.println(sc.hashCode());
        StaticClass sc2 = StaticClass.getNewInstance();
        System.out.println(sc2.hashCode());
        FixedStaticClass fc = FixedStaticClass.getFixedInstance();
        System.out.println(fc.hashCode());
        FixedStaticClass fc2 = FixedStaticClass.getFixedInstance();
        System.out.println(fc2.hashCode());
        ArrayList list = new ArrayList<>();
        list.add(15);
        list.add("3");
        for (Object i : list) {
            System.out.println(i);
        }
    }
}

class RegularCalss{
    public RegularCalss() {
        System.out.println("RegularClass");
    }
}
/*
    To generate a new instance with static factory method,
    Boolean class in Java, example method valueOf()
    java.util.Collections
    java.util.EnumSet, 'of' method

    Advantage:
    1. constructors with names
    2. can have logic to decide whether create a new instance or not
    3. can return an object of any subtype as return instance
    4.

    Disadvantage:
    1. if not make it static final, constructor must be public or protected
    2. not very distinguishable -> valueOf, of, getInstance, newInstance, getType, newType

 */
class StaticClass{
    public StaticClass() {
        System.out.println("StaticClass");
    }
    public static StaticClass getNewInstance() {
        return new StaticClass();
    }
}

class FixedStaticClass{
    public static final FixedStaticClass fixed = new FixedStaticClass();
    public final int number = 3;
    private FixedStaticClass() {
        System.out.println("FixedStaticClass");
    }

    public static FixedStaticClass getFixedInstance() {
        return fixed;
    }
}
