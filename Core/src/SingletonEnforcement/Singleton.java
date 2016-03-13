package SingletonEnforcement;

/**
 * Created by Tim Wang on 3/13/2016.
 */
public class Singleton {
    public static void main(String[] args) {
        System.out.println("single!");
    }
}

/*
    static factory with getInstance method,
    Caveat:
    1. Not the best, because one can invoke the private constructor reflectively with the aid
of the  AccessibleObject.setAccessible method.
    2. To make either SIngletonStaticFactory or SingletonClass Serializable, it is not sufficient merely
to make implements Serializable to the declaration. One has to declare all instance fields transient
and provide a readResolve method. Otherwise, each time a serialized instance, a new instance will be created.
 */
class SingletonStaticFactory {
    private static final SingletonStaticFactory INSTANCE = new SingletonStaticFactory();
    private SingletonStaticFactory() {

    }

    public static SingletonStaticFactory getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }

    private Object readResolve() {
// Return the one true INSTANCE and let the garbage collector
// take care of the impersonator.
        return INSTANCE;
    }
}

/*
    OR, access directly through INSTANCE, has the same caveat
 */
class SingletonClass {
    static final SingletonClass INSTANCE = new SingletonClass();
    private SingletonClass() {
    }
}

/*
    Currently the best way, enum.
    This way is functionally equivalent to the public field approach, except that
    it is more concise, free serialization machinery, guarantee against multiple instantiation
    even in sophisticated serialization or reflection attacks.
 */
enum SingletonEnum {
    INSTANCE;
    public void leaveTheBuilding() {

    }
}
