package Singleton;

import java.io.*;

public class SingletonS implements Serializable {

    private static SingletonS instance ;

    private SingletonS(){

        System.out.println("Creating instance");
    }

    public static SingletonS getInstance(){

        if(instance==null){
            instance = new SingletonS();
        }
        return instance;
    }

    private Object readResolve(){
        System.out.println("Applying readResolve()...");
        return SingletonS.getInstance();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SingletonS s1=SingletonS.getInstance();
        SingletonS s2=SingletonS.getInstance();

        System.out.println("HashCode of Object s1:" + s1.hashCode());
        System.out.println("HashCode of Object s2:" + s2.hashCode());

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s2);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois= new ObjectInputStream(fis);
        SingletonS s3=(SingletonS) ois.readObject();

        System.out.println("HashCode of Object s3:"+s3.hashCode());

    }

}
