package logic.view.fxview;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import logic.Connectivity;
import logic.asktomoteeve.AskToMoteeveBooleanBean;
import logic.asktomoteeve.AskToMoteeveController;
import logic.asktomoteeve.AskToMoteeveMotPhrBean;
import logic.changetask.ChangeTaskCardBean;
import logic.changetask.ChangeTaskController;
import logic.changetask.ChangeTaskIdBean;
import logic.changeusername.ChangeUsernameBean;
import logic.changeusername.ChangeUsernameCardBean;
import logic.changeusername.ChangeUsernameController;
import logic.completeachievement.CompleteAchievementAchievementBean;
import logic.completeachievement.CompleteAchievementController;
import logic.completeachievement.CompleteAchievementStickerListBean;
import logic.completetask.CompleteTaskController;
import logic.completetask.CompleteTaskIdCurrentBean;
import logic.completetask.CompleteTaskTaskBean;
import logic.completetask.CompleteTaskUserBean;
import logic.exceptions.InvalidStringException;
import logic.exceptions.NoChangeException;
import logic.factory.BaseObject;
import logic.model.Card;
import logic.model.Sticker;
import logic.viewachievements.ViewAchievementController;
import logic.viewachievements.ViewAchievementListBean;
import logic.viewcurrenttasks.ViewCurrentTaskController;
import logic.viewcurrenttasks.ViewCurrentTaskListBean;
import logic.viewstickers.ViewStickerListBean;
import logic.viewstickers.ViewStickersController;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static List<BaseObject> achList;

    private static List<BaseObject> tskList;
    private static List<Sticker> stkList;

    private static Card card;


    //-----------------------------------------BUTTONS
    @FXML
    private Button dailyTask1;
    @FXML
    private Button dailyTask2;
    @FXML
    private Button dailyTask3;
    @FXML
    private Button dailyTask4;
    @FXML
    private Button weeklyTask1;
    @FXML
    private Button weeklyTask2;

    //setText,setColo,setStyle,completeAchiementTry

    //-----------------------------------------LABELS
    @FXML
    private Label askToMoteeveLabel;
    @FXML
    private Label taskNotificationObserverLabel;

    @FXML
    private Label achNotificationObserverLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label experienceLabel;

    @FXML
    private Label completeTaskRewardLabel;

    @FXML
    private Label completeAchievementRewardLabel;

    //---------------------------------------IMAGE VIEWS
    @FXML
    private ImageView cardView;

    @FXML
    private ImageView profilePic;

    @FXML
    private ImageView slot1;

    @FXML
    private ImageView slot2;

    @FXML
    private ImageView slot3;

    @FXML
    private ImageView slot4;

    @FXML
    private ImageView slot5;

    @FXML
    private ImageView slot6;

    @FXML
    private ImageView slot7;

    @FXML
    private ImageView slot8;
    @FXML
    private final List<ImageView> slotImage = new ArrayList<>() {{add(slot1); add(slot2); add(slot3); add(slot4); add(slot4); add(slot5); add(slot6); add(slot7); add(slot8); }};
    //---------------------------------------LIST VIEWS
    @FXML
    private ListView<String> availableStickersListView;

    @FXML
    private ListView<String> slotsListView;

    private List<String> slotList = new ArrayList<>(){{add("Slot1"); add("Slot2"); add("Slot3"); add("Slot4"); add("Slot5"); add("Slot6"); add("Slot7"); add("Slot8"); add("Remove all stickers");}};

    private String currentSlots;
    private String finalUrl;

    @FXML
    private ListView<String> achListView;


    //---------------------------------------TEXT FIELDS
    @FXML
    private TextField usernameTextField;

    //---------------------------------------DIALOG PANES
    @FXML
    public static DialogPane actorSelectionDialogPane;
    @FXML
    public static DialogPane taskNotificationObserverDialogPane;
    @FXML
    public static DialogPane achNotificationObserverDialogPane;
    @FXML
    private DialogPane noSlotSelectedDialogPane ;

    @FXML
    private DialogPane startingMessageDialogPane;
    @FXML
    private DialogPane logoutDialogPane;

    @FXML
    private DialogPane askMoteeveDialogPane;

    @FXML
    private DialogPane changeUsernameDialogPane;

    @FXML
    private DialogPane completeTaskDialogPane;

    @FXML
    private DialogPane completeAchievementDialogPane;

    @FXML
    private DialogPane noAchievementSelectedDialogPane;
    @FXML
    private DialogPane customizeProfileDialogPane;

    @FXML
    private DialogPane selectStickerDialogPane;

    @FXML
    private DialogPane noStickerSelectedDialogPane;

    @FXML
    private DialogPane selectSlotDialogPane;

    @FXML
    private DialogPane noSlotSelected;

    //------------------------------------------------------STARTING SETUP
    public static void setUp() {
        setAchievementLIst();
        setTaskList();
        setStickerList();
        setCard();
    }
    private static void setAchievementLIst()  {
        ViewAchievementController controller = new ViewAchievementController();
        ViewAchievementListBean bean = controller.createAchList();
        achList = bean.getBean();
    }
    private static void setTaskList() {
        ViewCurrentTaskController controller = new ViewCurrentTaskController();
        ViewCurrentTaskListBean bean = controller.createTskList();
        tskList = bean.getBean();
    }
    private static void setStickerList()  {
        ViewStickersController controller = new ViewStickersController();
        ViewStickerListBean bean = controller.createStkList();
        stkList = bean.getBean();
    }
    private static void setCard()  {
           ViewCardController controller = new ViewCardController();
           ViewCardUserBean bean = controller.createCard();
           card = bean.getBean();
    }



    //-----------------------------------------------------MANAGEMENT
    public void setAllDialogPanesInvisible() {

        noStickerSelectedDialogPane.setVisible(false);
        logoutDialogPane.setVisible(false);
        askMoteeveDialogPane.setVisible(false);
        changeUsernameDialogPane.setVisible(false);
        customizeProfileDialogPane.setVisible(false);
        selectStickerDialogPane.setVisible(false);
        selectSlotDialogPane.setVisible(false);

    }

    //-----------------------------------------------------STAGE SWITCH
    @FXML
    public void switchToProfileScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("profileScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mainScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAchievementScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("achievementScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void putOffStartingMessage(){
        usernameLabel.setText(card.getUserName());
        experienceLabel.setText(String.valueOf(card.getExp()));
        levelLabel.setText(String.valueOf(card.getLevel()));

       int i = 1 ;
        for (Sticker stk: card.getSlots()) {
                if(stk.getName().equals("Vuoto")) {
            }else{
                applicateStickerToSlot("Slot" + i,stk.getStickerUrl());
            }
                i= i+1;
        }

        Circle clip = new Circle(profilePic.getFitWidth());
        clip.setRadius(50.0);
        clip.setCenterX(profilePic.getX() + 50);
        clip.setCenterY(profilePic.getY() + 50);
        profilePic.setClip(clip);

        Image myPic = new Image(card.getProfileImage());
        profilePic.setImage(myPic);

        startingMessageDialogPane.setVisible(false);
    }

    @FXML
    public void refreshAchievementPage(){
        if (!completeAchievementDialogPane.isVisible()) {
            achListView.getItems().clear();
            for(BaseObject ach: achList){
                if(ach!=null){
                    achListView.getItems().addAll(ach.getScript());
                }
            }
        }
    }

    @FXML
    public void switchToCoachScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("coachScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //-------------TASK PAGE-----------------

    @FXML
    public void refreshTaskPage() {
        int i = 1;
        for(BaseObject tsk: tskList) {
            showTask("Task" + tsk.getId());
            i = i + 1;
        }
    }
    public void showTask(String index){
        String message = "NESSUNA TASK PRESENTE, CHIEDI A MOTEEVE DI DARTENE UNA NUOVA!";
        String baseColor = "-fx-background-color: white";


        switch (index) {

            case "Task1":

                if (tskList.get(0).getStatus()) {
                    dailyTask1.setText(message);
                    dailyTask1.setStyle(baseColor);

                } else {
                    dailyTask1.setText(tskList.get(0).getScript());
                    dailyTask1.setStyle("-fx-background-color: " + tskList.get(0).getColor());
                }

            case "Task2":

                if (tskList.get(1).getStatus()) {
                    dailyTask2.setText(message);
                    dailyTask2.setStyle(baseColor);
                } else {
                    dailyTask2.setText(tskList.get(1).getScript());
                    dailyTask2.setStyle("-fx-background-color: " + tskList.get(1).getColor());
                }

            case "Task3":

                if (tskList.get(2).getStatus()) {
                    dailyTask3.setText(message);
                    dailyTask3.setStyle(baseColor);
                } else {
                    dailyTask3.setText(tskList.get(2).getScript());
                    dailyTask3.setStyle("-fx-background-color: " + tskList.get(2).getColor());
                }

            case "Task4":

                if (tskList.get(3).getStatus()) {
                    dailyTask4.setText(message);
                    dailyTask4.setStyle(baseColor);
                } else {
                    dailyTask4.setText(tskList.get(3).getScript());
                    dailyTask4.setStyle("-fx-background-color: " + tskList.get(3).getColor());
                }

            case "Task5":

                if (tskList.get(4).getStatus()) {
                    weeklyTask1.setText(message);
                    weeklyTask1.setStyle(baseColor);
                } else {
                    weeklyTask1.setText(tskList.get(4).getScript());
                    weeklyTask1.setStyle("-fx-background-color: " + tskList.get(4).getColor());
                }

            case "Task6":

                if (tskList.get(5).getStatus()) {
                    weeklyTask2.setText(message);
                    weeklyTask2.setStyle(baseColor);
                } else {
                    weeklyTask2.setText(tskList.get(5).getScript());
                    weeklyTask2.setStyle("-fx-background-color: " + tskList.get(5).getColor());
                }
        }

    }
    //-------------------------------------------------CHANGE USERNAME
    @FXML
    public void changeUsernameTry() {
        setAllDialogPanesInvisible();
        changeUsernameDialogPane.setVisible(true);
    }

    @FXML
    public void changeUsernameFail() {
        changeUsernameDialogPane.setVisible(false);
    }

    @FXML
    public void changeUsernameSuccess() throws SQLException {
        String username = usernameTextField.getText();
        ChangeUsernameController controller = new ChangeUsernameController();

        ChangeUsernameBean bean = new ChangeUsernameBean();
        bean.setNewName(username);

        ChangeUsernameCardBean cardBean = new ChangeUsernameCardBean();
        cardBean.setBean(card);

        controller.setNewUsername(bean,cardBean);

        usernameLabel.setText(card.getUserName());

        changeUsernameDialogPane.setVisible(false);
    }

    //-----------------------------------------------------ASK MOTEEVE
    @FXML
    public void askMoteeveTry() {
        setAllDialogPanesInvisible();
        askMoteeveDialogPane.setVisible(true);
        AskToMoteeveController controller = new AskToMoteeveController();
        AskToMoteeveBooleanBean bean = controller.checkForAPhrase();
        if (!bean.getBean()){
            askToMoteeveLabel.setText("Moteeve sta pensando ad una frase per te!");
            controller.askMotivationalPhrase();
        } else{
            try{
                AskToMoteeveMotPhrBean bean2 = controller.takeMotivationalPhrase();
                if (bean2.getBean() == null){
                    throw new InvalidStringException();
                }
                askToMoteeveLabel.setText(bean2.getBean());
            }catch (InvalidStringException e){
                e.invalidStringMessage();
                askToMoteeveLabel.setText("=(");
            }
        }
    }

    @FXML
    public void askMoteeveSuccess() {
        askMoteeveDialogPane.setVisible(false);
    }

    //------------------------------------------------------LOGOUT
    @FXML
    public void logoutTry() {
        setAllDialogPanesInvisible();
        logoutDialogPane.setVisible(true);
    }

    @FXML
    public void logoutFail() {
        logoutDialogPane.setVisible(false);
    }

    @FXML
    public void logoutSuccess() {
        Connectivity.disconnect(Connectivity.getConn());
        System.exit(0);
    }

    //------------------------------------------------------COMPLETE TASK

    private int tskIndex;
    private String startingMessage = "Rewards: ";
    private String endMessage = " experience points";
    @FXML
    public void completeDailyTask1Try() {
        tskIndex = 1;
        if(!tskList.get(tskIndex-1).getStatus()) {
            completeTaskDialogPane.setVisible(true);
            completeTaskRewardLabel.setText(startingMessage + tskList.get(0).getReward() + endMessage);
        }
    }
    @FXML
    public void completeDailyTask2Try() {
        tskIndex = 2;
        if(!tskList.get(tskIndex-1).getStatus()) {
            completeTaskDialogPane.setVisible(true);
            completeTaskRewardLabel.setText(startingMessage + tskList.get(1).getReward() + endMessage );
        }
    }
    @FXML
    public void completeDailyTask3Try() {
        tskIndex = 3;
        if (!tskList.get(tskIndex - 1).getStatus()) {
            completeTaskDialogPane.setVisible(true);
            completeTaskRewardLabel.setText(startingMessage + tskList.get(2).getReward() + endMessage );
        }
    }
    @FXML
    public void completeDailyTask4Try() {
        tskIndex = 4;
        if (!tskList.get(tskIndex - 1).getStatus()) {
            completeTaskDialogPane.setVisible(true);
            completeTaskRewardLabel.setText(startingMessage + tskList.get(3).getReward() + endMessage );
        }
    }

    @FXML
    public void completeWeeklyTask1Try() {
        tskIndex = 5;
        if(!tskList.get(tskIndex-1).getStatus()) {
            completeTaskDialogPane.setVisible(true);
            completeTaskRewardLabel.setText(startingMessage + tskList.get(4).getReward() + endMessage );
        }
    }
    @FXML
    public void completeWeeklyTask2Try() {
        tskIndex = 6;
        if(!tskList.get(tskIndex-1).getStatus()){
            completeTaskDialogPane.setVisible(true);
            completeTaskRewardLabel.setText(startingMessage + tskList.get(5).getReward() +endMessage );
        }
    }

    @FXML
    public void completeTaskFail() {
        completeTaskDialogPane.setVisible(false);
    }

    @FXML
    public void changeTask() throws NoChangeException {


        ChangeTaskController controller = new ChangeTaskController();

        ChangeTaskCardBean cardBean = new ChangeTaskCardBean();
        cardBean.setBean(card);
        ChangeTaskIdBean idBean = new ChangeTaskIdBean();
        idBean.setBean(tskIndex);

        controller.askForAChange(cardBean,idBean);

    }

    @FXML
    public void completeTaskSuccess() {
            CompleteTaskController controller = new CompleteTaskController();


            CompleteTaskTaskBean taskBean = new CompleteTaskTaskBean() ;
            taskBean.setBean(tskList.get(tskIndex-1));

            CompleteTaskUserBean userBean = new CompleteTaskUserBean();
            userBean.setBean(card);

            CompleteTaskIdCurrentBean idCurrentBean = new CompleteTaskIdCurrentBean();
            idCurrentBean.setBean(tskIndex);

            controller.endTask(taskBean, userBean, idCurrentBean);

            showTask("Task" + tskIndex);
            completeTaskDialogPane.setVisible(false);
    }

    //-----------------------------------------------------COMPLETE ACHIEVEMENTS

    private int achIndex;
    @FXML
    public void completeAchievementTry() {
        try{
            int index = achListView.getSelectionModel().getSelectedIndex();
            achIndex = achList.get(index).getId();
            if(!achList.get(index).getScript().equals("Completato") && achList.get(index).getStatus() ) {
                completeAchievementRewardLabel.setText("You will receive a new sticker");
                completeAchievementDialogPane.setVisible(true);
            }
        }catch(IndexOutOfBoundsException e){
            noAchievementSelectedDialogPane.setVisible(true);
        }
    }

    @FXML
    public void completeAchievementFail() {
        completeAchievementDialogPane.setVisible(false);
        noAchievementSelectedDialogPane.setVisible(false);
    }

    @FXML
    public void completeAchievementSuccess() throws Exception {

        CompleteAchievementAchievementBean bean1 = new CompleteAchievementAchievementBean() ;
        bean1.setBean(achList.get(achIndex-1));

        CompleteAchievementStickerListBean bean2 = new CompleteAchievementStickerListBean();
        bean2.setBean(stkList);

        CompleteAchievementController controller = new CompleteAchievementController() ;
        controller.unlockAchievement(bean1,bean2) ;

        completeAchievementDialogPane.setVisible(false);
    }

    //------------------------------------------------CUSTOMIZE PROFILE
    @FXML
    public void customizeProfileTry() {
        setAllDialogPanesInvisible();
        customizeProfileDialogPane.setVisible(true);
    }

    @FXML
    public void customizeProfileFail() {
        customizeProfileDialogPane.setVisible(false);
    }

    @FXML
    public void changeProfilePic() {

        //FILE SELECTION
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Images", "*.png");
        chooser.setTitle("Select new profile pic (must be png format)");
        chooser.getExtensionFilters().addAll(extFilter1);
        File selectedFile = chooser.showOpenDialog(stage);

        //AFTER FILE SELECTION
        if (selectedFile != null) {

            Circle clip = new Circle(profilePic.getFitWidth());
            clip.setRadius(50.0);
            clip.setCenterX(profilePic.getX() + 50);
            clip.setCenterY(profilePic.getY() + 50);
            profilePic.setClip(clip);

            Image myPic = new Image(selectedFile.getPath());
            profilePic.setImage(myPic);
            setAllDialogPanesInvisible();

        }

    }

    @FXML
    public void addStickersToCardTry() {

        setAllDialogPanesInvisible();
        selectStickerDialogPane.setVisible(true);
        availableStickersListView.getItems().clear();


        for(Sticker stk : stkList) {
                if (stk.getStatus()) {
                    availableStickersListView.getItems().addAll(stk.getName());
                }
            }
        }


    @FXML
    public void addStickersToCardFail() {
        setAllDialogPanesInvisible();
        customizeProfileDialogPane.setVisible(true);
    }

    @FXML
    public void addStickersToCardSuccess() {
        try{
            int index = availableStickersListView.getSelectionModel().getSelectedIndex();
            finalUrl = stkList.get(index).getStickerUrl();
            selectSlotTry();
        }catch(IndexOutOfBoundsException e){
            noStickerSelectedDialogPane.setVisible(true);
        }

    }

    @FXML
    public void noStickerSelected() {
        noStickerSelectedDialogPane.setVisible(false);
    }

    @FXML
    public void selectSlotTry() {
        setAllDialogPanesInvisible();
        selectSlotDialogPane.setVisible(true);
        slotsListView.getItems().clear();
        slotsListView.getItems().addAll(slotList);
    }

    @FXML
    public void selectSlotFail() {
        setAllDialogPanesInvisible();
        selectStickerDialogPane.setVisible(true);
    }

    @FXML
    public void selectSlotSuccess() {

        try{
            int index = slotsListView.getSelectionModel().getSelectedIndex();
            String mySlot = slotList.get(index);
            applicateStickerToSlot(mySlot, finalUrl);
        }catch(IndexOutOfBoundsException e){
            noSlotSelectedDialogPane.setVisible(true);
        }
    }
    @FXML
    public void noSlotSelected(ActionEvent actionEvent) {
        noSlotSelectedDialogPane.setVisible(false);
    }

    public void applicateStickerToSlot(String mySlot,String finalUrl) {

        //RETRIEVE STICKER URL SEARCHING BY NAME IN THE DB
        Image stickerToAdd = new Image(finalUrl);

        switch (mySlot) {

            case "Slot1":
                slot1.setImage(stickerToAdd);
                break;
            case "Slot2":
                slot2.setImage(stickerToAdd);
                break;
            case "Slot3":
                slot3.setImage(stickerToAdd);
                break;
            case "Slot4":
                slot4.setImage(stickerToAdd);
                break;
            case "Slot5":
                slot5.setImage(stickerToAdd);
                break;
            case "Slot6":
                slot6.setImage(stickerToAdd);
                break;
            case "Slot7":
                slot7.setImage(stickerToAdd);
                break;
            case "Slot8":
                slot8.setImage(stickerToAdd);
                break;
            case "Remove all stickers":
                slot1.setImage(null);
                slot2.setImage(null);
                slot3.setImage(null);
                slot4.setImage(null);
                slot5.setImage(null);
                slot6.setImage(null);
                slot7.setImage(null);
                slot8.setImage(null);
            default :
                System.out.println("Error");
                break;
        }
        setAllDialogPanesInvisible();
    }
}
