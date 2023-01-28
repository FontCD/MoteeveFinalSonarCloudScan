package logic.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CardDAOFS {

    public String extractNameFS() {

        StringBuilder username = new StringBuilder();

        try {

            FileReader reader = new FileReader("C://Users//bruno//IdeaProjects//Test2//src//main//resources//usernameData.txt");
            int data = reader.read();
            while (data != -1) {
                username.append((char)data);
                data = reader.read();
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("ERROR IN FILE SYSTEM PERSISTENCE");
        }

        return (username.toString());

    }

    public void replaceNameFS(String newName) {

        try {
            FileWriter writer = new FileWriter("C://Users//bruno//IdeaProjects//Test2//src//main//resources//usernameData.txt");
            writer.write(newName);
            writer.close();
        } catch (IOException e) {
            System.err.println("ERROR IN FILE SYSTEM PERSISTENCE");
        }

    }

}
