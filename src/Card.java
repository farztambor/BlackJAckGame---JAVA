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
    public int getValue(){
        if("AJKQK".contains(value)){ // ACJQK
            if(value.equals("A")){
                return  11;
            }
            return 10;
        }
        return Integer.parseInt(value); //2-10
    }

    public boolean isAce(){
        return value.equals("A");
    }
}
