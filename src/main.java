public class main {

    public static void main (String[] args){

        kioskView view = new kioskView();
        kiosk model = new kiosk();
        database d = new database();
        kioskController controller = new kioskController(model, view);
        controller.initApp();
        d.newItem("coke");

        d.addToStock("coke");
        d.showStock();


    }


}
