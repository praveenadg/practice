package test;

    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
    import java.util.Comparator;
    import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



    public  class Amazon {

        /*
         * Complete the 'processLogs' function below.
         *
         * The function is expected to return a STRING_ARRAY.
         * The function accepts following parameters:
         *  1. STRING_ARRAY logs
         *  2. INTEGER threshold
         */

        public static List<String> processLogs(List<String> logs, int threshold) {
            // Write your code here

            Map<String, Integer> userCount = new TreeMap<>();

            for(int i=0; i<logs.size(); i++){
                String [] log = logs.get(i).split(" ");
                String firstUser = log[0];
                String secondUser = log[1];
                if(firstUser.equals(secondUser)){
                    userCount.put(firstUser, userCount.getOrDefault(firstUser, 0)+1);
                } else {
                    userCount.put(firstUser, userCount.getOrDefault(firstUser, 0)+1);
                    userCount.put(secondUser, userCount.getOrDefault(secondUser, 0)+1);
                }
            }
            List<String> topUserString = new ArrayList();
            Stream<Map.Entry<String, Integer>> sorted =
                    userCount.entrySet().stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
            sorted.collect(Collectors.toList()).forEach(entry->{
                if(entry.getValue()>=threshold)
                    topUserString.add(entry.getKey());
            });
            topUserString.sort(Comparator.naturalOrder());
            System.out.println("input="+logs);
            System.out.println("threshold="+threshold);
            topUserString.forEach(a->System.out.println("listval="+a));
            userCount.entrySet().forEach(entry->
                    System.out.println(entry.getKey()+"=" + entry.getValue()));
            //List<String> topTwoUsers = userCount.keySet().stream().limit(2).collect(Collectors.toList());
            return topUserString;

        }

        public static void main(String [] args){
            System.out.println(processLogs1(Arrays.asList("99 32 100","99 32 100","88 99 200","88 99 300", "12 15 15"), 2));
        }

        public static List<String> processLogs1(List<String> logs, int threshold) {
            // Write your code here

            Map<Integer, Integer> userCount = new TreeMap<>(Comparator.comparing(Object::toString));

            for(int i=0; i<logs.size(); i++){
                String [] log = logs.get(i).split(" ");
                Integer firstUser = Integer.valueOf(log[0]);
                Integer secondUser =  Integer.valueOf(log[1]);
                if(firstUser.equals(secondUser)){
                    userCount.put(firstUser, userCount.getOrDefault(firstUser, 0)+1);
                } else {
                    userCount.put(firstUser, userCount.getOrDefault(firstUser, 0)+1);
                    userCount.put(secondUser, userCount.getOrDefault(secondUser, 0)+1);
                }
            }
            List<String> ans = new ArrayList<>();

            for(Map.Entry<Integer, Integer> e : userCount.entrySet()) {

                if (e.getValue() >= threshold) {
                    ans.add(e.getKey().toString());
                }
            }

            return ans;
        }


        public static void main1(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            int threshold = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> result = Amazon.processLogs(logs, threshold);

            bufferedWriter.write(
                    result.stream()
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

