
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

    public class Tests {


        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        public Tests() throws IOException {
        }

        @Test
        public void testUsername() {
            String userName = "bob";
            assertEquals(userName, controller.user);
        }


        @Test
        public void testPass() {
            String password = "pass";
            assertEquals(password, controller.pass);
        }

        @Test
        public void testScanInput(){
            String scan;

        }
    }

