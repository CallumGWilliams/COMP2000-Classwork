public class main {

    public static void main(String[] args){
        view view = new view();
        model model = new model();
        controller controller = new controller(model, view);


        controller.setItemID("Bread");
        controller.setItemStock("25");
        controller.updateView();

    }


}
