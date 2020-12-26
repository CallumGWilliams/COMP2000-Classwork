public class kiosk {

    String stockCount;
    String itemID;
    String itemPrice;
    String itemInfo;

    public String getStockCount(){
        return stockCount;
    }

    public void setStockCount(String stockCount){
        this.stockCount = toString();
    }


    public String getItemID(){
        return itemID;
    }

    public void setItemID(String itemID){
        this.itemID = itemID;
    }

    public void setItemPrice(String itemPrice){
        this.itemPrice = itemPrice;
    }

    public void setItemInfo(String itemID, String itemStock, String itemPrice){
        this.setItemID(itemID);
        this.setStockCount(itemStock);
        this.setItemPrice(itemPrice);

    }

    public String getItemInfo(){
        return itemInfo;
    }
}
