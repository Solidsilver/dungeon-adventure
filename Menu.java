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
        if (columns <= 0) {
            throw new IllegalArgumentException("Number of columns must be > 0, was " + columns);
        }
        System.out.println("\t" + this.menuName);
        int x = 1;
        //Iterator<String> itr = options.iterator();
        for (String str: this.options) {
            System.out.print((x-1) + ") " + str + "\t");
            if (x%columns == 0 && x < this.options.size()) {
                System.out.println();
            }
            x++;
        }
        System.out.println();
    }

    public int getSelection() {
        return getSelection(2);
    }

    public int getSelection(int columns) {
        int selected = -1;
        do {
            print(columns);
            System.out.print("~> ");
            try {
                selected = Integer.parseInt(kbIn.nextLine());
            } catch (NumberFormatException nfe) {
                selected = -1;
            }
            
        } while (selected < 0 || selected >= this.options.size());
        return selected;
    }

    public boolean isLast(int menuOption) {
        return menuOption == (this.options.size() - 1);
    }
    
}