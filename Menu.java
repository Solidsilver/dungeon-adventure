import java.util.*;

public class Menu {
    private ArrayList<String> options;
    private String menuName;
    private Scanner kbIn;

    public Menu(String name, String ...items) {
        this.menuName = name;
        this.kbIn = new Scanner(System.in);
        this.options = new ArrayList<>();
        for (int x = 0; x < items.length; x++) {
            options.add(items[x]);
        }
    }

    public Menu(String name, ArrayList<String> items) {
        this.menuName = name;
        this.options = items;
        this.kbIn = new Scanner(System.in);
    }

    public void addChoice(String choice) {
        this.options.add(choice);
    }

    public void addChoiceFirst(String choice) {
        this.options.add(0, choice);
    }

    public void print() {
        this.print(2);
        
    }

    private void print(int columns) {
        System.out.println("\t" + this.menuName);
        int x = 0;
        Iterator<String> itr = options.iterator();
        for (String str: this.options) {
            System.out.print(x + ") " + str + "\t");
            if (x == columns - 1) {
                System.out.println();
            }
            x++;
        }
        System.out.println();
    }

    public int getSelection() {
        int selected = -1;
        do {
            this.print();
            System.out.print("~> ");
            try {
                selected = Integer.parseInt(kbIn.nextLine());
            } catch (NumberFormatException nfe) {
                selected = -1;
            }
            
        } while (selected < 0 || selected >= this.options.size());
        return selected;
    }
    
}