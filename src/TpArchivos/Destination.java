package TpArchivos;

public class Destination {

    private String code;
    private String description;

    public Destination(String code, String description) {
        this.code = code;
        this.description = description;
        checkCode();
        checkUtility();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private void checkCode(){
        String checkedCode = "";
        if(code.length()>3){
            for (int i = 0; i < 3; i++) {
                checkedCode += code.charAt(i);
            }
        }
        else{
            for (int i = code.length(); i < 3; i++) {
                checkedCode += " ";
            }
        }
        code = checkedCode;
    }

    private void checkUtility(){
        String checkedDescription = "";
        if(description.length()>30){
            for (int i = 0; i < 30; i++) {
                checkedDescription += description.charAt(i);
            }
        }
        else{
            for (int i = description.length(); i < 30; i++) {
                checkedDescription += " ";
            }
        }
        description = checkedDescription;
    }
}
