public class Card {
    String value;
    String type;

    //Constructor
    public Card(String type, String value) {
        this.type = type;
        this.value = value;
    }

    //Converting the Object to String
    public String toString(){
        return  value + "-" + type;
    }
}
