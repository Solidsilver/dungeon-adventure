public class MenuTester {
    public static void main(String[] args) {
        Menu mnu = new Menu("TestList: ", "jackJack", "billyBob", "hownow", "johndavid", "3.14159", "john ONeal", "Bob Nelson");
        mnu.printDefault();
        pl();
        mnu.print(10);
        pl();
        mnu.printVert(10);
    }

    private static void pl() {
        System.out.println();
    }
}