package 注解和反射.反射;

public class CloneTest implements Cloneable{
    public Object o;
    CloneTest(Object o){
        this.o = o;
    }

    @Override
    protected CloneTest clone() throws CloneNotSupportedException {
        return (CloneTest) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest cloneTest = new CloneTest(new Object());
        CloneTest c = cloneTest.clone();
        System.out.println();
    }
}
