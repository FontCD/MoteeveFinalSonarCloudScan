package logic.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//DAO RELATIVO ALLA GESTIONE DELLA PERSISTENZA DELLA CARD (IN PARTICOLARE DELLO USERNAME) SU FILE SYSTEM
public class CardDAOFS {

    //METODO CHE ESTRAE IL VECCHIO USERNAME DAL FILE DESIGNATO
    public String extractNameFS() {

        StringBuilder username = new StringBuilder();

        //RECUPERO DATI DAL FILE usernameData.txt
        try {

            FileReader reader = new FileReader("C://Users//bruno//IdeaProjects//Test2//src//main//resources//usernameData.txt");
            int data = reader.read();
            while (data != -1) {
                username.append((char)data);
                data = reader.read();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //RITORNA LO USERNAME RECUPERATO
        return (username.toString());

    }

    //METODO PER AGGIORNARE SUL FILE usernameData.txt
    public void replaceNameFS(String newName) {
        //SOVRASCRITTURA DEL VECCHIO USERNAME A FAVORE DI QUELLO NUOVO
        try {
            FileWriter writer = new FileWriter("C://Users//bruno//IdeaProjects//Test2//src//main//resources//usernameData.txt");
            writer.write(newName);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
