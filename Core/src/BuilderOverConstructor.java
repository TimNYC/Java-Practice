/**
 * Created by Tim Wang on 3/12/2016.
 */
/*
    static factories and constructors share a limitation:
    they do not scale well to large numbers of optional params.

    Solutions:
    1. Telescoping Constructor Pattern: use many constructors with
        different params required. (Bad option)
    2. JavaBeans Pattern: call a parameterless constructor to create the object
        and then call setter methods to set each required/optional params.
        (A little bit better but wordy. and inconsistent when construct)
        (More important, you cannot make a class immutable!)
    3. Builder Pattern: combine both
 */
public class BuilderOverConstructor {
    static {
        System.out.println("outer!");
    }
    protected int num = 5;

    private final int required1;
    private final int required2;
    private final int optional1;
    private final int optional2;

    public static class Builder {
        private final int required1;
        private final int required2;

        private int optional1 = 0;
        private int optional2 = 0;

        static {
            System.out.println("inner!");
        }
        public Builder(int r1, int r2) {
            this.required1 = r1;
            this.required2 = r2;
        }

        public Builder optional01(int val) {
            optional1 = val;
            return this;
        }

        public Builder optional02(int val) {
            optional2 = val;
            return this;
        }

        public BuilderOverConstructor build() {
            return new BuilderOverConstructor(this);
        }
    }
    public BuilderOverConstructor(Builder builder) {
        required1 = builder.required1;
        required2 = builder.required2;
        optional1 = builder.optional1;
        optional2 = builder.optional2;
    }

//    class InnerBuilder extends BuilderOverConstructor {
//        private int getOutterVar() {
//            BuilderOverConstructor bs = new BuilderOverConstructor();
//            return bs.num;
//        }
//        public void compare() {
//            BuilderOverConstructor boc = new BuilderOverConstructor();
//            BuilderOverConstructor.InnerBuilder in = boc.new InnerBuilder();
//            System.out.println(boc.num);
//            System.out.println(in.getOutterVar());
//            System.out.println(in.num);
//            System.out.println(in.hashCode());
//            System.out.println(in.toString());
//            System.out.println(boc.hashCode());
//            System.out.println(boc.toString());
//        }
//    }

    public static void main(String[] args) {
        //BuilderOverConstructor.InnerBuilder in = new BuilderOverConstructor().new InnerBuilder();
        //in.compare();
        BuilderOverConstructor.Builder bb = new BuilderOverConstructor.Builder(3, 4);

        BuilderOverConstructor.Builder bb2 = new BuilderOverConstructor.Builder(3, 4);

        System.out.println(bb.hashCode());
        System.out.println(bb2.hashCode());
    }

}
