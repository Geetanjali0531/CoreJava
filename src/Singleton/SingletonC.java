package Singleton;

public class SingletonC  implements Cloneable{

    private static SingletonC instance;

    private SingletonC(){
        System.out.println("Creating instance...");
    }

    public static SingletonC getInstance(){
        if(instance==null){
            instance=new SingletonC();
        }
        return instance;
    }

    protected Object clone() throws CloneNotSupportedException {

        if(instance != null) {
            throw new CloneNotSupportedException("Can't create instance. Please use getInsance() to create it.");
        }

        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonC s1 = SingletonC.getInstance();
        SingletonC s2 = SingletonC.getInstance();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        SingletonC s3=(SingletonC)s2.clone();
        System.out.println(s3.hashCode());

    }


}
