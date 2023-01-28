package logic.view.cliview;

import logic.Connectivity;
import logic.asktomoteeve.AskToMoteeveBooleanBean;
import logic.asktomoteeve.AskToMoteeveController;
import logic.asktomoteeve.AskToMoteeveMotPhrBean;
import logic.changetask.ChangeTaskController;
import logic.changetask.ChangeTaskCardBean;
import logic.changetask.ChangeTaskIdBean;
import logic.changeusername.ChangeUsernameBean;
import logic.changeusername.ChangeUsernameCardBean;
import logic.changeusername.ChangeUsernameController;
import logic.completeachievement.CompleteAchievementAchievementBean;
import logic.completeachievement.CompleteAchievementController;
import logic.completeachievement.CompleteAchievementStickerListBean;
import logic.completetask.*;
import logic.exceptions.NoChangeException;
import logic.factory.BaseObject;
import logic.model.Card;
import logic.model.Sticker;
import logic.viewachievements.ViewAchievementController;
import logic.viewachievements.ViewAchievementListBean;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;
import logic.viewstickers.ViewStickerListBean;
import logic.viewstickers.ViewStickersController;
import logic.viewcurrenttasks.ViewCurrentTaskController;
import logic.viewcurrenttasks.ViewCurrentTaskListBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



public class CLIUser {

    //------------DATA----------
    private Connection conn;
    private List<BaseObject> listAch;
    private List<BaseObject> listTsk;

    private List<Sticker> listStk;

    private Card card;

    private static final String INSERTMESSAGE = "\n\nInsert a number:";

    //---------SETUP INTERFACE-----------
    public void start() throws IOException,SQLException {
        Connectivity.setConnection();
        conn = Connectivity.getConn();
        setUpView();
        mainPage();
    }

    private void setUpView() {
        setUpAchievements();
        setUpTasks();
        setUpStickers();
        setUpCard();
    }

    private void setUpCard() {
        ViewCardController controller = new ViewCardController();
        ViewCardUserBean bean = controller.createCard();
        card = bean.getBean();
    }

    private void setUpStickers() {
        ViewStickersController controller = new ViewStickersController();
        ViewStickerListBean bean = controller.createStkList();
        listStk = bean.getBean();
    }

    private void setUpTasks() {
        ViewCurrentTaskController controller = new ViewCurrentTaskController();
        ViewCurrentTaskListBean bean = controller.createTskList();
        listTsk = bean.getBean();
    }

    private void setUpAchievements()  {
        ViewAchievementController controller = new ViewAchievementController();
        ViewAchievementListBean bean = controller.createAchList();
        listAch = bean.getBean();
    }


    //------------PAGES-------------
    private void mainPage() throws IOException,SQLException {
        System.out.println("\n\n");
        System.out.println("-----------------------MOTEEVE------------------------");
        System.out.println("1) TASKS\n2) ACHIEVEMENTS\n3) PROFILE\n4) ASK TO MOTEEVE\n5) EXIT");
        actionOnMainPage();
    }

    //PROFILE PAGE PRINT
    private void profilePage() throws IOException,SQLException {
        System.out.println("--------PROFILE--------");
        System.out.println("USERNAME: " + card.getUserName() + "\nLEVEL: " + card.getLevel() + "\nEXP: " + card.getExp() + "\nCHANGES: " + card.getChange());
        int i = 1;
        System.out.println("--------CARD--------");
        for(Sticker stk: card.getSlots()){
            System.out.println(i + ") " + stk.getName());
            i = i + 1;
        }
        System.out.println("\n1) BACK");
        System.out.println("2) CHANGE USERNAME");
        actionOnProfilePage();
    }

    private void achievementPage() throws IOException,SQLException {
        System.out.println("--------ACHIEVEMENTS--------");
        int i = 1;
        for (BaseObject ach: listAch){
            if(ach.getScript().equals("Completato")){
                System.out.println(i +") " + ach.getName() + ": COMPLETATO");
            } else{
                System.out.println(i +") " + ach.getName() + ":  "+ ach.getScript());
            }
            i = i + 1;
        }
        System.out.println("\n" + i + ") BACK");
        actionOnAchievementPage();
    }

    private void taskPage() throws IOException,SQLException {
        System.out.println("--------TASKS--------");
        int i = 1;
        for (BaseObject tsk: listTsk){
            if (tsk.getStatus()){
                System.out.println(i +") NESSUNA TASK PRESENTE, CHIEDI A MOTEEVE DI DARTENE UN'ALTRA");
            } else{
                System.out.println(i +") " + tsk.getName() + ":  "+ tsk.getScript());
            }
            i = i + 1;
        }
        System.out.println("\n" + i + ") BACK");
        actionOnTaskPage();
    }

    private void askToMoteevePage() throws IOException,SQLException {
        System.out.println("--------ASK TO MOTEEVE--------");
        AskToMoteeveController controller = new AskToMoteeveController();
        AskToMoteeveBooleanBean boolBean = controller.checkForAPhrase();
        if (boolBean.getBean()) {
            AskToMoteeveMotPhrBean bean = controller.takeMotivationalPhrase();
            System.out.println("Moteeve ha una frase per te:\n\n");
            if(bean.getBean() == null){
                System.out.println("=(");
            } else {
                System.out.println(bean.getBean());
            }
        } else {
            System.out.println("\nMoteeve sta pensando ad una frase per te, attendi\n");
            controller.askMotivationalPhrase();
        }
        System.out.println("\n\n1) BACK");
        System.out.println(INSERTMESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while(!input.equals("1")){
            reader = new BufferedReader(new InputStreamReader(System.in));
            input = reader.readLine();
        }
        mainPage();

    }

    private void pageDivider(){
        System.out.println("\n\n\n\n");
        System.out.println("-------------------------------------------------------");
        System.out.println("\n\n\n\n");
    }



    //----------------ACTIONONPAGES---------------
    private void actionOnMainPage() throws IOException,SQLException {
        System.out.println(INSERTMESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        switch (input) {
            case "1" -> {
                pageDivider();
                taskPage();
            }
            case "2" -> {
                pageDivider();
                achievementPage();
            }
            case "3" -> {
                pageDivider();
                profilePage();
            }
            case "4" -> {
                pageDivider();
                askToMoteevePage();
            }
            case "5" -> {
                Connectivity.disconnect(conn);
                System.exit(0);
            }
            default -> actionOnMainPage();
        }

    }

    private void actionOnAchievementPage() throws IOException,SQLException {
        System.out.println(INSERTMESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int choose;
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            actionOnTaskPage();
        }
        choose = Integer.parseInt(input);

        if (choose <= listAch.size() && !listAch.get(choose-1).getScript().equals("Completato")){
            System.out.println("\n\nHai selezionato l'achievement: " + choose+ "\nVuoi completarlo?\n1) Si\n2) No");
            achievementSubMenu(choose);

        } else if(choose == listAch.size() +1) {
            pageDivider();
            mainPage();
        } else {
            actionOnAchievementPage();
        }
    }

    private void achievementSubMenu(int choose) throws IOException,SQLException {
        System.out.println(INSERTMESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        switch (input) {
            case "1" -> {
                CompleteAchievementController controller = new CompleteAchievementController();
                CompleteAchievementAchievementBean bean1 = new CompleteAchievementAchievementBean();
                bean1.setBean(listAch.get(choose - 1));
                CompleteAchievementStickerListBean bean2 = new CompleteAchievementStickerListBean();
                bean2.setBean(listStk);
                controller.unlockAchievement(bean1, bean2);
                pageDivider();
                achievementPage();
            }
            case "2" -> {
                pageDivider();
                achievementPage();
            }
            default -> achievementSubMenu(choose);
        }

    }

    private void actionOnTaskPage() throws IOException,SQLException {
        System.out.println(INSERTMESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int choose;
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            actionOnTaskPage();
        }

        choose = Integer.parseInt(input);
        if (choose <= listTsk.size() && !listTsk.get(choose-1).getStatus()) {
            System.out.println("\n\nHai selezionato la task: " + choose + "\nCosa vuoi fare?\n1) Cambia la task\n2) Completa la task\n3) BACK");
            taskSubMenu(choose);

        }else if(choose <= listTsk.size() && listTsk.get(choose-1).getStatus()) {
            ChangeTaskCardBean cTaskCardBean = new ChangeTaskCardBean();
            cTaskCardBean.setBean(card);
            ChangeTaskIdBean newIdBean = new ChangeTaskIdBean();
            newIdBean.setBean(choose);

            try{
                ChangeTaskController controller1 = new ChangeTaskController();
                controller1.askForAChange(cTaskCardBean,newIdBean);
                System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\nMESSAGE:\nLa tua richiesta di cambio Task è stata inviata a Moteeve!\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            } catch (NoChangeException e) {
                e.noChangeMessage();
            }

            pageDivider();
            taskPage();

        }else if(choose == listTsk.size() +1 ){
            pageDivider();
            mainPage();

        } else{
            actionOnTaskPage();
        }
    }

    private void taskSubMenu(int choose) throws IOException, SQLException {
        System.out.println(INSERTMESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        switch (input) {
            case "1" -> {
                ChangeTaskCardBean cTaskCardBean = new ChangeTaskCardBean();
                cTaskCardBean.setBean(card);
                ChangeTaskIdBean idToChangeBean = new ChangeTaskIdBean();
                idToChangeBean.setBean(choose);
                try{
                    ChangeTaskController controller1 = new ChangeTaskController();
                    controller1.askForAChange(cTaskCardBean, idToChangeBean);
                    System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\nMESSAGE:\nLa tua richiesta di cambio Task è stata inviata a Moteeve!\nNOTA: Se proverai a cambiare un'altra Task questa richiesta sarà cancellata!\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                } catch (NoChangeException e){
                    e.noChangeMessage();
                }
                pageDivider();
                taskPage();
            }
            case "2" -> {
                CompleteTaskTaskBean taskBean1 = new CompleteTaskTaskBean();
                taskBean1.setBean(listTsk.get(choose - 1));
                CompleteTaskUserBean cardBean = new CompleteTaskUserBean();
                cardBean.setBean(card);
                CompleteTaskIdCurrentBean idBean = new CompleteTaskIdCurrentBean();
                idBean.setBean(choose);
                CompleteTaskController controller2 = new CompleteTaskController();
                controller2.endTask(taskBean1, cardBean, idBean);
                pageDivider();
                taskPage();
            }
            case "3" -> {
                pageDivider();
                taskPage();
            }
            default -> taskSubMenu(choose);
        }
    }

    //DO AN ACTION ON THE PROFILE PAGE
    private void actionOnProfilePage() throws IOException,SQLException {
        System.out.println(INSERTMESSAGE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        switch (input) {
            case "1" -> {
                pageDivider();
                mainPage();
            }
            case "2" -> {
                ChangeUsernameController controller = new ChangeUsernameController();
                ChangeUsernameBean retBean;

                pageDivider();
                System.out.println("\nInserire nuovo Username");
                String newUsername = reader.readLine();

                ChangeUsernameCardBean cardBean = new ChangeUsernameCardBean();
                cardBean.setBean(card);

                ChangeUsernameBean insBean = new ChangeUsernameBean();
                insBean.setNewName(newUsername);


                retBean = controller.setNewUsername(insBean, cardBean);

                System.out.println("Il vecchio username [" + retBean.getOldName() + "] è stato cambiato con [" + retBean.getNewName() + "]");
                profilePage();

            }
            default -> actionOnProfilePage();
        }
    }

}


