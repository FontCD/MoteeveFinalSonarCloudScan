package logic.changeusername;

//BEAN CONTENENETE TUTTE LE INFORMAZIONI RELATIVE AL CAMBIO DI USERNAME
public class ChangeUsernameBean {
    //ATTRIBUTI
    private String oldName;
    private String newName;

    //METODI
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
