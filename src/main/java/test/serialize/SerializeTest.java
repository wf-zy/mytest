package test.serialize;

import test.test.User;

import java.io.*;

/**
 * @Author xiongyong
 * @Date 2021/1/8
 */

public class SerializeTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user = new User();
        user.setId(1);
        user.setName("ssssssss");

        String path = "D:\\ideaworkspace\\mytest\\src\\main\\java\\test\\serialize\\a.txt";
       /* ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(user);
*/

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        User user1 = (User) objectInputStream.readObject();
        System.out.println(user1.getId2());
        System.out.println(user1);


    }
}
