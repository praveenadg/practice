package companies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreditAccMovieRecommendation {
    /*

One of the fun features of Aquaintly is that users can rate movies they have seen from 1 to 5. We want to use these ratings to make movie recommendations.

Ratings will be provided in the following format:
  [Member Name, Movie Name, Rating]

We consider two users to have similar taste in movies if they have both rated the same movie as 4 or 5.

A movie should be recommended to a user if:
- They haven't rated the movie
- A user with similar taste has rated the movie as 4 or 5

Example:
ratings = [
    ["Alice", "Frozen", "5"],
    ["Bob", "Mad Max", "5"],
    ["Charlie", "Lost In Translation", "4"],
    ["Charlie", "Inception", "4"],
    ["Bob", "All About Eve", "3"],
    ["Bob", "Lost In Translation", "5"],
    ["Dennis", "All About Eve", "5"],
    ["Dennis", "Mad Max", "4"],
    ["Charlie", "Topsy-Turvy", "2"],
    ["Dennis", "Topsy-Turvy", "4"],
    ["Alice", "Lost In Translation", "1"],
    ['Franz', 'Lost In Translation', '5'],
    ['Franz', 'Mad Max', '5']
]

If we want to recommend a movie to Charlie, we would recommend "Mad Max" because:
- Charlie has not rated "Mad Max"
- Charlie and Bob have similar taste as they both rated "Lost in Translation" 4 or 5
- Bob rated "Mad Max" a 5
-----------------------------------------------
Write a function that takes the name of a user and a collection of ratings, and returns a collection of all movie recommendations that can be made for the given user.

All test cases:
recommendations("Charlie", ratings) => ["Mad Max"] -- List of watched and unwatched movies for Charlie
 Map(Charlie, (list of movies where user rate 4 or 5))

recommendations("Bob", ratings) => ["Inception", "Topsy-Turvy"]
recommendations("Dennis", ratings) => ["Lost In Translation"]
recommendations("Alice", ratings) => []
recommendations("Franz", ratings) => ["Inception", "All About Eve", "Topsy-Turvy"]

Complexity Variable:
R = number of ratings
M = number of movies
U = number of users




 */

        public static void main(String[] argv) {
            String[][] ratings = {
                    {"Alice", "Frozen", "5"},
                    {"Bob", "Mad Max", "5"},
                    {"Charlie", "Lost In Translation", "4"},
                    {"Charlie", "Inception", "4"},
                    {"Bob", "All About Eve", "3"},
                    {"Bob", "Lost In Translation", "5"},
                    {"Dennis", "All About Eve", "5"},
                    {"Dennis", "Mad Max", "4"},
                    {"Charlie", "Topsy-Turvy", "2"},
                    {"Dennis", "Topsy-Turvy", "4"},
                    {"Alice", "Lost In Translation", "1"},
                    {"Franz", "Lost In Translation", "5"},
                    {"Franz", "Mad Max", "5"}
            };

            System.out.println(recommendations("Bob",ratings));
            System.out.println(recommendations("Dennis",ratings));
            System.out.println(recommendations("Alice",ratings));
            System.out.println(recommendations("Franz",ratings));
        }

       static  Set<String> recommendations(String user, String[][] ratings) {
            Set<String> seen = new HashSet<>();
            Set<String> userRatedMovies = new HashSet<>();
            Set<String> similarUsers = new HashSet<>();
            Set<String> recommendations = new HashSet<>();
            //extract user rated movies and user seen movies
            for (String[] rating : ratings) {
                String rUser = rating[0];
                if (user.equalsIgnoreCase(rUser)) {
                    seen.add(rating[1]);
                    if (Integer.parseInt(rating[2]) > 3) {
                        userRatedMovies.add(rating[1]);
                    }
                }
            }
            //get similar users
            for (String[] rating : ratings) {
                String rUser = rating[0];
                if (!user.equalsIgnoreCase(rUser) && Integer.parseInt(rating[2]) > 3 && userRatedMovies.contains(rating[1])) {
                    similarUsers.add(rUser);
                }
            }

            for (String[] rating : ratings) {
                String rUser = rating[0];
                if (similarUsers.contains(rUser) && !seen.contains(rating[1])) {
                    recommendations.add(rating[1]);
                }
            }
            return recommendations;
        }
}
