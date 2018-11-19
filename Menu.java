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

    public void add(String choice) {
        this.options.add(choice);
    }

    public void addFirst(String choice) {
        this.options.add(0, choice);
    }

    private void printTitle() {
        System.out.println("\t" + this.menuName);
    }

    public void printDefault() {
        this.printVert(2);
        
    }

    public void print(int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("Number of columns must be > 0, was " + columns);
        }
        printTitle();
        int x = 1;
        for (String str: this.options) {
            System.out.print((x-1) + ") " + str + "\t");
            if (x%columns == 0 && x < this.options.size()) {
                System.out.println();
            }
            x++;
        }
        System.out.println();
    }

    public void printVert(int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("Number of columns must be > 0, was " + columns);
        }
        System.out.println("\t" + this.menuName);
        int rows = this.options.size()/columns + 1;
        for (int y = 0; y < rows; y++) {
            for (int x = y, i = 0; (i < columns) && (x < this.options.size()); x += rows, i++) {
                System.out.print(x + ") " + this.options.get(x) + "\t");
            }
            System.out.println();
        }
    }

    public int getSelectionDefault() {
        return getSelection(2);
    }

    public int getSelection(int columns) {
        return getSelection(columns, true);
    }

    public int getSelection(int columns, boolean printVertical) {
        int selected = -1;
        do {
            if (printVertical) {
                printVert(columns);
            } else {
                print(columns);
            }
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