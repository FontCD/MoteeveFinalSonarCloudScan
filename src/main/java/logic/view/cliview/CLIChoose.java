package logic.view.cliview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class CLIChoose {
    public void firstPage() throws IOException, SQLException {
        System.out.println("\n\n");
        System.out.println("-----------------------MOTEEVE------------------------");
        System.out.println("\nCOME VUOI ACCEDERE?\n1) User\n2) Coach\n3) BACK");
        actionOnFirstPage();
    }

    private void actionOnFirstPage() throws IOException, SQLException {
        System.out.println("\n\nInsert a number:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        switch (input) {
            case "1":
                CLIUser cliUser = new CLIUser();
                cliUser.start();
                break;
            case "2":
                CLICoach cliCoach = new CLICoach();
                cliCoach.start();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                actionOnFirstPage();
        }
    }
}
