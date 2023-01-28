package logic.view.cliview;

import logic.Connectivity;
import logic.asktomoteeve.AskToMoteeveBooleanBean;
import logic.asktomoteeve.AskToMoteeveController;
import logic.asktomoteeve.AskToMoteeveMotPhrBean;
import logic.changetask.ChangeTaskBooleanBean;
import logic.changetask.ChangeTaskController;
import logic.changetask.ChangeTaskIdBean;
import logic.exceptions.InvalidStringException;
import logic.factory.BaseObject;
import logic.viewtasks.ViewTasksController;
import logic.viewtasks.ViewTasksListBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CLICoach {
    //-----------DATA------------------
    private Connection conn;
    private List<BaseObject> listTsk;

    //-----------SETUP INTERFACE-------------
    public void start() throws IOException, SQLException {
        Connectivity.setConnection();
        conn = Connectivity.getConn();
        setUpView();
        mainPage();
    }

    //SETUP DELLE PAGINE
    private void setUpView() {
        ViewTasksController controller = new ViewTasksController();
        ViewTasksListBean bean = controller.createTskList();
        this.listTsk = bean.getBean();
    }

    //-----------PAGES----------------------
    //STAMPA LA PAGINA PRINCIPALE
    private void mainPage() throws IOException, SQLException {
        System.out.println("\n\n");
        System.out.println("-----------------------MOTEEVE------------------------");
        System.out.println("1) CAMBIA UNA TASK\n2) INSERISCI UNA FRASE MOTIVAZIONALE\n3) EXIT");
        actionOnMainPage();
    }

    private void motivationalPhrasePage() throws IOException, SQLException, InvalidStringException {
        System.out.println("\n\n");
        System.out.println("-----------------------INSERISCI UNA FRASE MOTIVAZIONALE------------------------");

        AskToMoteeveController controller = new AskToMoteeveController();
        AskToMoteeveBooleanBean bean = controller.checkRequest();

        if (bean.getBean()) {
            System.out.println("\n\n1) INSERISCI\n2) BACK");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            switch (input){
                case "1":
                    actionOnMotivationalPhrasePage();
                    break;
                case "2":
                    pageDivider();
                    mainPage();
                    break;
                default:
                    motivationalPhrasePage();
            }
        } else {
            System.out.println("\n\nAl momento non hai alcuna richiesta, attendi che te ne arrivi una!\n\n1) BACK");
            BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
            String back = reader3.readLine();
            if (back.equals("1")){
                pageDivider();
                mainPage();
            } else{
                motivationalPhrasePage();
            }
        }
    }

    //DIVISORE (PER CREARE ORDINE NELL' INTERFACCIA CLI)
    private void pageDivider() {
        System.out.println("\n\n\n\n");
        System.out.println("-------------------------------------------------------");
        System.out.println("\n\n\n\n");
    }


    //-----------ACTIONONPAGES----------------
    //INPUT SULLA PAGINA PRINCIPALE
    private void actionOnMainPage() throws IOException, SQLException {
        System.out.println("\n\nInsert a number:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        switch (input) {
            case "1":
                pageDivider();
                changeTaskPage();
                break;
            case "2":
                pageDivider();
                actionOnMotivationalPhrasePage();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                actionOnMainPage();
        }

    }

    //INPUT SULLA PAGINA DI RICHIESTA PER FRASI MOTIVAZIONALI
    public void actionOnMotivationalPhrasePage() throws IOException, SQLException {
        AskToMoteeveController controller = new AskToMoteeveController();

        System.out.println("\n\nScrivi qui sotto");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String motPhrase = reader.readLine();

        try {
            AskToMoteeveMotPhrBean bean = new AskToMoteeveMotPhrBean();
            bean.setBean(motPhrase);
            controller.insertMotivationalPhrase(bean);
        } catch (InvalidStringException e) {
            e.invalidStringMessage();
            pageDivider();
            actionOnMotivationalPhrasePage();
        }

        System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\nMESSAGE:\nComplimenti! La tua frase è stata inviata!\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        pageDivider();
        mainPage();
    }

    //STAMPA LA PAGINA PER CAMBIARE TASK
    private void actionOnChangeTaskPage() throws IOException, SQLException {
        System.out.println("\n\nInsert a number");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int choose;
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            actionOnChangeTaskPage();
        }
        choose = Integer.parseInt(input);
            ChangeTaskController controller = new ChangeTaskController();
            ChangeTaskIdBean bean = new ChangeTaskIdBean();
            bean.setBean(choose);

            controller.changeTask(bean);
            pageDivider();
            mainPage();
    }

    //STAMPA LA PAGINA PER CAMBIARE TASK
    private void changeTaskPage() throws IOException, SQLException {
        System.out.println("-----------------------CAMBIA LA TASK------------------------");
        ChangeTaskController controller = new ChangeTaskController();
        ChangeTaskBooleanBean bean = controller.checkForATaskRequest();

        if (bean.getBean()){
            int i = 1;
            for (BaseObject tsk : listTsk) {
                if (tsk.getStatus()) {
                    System.out.println(i + ") QUESTA TASK È STATA GIÀ COMPLETATA DALL'UTENTE");
                } else {
                    System.out.println(i + ") " + tsk.getName() + ":  " + tsk.getScript());
                }
                i = i + 1;
            }
            System.out.println("\n" + i + ") BACK");
            actionOnChangeTaskPage();
        } else {
            System.out.println("\n\nAl momento non hai alcuna richiesta, attendi che te ne arrivi una!\n\n1) BACK");
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
            String back = reader2.readLine();
            if (back.equals("1")){
                pageDivider();
                mainPage();
            } else{
                changeTaskPage();
            }
        }

    }
}