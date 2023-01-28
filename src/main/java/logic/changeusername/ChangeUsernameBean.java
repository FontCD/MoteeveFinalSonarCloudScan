package logic.changeusername;

//BEAN THAT CONTAINS THE INFORMATION INVOLVED IN THE PROCESS OF CHANGING USERNAME
public class ChangeUsernameBean {
    //BUFFERS THAT WILL CONTAIN THE OLD USERNAME AND THE NEW USERNAME
    private String oldName;
    private String newName;

    //BEAN METHODS
    public String getOldName() {
        return this.oldName;
    }
    public void setOldName(String name) {
        this.oldName = name;
    }
    public String getNewName() {
        return this.newName;
    }
    public void setNewName(String name) {
        this.newName = name;
    }
}
