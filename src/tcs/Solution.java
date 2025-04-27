package tcs;

// you can also use imports, for example:

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    Object[][] data = {
            {1, "Root", "Products", -1},
            {2, "Furniture", "Furniture", 1},
            {3, "Electronics", "Electronics, Gadgets", 1},
            {4, "Home Appliances", "Home, Appliances", 1},
            {5, "Major Appliances", "", 4},
            {6, "Minor Appliances", "", 4},
            {7, "Lawn & Garden", "Lawn, Garden", 4},
            {8, "Kitchen Appliances", "", 5},
            {9, "General Appliances", "", 5}
    };
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));//
    //level 0 Root
    //level 1 Furniture, Electronics, Home Appliances
    //level 2 Major Appliances
    //level 3 Kitchen, General

    private static final Map<Integer, Category> categoryMap = new ConcurrentHashMap<>();

    public static void main(String args[]) {
        //String name, int parentCategoryId, List<String> keywords
        categoryMap.put(1, new Category("Root", -1, List.of("Products")));
        categoryMap.put(2, new Category("Furniture", 1, List.of("Furniture")));
        categoryMap.put(3, new Category("Electronics", 1, List.of("Electronics", "Gadgets")));
        categoryMap.put(4, new Category("Home Appliances", 1, List.of("Home", "Appliances")));
        categoryMap.put(5, new Category("Major Appliances", 4, List.of()));
        categoryMap.put(6, new Category("Minor Appliances", 4, List.of()));
        categoryMap.put(7, new Category("Lawn & Garden", 4, List.of("Lawn",
                "Garden")));
        categoryMap.put(8, new Category("Kitchen Appliances", 5, List.of()));
        categoryMap.put(9, new Category("General Appliances", 5, List.of()));

        System.out.println(Arrays.toString(solution(1)));
        System.out.println(Arrays.toString(solution(2)));
        System.out.println(Arrays.toString(solution(3)));
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
        System.out.println(Arrays.toString(solution(7)));
        System.out.println(Arrays.toString(solution(8)));
        System.out.println(Arrays.toString(solution(9)));

        System.out.println(Arrays.toString(solution(10)));
        System.out.println(Arrays.toString(solution(-1)));

    }

    //{level, keywords}//get keywords for a given category
    public static String[] solution(int categoryID) {
        // Implement your solution here
        List<String> result = new ArrayList();
        result.add(String.valueOf(getLevel(categoryID)));
        result.addAll(getKeywords(categoryID));
        return result.toArray(new String[0]);
    }

    private static int getLevel(int categoryID) {
        int level = 0;
        while (categoryID != -1 && categoryMap.containsKey(categoryID)) {
            categoryID = categoryMap.get(categoryID).parentCategoryId;
            level++;
        }
        return level - 1;
    }

    private static List<String> getKeywords(int categoryID) {
        List<String> keywords = new ArrayList<>();
        while (categoryID != -1) {
            Category cat = categoryMap.get(categoryID);
            if (cat != null && !cat.keywords.isEmpty()) {
                keywords.addAll(cat.keywords);
                break;
            }
            categoryID = cat != null ? cat.parentCategoryId : -1;
        }
        return keywords;
    }

    class Root {
        List<Category> categories;

        Root() {
            categories = new ArrayList<>();
        }

        void add(Category category) {
            categories.add(category);
        }
    }

    static class Category {
        String name;
        int categoryId;
        // int level;
        int parentCategoryId;
        // List<Category> subCategories;
        List<String> keywords;

        Category(String name, int parentCategoryId, List<String> keywords) {
            // subCategories=new ArrayList();
            this.name = name;
            this.parentCategoryId = parentCategoryId;
            this.keywords = keywords;
        }
    }
}
