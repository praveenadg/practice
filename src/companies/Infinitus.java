package companies;/*
 Determine the minimum cost to travel from the source city to the destination city with at most k stops.

n = 4 (total number of cities)

flights = [["New York","Chicago",100],["Chicago","Denver",100],["Denver","New York",100],["Chicago","Los Angeles",600],["Denver","Los Angeles",200], ["New York","Los Angeles",900]]

src = "New York" (starting city)
dst = "Los Angeles" (destination city)

k = 1 (maximum number of stops)

Output: 700

Explanation:
The optimal path with at most 1 stop from New York to Los Angeles has cost 100 + 600 = 700.
Note that the path through cities [New York, Chicago, Denver, Los Angeles] is cheaper but is invalid because it uses 2 stops.
 */


//import org.apache.commons.lang3.tuple.Pair;

public class Infinitus {
    public static void main(String[] args) {

        String[][] flights = {{"New York", "Chicago", "100"}, {"Chicago", "Denver", "100"}, {"Denver", "New York", "100"}, {"Chicago", "Los Angeles", "600"}, {"Denver", "Los Angeles", "200"}, {"New York", "Los Angeles", "900"}};
        System.out.println("ABCD".substring(1));
        System.out.println(getMinimumTravelCost(flights, "New York", "Los Angeles", 1));


    }

    static int getMinimumTravelCost(String[][] flights, String source, String destination, int k) {
        int cost = 0;
        return cost;

//        Map<String, List<Pair<String, Integer>>> map = new HashMap<>();
//
//        for (String[] flight : flights) {
//            String src = flight[0];
//            String dst = flight[1];
//            int price = Integer.valueOf(flight[2]);
//
//            if (!map.containsKey(src)) {
//                map.put(src, new ArrayList<>());
//            }
//            map.get(src).add(Pair.of(dst, price));
//        }
//
//        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> Integer.valueOf(a[0]) - Integer.valueOf(b[0]));
//
//        pq.add(new String[]{"0", source, "0"});//cost, src, stops
//
//        Map<String, Integer> visited = new HashMap<>();
//        //  visited.add(source);
//        int stops = 0;
//
//        while (!pq.isEmpty()) {
//            String[] arr = pq.remove();
//            int price = Integer.valueOf(arr[0]);
//            String srcNode = arr[1];
//            int stop = Integer.valueOf(arr[2]);
//
//            if (srcNode.equals(destination)) {
//                return price;
//            }
//            if (stop > k)
//                continue;
//            ;
//            //stops++;
//
//            for (Pair<String, Integer> neighbor : map.getOrDefault(srcNode, new ArrayList<>())) {
//                String nextCity = neighbor.getKey();
//                int nextPrice = neighbor.getValue();
//                int newCost = cost + nextPrice;
//                if (!visited.containsKey(neighbor.getKey()) || visited.get(nextCity) > newCost) {
//                    System.out.println(neighbor.getKey() + " " + neighbor.getValue());
//                    pq.add(new String[]{String.valueOf(price + neighbor.getValue()), neighbor.getKey(), String.valueOf(stop + 1)});
//                    visited.put(neighbor.getKey(), price + neighbor.getValue());
//                }
//            }
//        }
//        return cost == 0 ? -1 : cost;
    }
}