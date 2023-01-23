package logic.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeUsernameDAOFS {

    public void updateUsernameInFS(String newUsername) {

        try {
            FileWriter writer = new FileWriter("C://Users//bruno//IdeaProjects//Test2//src//main//resources//usernameData.txt");
            writer.write(newUsername);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
