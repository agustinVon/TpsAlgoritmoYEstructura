package TpArchivos;

public class Destination {

    private String destinationCode;
    private String description;

    public Destination(String destinationCode, String description) {
        this.destinationCode = destinationCode;
        this.description = description;
    }

    public String getDestinationCode() {
        destinationCodeUtility();
        return destinationCode;
    }

    public String getDescription() {
        descriptionUtility();
        return description;
    }

    private void destinationCodeUtility(){
        String checkedCode = "";
        if(destinationCode.length()>3){
            for (int i = 0; i < 3; i++) {
                checkedCode += destinationCode.charAt(i);
            }
        }
        else{
            for (int i = destinationCode.length(); i < 3; i++) {
                checkedCode += " ";
            }
        }
        destinationCode = checkedCode;
    }

    private void descriptionUtility(){
        String checkedDescription = "";
        if(description.length()>20){
            for (int i = 0; i < 100; i++) {
                checkedDescription += description.charAt(i);
            }
        }
        else{
            for (int i = description.length(); i < 20; i++) {
                checkedDescription += " ";
            }
        }
    }
}
