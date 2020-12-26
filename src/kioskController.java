import javax.swing.*;

public class kioskController {

    private kioskView view;
    private kiosk model;

    public kioskController(kiosk model, kioskView view){
        this.model = model;
        this.view = view;
    }

    public void initApp(){

       view.initApp();

    }

    public String getStockCount(){
        return model.stockCount;
    }

    public void setStockCount(String stockCount){
        model.setStockCount(stockCount);
    }

    public String getItemID(){
        return model.itemID;
    }

    public void setItemID(String itemID){
        model.setItemID(itemID);
    }

    public void setItemInfo(String itemID, String itemStock, String itemPrice){
        model.setItemID(itemID);
        model.setStockCount(itemStock);
        model.setItemPrice(itemPrice);

    }

    public String getItemInfo(){
        return model.itemInfo;
    }

}
