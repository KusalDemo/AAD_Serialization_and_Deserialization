package org.example.aad_serialization_and_deserialization.Serializing_and_Deserializing;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.example.aad_serialization_and_deserialization.Person.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersonSerializer {
    public static void main(String[] args) {
//        Serialization to .txt & Deserialization
        try {
            Person person = new Person("Kamal", "GDSE", 21);

            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\kusal\\OneDrive\\Desktop\\Serialized_Objects\\person.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Person stored in Desktop\\Serialized_Objects\\person.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\kusal\\OneDrive\\Desktop\\Serialized_Objects\\person.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person person = (Person) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
//===========================================================================================================
//        Serialization to .json & Deserialization
        try {
            Person person = new Person("Saman", "CMJD", 25);

            String filePath = "C:\\Users\\kusal\\OneDrive\\Desktop\\Serialized_Objects\\person.json";
            Jsonb jsonb = JsonbBuilder.create();
            String json = jsonb.toJson(person);
            Files.write(Paths.get(filePath), json.getBytes());

            System.out.println("Serialized data stored in : " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            String filePath = "C:\\Users\\kusal\\OneDrive\\Desktop\\Serialized_Objects\\person.json";

            String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
            Jsonb jsonb = JsonbBuilder.create();
            Person deserializedPerson = jsonb.fromJson(jsonString, Person.class);

            System.out.println(deserializedPerson.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
