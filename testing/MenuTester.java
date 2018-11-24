package testing;
import utils.Menu;

public class MenuTester {
    public static void main(String[] args) {
        Menu mnu = new Menu("TestList: ", "jackJack", "billyBob", "hownow", "johndavid", "3.14159", "john ONeal", "Bob Nelson");
        mnu.printDefault();
        pl();
        mnu.print(3);
        pl();
        mnu.printVert(3);
    }

    private static void pl() {
        System.out.println();
    }
}