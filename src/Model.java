import java.util.ArrayList;
import java.util.HashMap;

public class Model {


    ArrayList<String> data = new ArrayList<>();
    Double Total = 0.00;
    Double calcChange;
    HashMap<String, Double> shoppingCart = new HashMap<>();

    //used to loop through the array
    public Integer getArrayCount() {

        return data.size();
    }

    //returns all data from the array
    public ArrayList<String> getData() {
        return data;
    }


    //calculates price from position in file
    public Double getItemPrice(String itemId) {
        Double itemPrice = null;

        for (int index = 0; index < data.size(); index++) {
            String i = data.get(index);

            if (i.equals(itemId)) {
                itemPrice = Double.parseDouble(data.get(index + 2));

            }
        }
        return itemPrice;

    }

//used to create the final price
    public void setPrice(Double price){

        Total =+ price;
    }

    public Double getPrice(){

        return Total;
    }

    public void calcChange(Double Total, Double Given){

        calcChange = Given - Total;

    }

    public Double getCalcChange(){
        return calcChange;
    }


}

