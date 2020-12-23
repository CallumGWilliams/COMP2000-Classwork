public class controller {

    private model model;
    private view view;

    public controller(model model, view view){
        this.model = model;
        this.view = view;
    }

    public void setItemID(String itemID){
        model.setItemID(itemID);
    }

    public String getItemID(){
        return model.getItemID();

    }

    public void setItemStock(String itemStock){
        model.setItemStock(itemStock);
    }

    public String getItemStock(){
        return model.getItemStock();
    }


    public void updateView(){

        view.printItemID(model.getItemID(), model.getItemStock());

    }

}

