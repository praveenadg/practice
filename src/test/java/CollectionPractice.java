package test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionPractice {
    public static void main(String [] args) {

        List<Integer> numbers = Arrays.asList(42, 4, 2, 24, 2, 3);
        List<List<Integer>> numbersList = new ArrayList<>();
        numbersList.add(numbers);
        LinkedList<Integer> list = new LinkedList<>();
       // list.addFirst();
        Optional<Integer> min = numbers.stream().min((Integer::compareTo));
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println(numbers.stream().mapToInt(v->v).max());
        System.out.println(numbers.stream().mapToInt(v->v).min());

        System.out.println("min="+min);
        System.out.println("max="+max);

        System.out.println( numbers.indexOf( Collections.min(numbers)));
        Function<Integer, Integer> sum= a-> a+2;
        System.out.println( "map"+ numbers.stream().map(sum).collect(Collectors.toList()));//map applies the function to each element of the list(stream), ex : toUpperCase
        System.out.println( "map"+ numbersList.stream().flatMap(Collection::stream).collect(Collectors.toList()));
        System.out.println( "map2"+ numbers.stream().flatMap(a->Stream.of(a)).distinct().sorted().collect(Collectors.toList()));//flatmap flattens List<List<>> to List<>

        //map is transformation operator and reduce is aggregation operation
        System.out.println( "sum="+ numbers.stream().reduce((a,b)->a+b).get());//reduce reduces to a single value, transform will transforms each value.

        System.out.println( "sum="+numbersList.stream().flatMap(Collection::stream).reduce((c,d)->c+d).get());
        Person alex = new Person("Alex", 23);
        Person john = new Person("John", 40);
        Person peter = new Person("Peter", 32);
        List<Person> people = Arrays.asList(alex, john, peter);
        people.stream().map(a->a.getAge()).reduce(Integer::sum).get();
        people.stream().map(a->a.getAge()).mapToInt(a->a.intValue()).average();
        System.out.println( "age="+people.stream().map((a)->a.getAge()).reduce((x,y)->x+y));//sum of all age
        people.stream().map(a->a.getAge()).mapToInt(a->a.intValue()).average();
        System.out.println( "Maxx age="+people.stream().map((a)->a.getAge()).max(Comparator.naturalOrder()));
        System.out.println( "Maxx age="+people.stream().map((a)->a.getAge()).mapToInt(a->a.intValue()).max());
        System.out.println( "MIn age="+people.stream().map((a)->a.getAge()).min(Comparator.naturalOrder()));
        System.out.println( "MIn age="+people.stream().map((a)->a.getAge()).mapToInt(a->a.intValue()).min());
        System.out.println( "avg age="+people.stream().map((a)->a.getAge()).mapToInt(x->x.intValue()).average());

        System.out.println( people.stream().min((a,b)-> a.getAge().compareTo(b.getAge())).get().getName());


        BiFunction<Integer, Integer,Integer> biSum = (a,b)->a+b;

        System.out.println(  sum.apply(4));
        System.out.println(  biSum.apply(4, 5));
        System.out.println(biSumMethod(sum).apply(2,3));
        BiFunction<Integer, Integer, String> func  =(a,b)->String.valueOf(a+b);
        System.out.println("sumBi= "+sum(func, 2,3));
        Supplier<Double> squareThiSnum = ()-> 4d;
        System.out.println("squareThiSnum= "+squareLazy(squareThiSnum));

    }
    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }

    static String sum(BiFunction<Integer, Integer,String> function, int a, int b){
        return function.apply(a,b);
    }

    static BiFunction<Integer, Integer, Integer> biSumMethod(Function<Integer, Integer> sum){
        return (a, b)-> sum.apply(a)+b;
    }

   static class Person {
        String name;

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Integer getAge() {
           return age;
       }

       public void setAge(Integer age) {
           this.age = age;
       }

       Integer age;

        Person(String name, Integer age){
            this.name=name;
            this.age=age;
        }
        // standard constructors, getters and setters
    }
}
