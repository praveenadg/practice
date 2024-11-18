package problems;

//https://leetcode.com/problems/rank-teams-by-votes/?envType=company&envId=atlassian&favoriteSlug=atlassian-thirty-days

import java.util.*;

/**
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.
 * The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
 * You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
 * Return a string of all teams sorted by the ranking system.
 *
 *
 * Example 1:
 *
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 * Explanation:
 * Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
 * Team B was ranked second by 2 voters and ranked third by 3 voters.
 * Team C was ranked second by 3 voters and ranked third by 2 voters.
 * As most of the voters ranked C second, team C is the second team, and team B is the third.
 * Example 2:
 *
 * Input: votes = ["WXYZ","XYZW"]
 * Output: "XWYZ"
 * Explanation:
 * X is the winner due to the tie-breaking rule. X has the same votes as W for the first position, but X has one vote in the second position, while W does not have any votes in the second position.
 * Example 3:
 *
 * Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
 * Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
 * Explanation: Only one voter, so their votes are used for the ranking.
 *
 *
 *
 */
public class RankTeams {
    public static void main(String args[]){
     //  String res = (rankTeams(new String []{"ABC","ACB","ABC","ACB","ACB"}));
        String res = (rankTeams(new String []{"WXYZ","XYZW"}));
        System.out.println(res);

    }
    public static String rankTeams(String[] votes) {
        // Edge case(NOT COMPULSARY)
        if(votes.length == 1){
            return votes[0];
        }

        // Adding each character to the map
        //Time complexity:O(n∗26+Sorting+K) K:- no. of Element in the list n:- is the size of the map
        //Space complexity:O(n+N) N:- no. of Element in the list n:- is the size of map
        Map<Character, int[]> map = new HashMap<>();
        int v_len = votes[0].length();
        for (String v : votes) {
            int idx = 0;
            for (char ch : v.toCharArray()) {
                map.putIfAbsent(ch, new int[v_len]);
                map.get(ch)[idx++]++;
                /*
                ["ABC","ACB","ABC","ACB","ACB"]
                A: 5, 0, 0
                B: 0, 2, 3
                C: 0, 3, 2
                */
            }
        }


        // Custom Comparator Sort
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < v_len; i++) {
                // If a == b, check next vote column
                // If a != b, return diff for sorting
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                } else{
                    continue;
                }
            }
            return 0;
        });


        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
