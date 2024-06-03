package Singleton;

import java.lang.reflect.Constructor;

public class SingletonR {


    private static SingletonR instance;

    private SingletonR() {

        System.out.println("creating instance...");
        if(instance!= null){
            throw new RuntimeException("Can't create instance. Please use getInsance() to create it");
        }

    }

    public static SingletonR getInstance() {

        if (instance == null) {

            instance = new SingletonR();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {

        SingletonR s1 = SingletonR.getInstance();
        SingletonR s2 = SingletonR.getInstance();

        System.out.println("HashCode of Object s1:" + s1.hashCode());
        System.out.println("HashCode of Object s2:" + s2.hashCode());


        Class<SingletonR> singletonClass = SingletonR.class;
        Constructor<SingletonR> constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonR s3 = constructor.newInstance();
        System.out.println("Hashcode of Object s3: " + s3.hashCode());


    }
}