package org.example.aad_serialization_and_deserialization.Serializing_and_Deserializing;

import org.example.aad_serialization_and_deserialization.Person.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonSerializer {
    public static void main(String[] args) {
        try{
            Person person = new Person("Kamal", "GDSE", 21);

            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\kusal\\OneDrive\\Desktop\\Serialized_Objects\\person.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Person stored in Desktop\\Serialized_Objects\\person.txt");
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\kusal\\OneDrive\\Desktop\\Serialized_Objects\\person.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person person =(Person) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(person.toString());
        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
