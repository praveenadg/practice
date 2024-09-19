package companies;

import java.util.List;

public class Mettta {
    //Diameter of binary tree
    // https://leetcode.com/problems/nested-list-weight-sum/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days

   class NestedInteger{
       public int getNumber() {
           return number;
       }

       public void setNumber(int number) {
           this.number = number;
       }

       public List<NestedInteger> getList() {
           return list;
       }

       public void setList(List<NestedInteger> list) {
           this.list = list;
       }

       private int number;
       private List<NestedInteger> list;
   }
}
