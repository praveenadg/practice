package test;/*
 * Click `Run` to execute the snippet below!
 */
import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Hims {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        JUnitCore.main("Hims");
        Hims hims = (Hims) Class.forName("Hims").newInstance();
        hims.recommendedProducts();
    }

    /**
     * Returns the list of recommendations from our recommendation team. Recommendations are a list of product IDs.
     */
    public static List<String> getRecommendations() {
        final List<String> recommendations = new ArrayList<>();
        recommendations.add("789");
        recommendations.add("123");
        recommendations.add("alkjhsdoi");
        recommendations.add("456");

        return recommendations;
    }

    /**
     * Returns a list of sellable products.
     */
    public static List<Product> getProducts() {
        final List<Product> products = new ArrayList<>();
        products.add(new Product("80119kjnasd", "Motrin", "Motrin"));
        products.add(new Product("789", "Tylenol", "Tylenol"));
        products.add(new Product("123", "Advil", "Advil"));

        return products;
    }

    /**
     * Returns a list of sellable products in the recommended order.
     */
    public static List<Product> getRecommendedProducts() {
        List<Product> products = getProducts();
        String title = products.stream().map(Product::getTitle).collect(Collectors.joining(","));
        System.out.println(title);
        products.stream().reduce((product, product2) -> new Product(product.getId(), product2.getTitle(),"desc"));
        Collections.sort(products, new CustomComparator());
        return products;
    }

    static class CustomComparator implements Comparator<Product> {

        @Override
        public int compare(Product a, Product b){
            List<String> recommendations = getRecommendations();
            Map<String, Integer> recommendationIndexMap = new HashMap<>();
            for(int i=0; i< recommendations.size(); i++){
                recommendationIndexMap.put(recommendations.get(i), i);
            }
            if(recommendationIndexMap.get(a.getId())==null){
                return 1;
            }   if(recommendationIndexMap.get(b.getId())==null){
                return -1;
            }
            return recommendationIndexMap.get(a.getId()).compareTo(recommendationIndexMap.get((b).getId()));

        }

    }



    @Test
    public void recommendedProducts() {
        final List<String> expected = new ArrayList<>();
        expected.add("789");
        expected.add("123");
        expected.add("80119kjnasd");

        final List<String> actual = getRecommendedProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList());

        Assert.assertEquals(expected, actual);
    }
}

class Product {
    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private Instant createdAt;
    private Instant updatedAt;

    public Product(final String id, final String title, final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
