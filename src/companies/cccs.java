package companies;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
public class cccs {


// You have been tasked with parsing menus from a large restaurant group. Each menu is streamed to clients via a provided interface. You must design object(s)
// that represents a menu and can be instantiated with data from the provided interface. Your design should contain an appropriate class structure to contain the parsed data,
// as well as a function or set of functions to perform the parsing.

// Consumers will use your object(s) to access a complete representation of the data sent by the menu stream after it has finished loading.
// Your objects should provide easy access to the full representation of the menu. It should be possible to reconstruct the menu stream from your object.

// The menu stream represents a list of menu items. Each line in the stream is a property of a menu item, and each item will be separated by an empty string. The attributes of each item are as follows:

//   Line 0: The ID of the item
//   Line 1: The item type, either CATEGORY, DISH or OPTION
//   Line 2: The name of the item
//   Line 3: The price of the item for DISH and OPTION. Not present for CATEGORY items.
//   Any other line: A list of item IDs that are linked to the current item. OPTIONs do not have any linked items.


// example input:
// 4
// DISH
// Spaghetti
// 10.95
// 2
// 3

// 1
// CATEGORY
// Pasta
// 4
// 5

// 2
// OPTION
// Meatballs
// 1.00

// 3
// OPTION
// Chicken
// 2.00

// 5
// DISH
// Lasagna
// 12.00

// 6
// DISH
// Caesar Salad
// 9.75
// 3




    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */


    interface MenuStream {
        String nextLine();
    }

    static class MenuStreamImpl implements MenuStream {

        private final List<String> lines = new ArrayList<>(Arrays.asList("4", "DISH", "Spaghetti", "10.95", "2", "3", "", "1", "CATEGORY", "Pasta", "4", "5", "", "2", "OPTION", "Meatballs", "1.00", "", "3", "OPTION", "Chicken", "2.00", "", "5", "DISH", "Lasagna", "12.00", "", "6", "DISH", "Caesar Salad", "9.75", "3", ""));

        private final Iterator<String> it = lines.iterator();

        @Override
        public String nextLine() {
            if (it.hasNext()) {
                return it.next();
            } else {
                return null;
            }
        }
    }



        public static void main(String[] args) {
            List<MenuItem> menuItems = buildMenu(new MenuStreamImpl());
            menuItems.forEach(a -> {
                System.out.println(a.id);
                System.out.println(a.name);
                System.out.println(a.itemType.toString());
                System.out.println(a.price);
            });

        }

        public  static List<MenuItem> buildMenu(MenuStream menuStream) {
// example input:
// 4
// DISH
// Spaghetti
// 10.95
// 2
// 3

// 1
// CATEGORY
// Pasta
// 4
// 5

            int count = 0;
            List<MenuItem> menuItems = new ArrayList<>();
            MenuItem menuItem = new MenuItem();
            while (menuStream.nextLine() != null) {
                String value = menuStream.nextLine();
                if (value == "") {
                    menuItems.add(menuItem);
                    menuItem = new MenuItem();
                    count = 0;
                    continue;
                }
                if (count == 0) {
                    menuItem.id = Integer.valueOf(value);
                } else if (count == 1) {
                    menuItem.itemType = ItemType.valueOf(ItemType.class, value);
                } else if (count == 2) {
                    menuItem.name = value;
                } else if (count == 3 && ItemType.CATEGORY != menuItem.itemType) {
                    menuItem.price = new BigDecimal(value);
                } else {
                    menuItem.linkedItems.add(Integer.valueOf(value));
                }

                count++;

            }
            return menuItems;
        }

    }


    enum ItemType {
            CATEGORY,
            DISH,
            OPTION;
        }

        class Menu{
            List<MenuItem> menuItems;
        }
        class MenuItem {//we can use different strategy classes for each type
            public int id;
            public ItemType itemType;
            public String name;
            public BigDecimal price;
            //List<String> linkedItems;
            public List<Integer> linkedItems;

        }
