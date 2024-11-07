package companies;
import java.util.*;
import java.io.IOException;
public class CreditAcceptance {
    /*   1. Understand the FundingRaised class logic.
2. Focus on reverse engineering and edge cases.
3. Ensure you understand filtering logic.
4. Ask requirements clarification questions, if any.
5. Debug implementation and identify issues.
6. Refactor the code.
7. Consider yourself as the Software Engineering leader FundingRaised logic.
8. FundingRaised is a part of large application and its API used by many other system components.
 9. Consider interviewer as a Product Owner and ask questions to ensure you are addressing a right problem.
10. Verify your refactoring proposals:
11. Improve code maintainability
12. Make it less error prone
13. Increase flexibility to address new potential requirments.
*/





  //  public class FundingRaised {


    /* Improvements:
    1. Use try with resources to autoclose and handle IOException
    2. Add null check and equalIgnoreCase
    3. Extract if conditions to seperate method

    */

        private List<String[]> filterByCompanyName2(List<String[]> csvData , Map<String, String> options){
            List<String[]> results = new ArrayList<String[]> ();

            for(int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i)[1].equals(options.get("company_name"))) {//if first column is company_name
                    results.add(csvData.get(i));//add that row to results
                }
            }
            return results;
        }

        private List<String[]> filterByCompanyName1(List<String[]> csvData , Map<String, String> options) {
            List<String[]> results = new ArrayList<String[]>();
            if (options.containsKey("company_name")) {


                for (int i = 0; i < csvData.size(); i++) {
                    if (csvData.get(i)[1].equals(options.get("company_name"))) {//if first column is company_name
                        results.add(csvData.get(i));//add that row to results
                    }
                }

            }
            return results;
        }

            private static List<String[]> filterByCompanyName(List<String[]> csvData , Map<String, String> options) {
                List<String[]> results = new ArrayList<String[]>();
            if (options.containsKey("company_name")) for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i)[1].equals(options.get("company_name"))) {//if first column is company_name
                    results.add(csvData.get(i));//add that row to results
                }
            }
                return results;
            }

/*

                public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
                    List<String[]> csvData = new ArrayList<String[]>();
                    CsvReader reader = new CsvReader("startup_funding.csv");//
                    String[] row = null;

                    while((row = reader.readNext()) != null) {
                        csvData.add(row);
                    }//reading csv and populating csvData

                    reader.close();
                    csvData.remove(0);//removes header row

                    if(options.containsKey("company_name")) {
                        csvData = filterByCompanyName(csvData, options);
                        // List<String[]> results = new ArrayList<String[]> ();

                        // for(int i = 0; i < csvData.size(); i++) {
                        //     if(csvData.get(i)[1].equals(options.get("company_name"))) {//if first column is company_name
                        //         results.add(csvData.get(i));//add that row to results
                        //     }
                        // }
                        // csvData = results;//reassigning
                    }

                    if(options.containsKey("city")) {
                        csvData = filterByCity(csvData, options);
                        // List<String[]> results = new ArrayList<String[]> ();

                        // for(int i = 0; i < csvData.size(); i++) {
                        //     if(csvData.get(i)[4].equals(options.get("city"))) {//4th column is city
                        //         results.add(csvData.get(i));
                        //     }
                        // }
                        // csvData = results;
                    }

                    if(options.containsKey("state")) {
                        csvData = filterByState(csvData, options);
                        // List<String[]> results = new ArrayList<String[]> ();

                        // for(int i = 0; i < csvData.size(); i++) {
                        //     if(csvData.get(i)[5].equals(options.get("state"))) {//
                        //         results.add(csvData.get(i));
                        //     }
                        // }
                        // csvData = results;//
                    }

                    if(options.containsKey("round")) {
                        csvData = filterByState(csvData, options);
                        // List<String[]> results = new ArrayList<String[]> ();

                        // for(int i = 0; i < csvData.size(); i++) {
                        //     if(csvData.get(i)[9].equals(options.get("round"))) {//9th col
                        //         results.add(csvData.get(i));
                        //     }
                        // }
                        // csvData = results;
                    }

                    List<Map<String, String>> output = new ArrayList<Map<String, String>>();

                    for(int i = 0; i < csvData.size(); i++) {
                        Map<String, String> mapped = new HashMap<String, String> ();
                        mapped.put("permalink", csvData.get(i)[0]);
                        mapped.put("company_name", csvData.get(i)[1]);
                        mapped.put("number_employees", csvData.get(i)[2]);
                        mapped.put("category", csvData.get(i)[3]);
                        mapped.put("city", csvData.get(i)[4]);
                        mapped.put("state", csvData.get(i)[5]);
                        mapped.put("funded_date", csvData.get(i)[6]);
                        mapped.put("raised_amount", csvData.get(i)[7]);
                        mapped.put("raised_currency", csvData.get(i)[8]);
                        mapped.put("round", csvData.get(i)[9]);
                        output.add(mapped);
                    }

                    return output;
                }

                public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
                    List<String[]> csvData = new ArrayList<String[]>();
                    CsvReader reader = new CsvReader("startup_funding.csv");
                    String[] row = null;

                    while((row = reader.readNext()) != null) {
                        csvData.add(row);
                    }

                    reader.close();
                    csvData.remove(0);
                    Map<String, String> mapped = new HashMap<String, String> ();


                    for(int i = 0; i < csvData.size(); i++) {
                        if(options.containsKey("company_name")) {
                            if(csvData.get(i)[1].equals(options.get("company_name"))) {
                                mapped.put("permalink", csvData.get(i)[0]);
                                mapped.put("company_name", csvData.get(i)[1]);
                                mapped.put("number_employees", csvData.get(i)[2]);
                                mapped.put("category", csvData.get(i)[3]);
                                mapped.put("city", csvData.get(i)[4]);
                                mapped.put("state", csvData.get(i)[5]);
                                mapped.put("funded_date", csvData.get(i)[6]);
                                mapped.put("raised_amount", csvData.get(i)[7]);
                                mapped.put("raised_currency", csvData.get(i)[8]);
                                mapped.put("round", csvData.get(i)[9]);
                            } else {
                                continue;
                            }
                        }

                        if(options.containsKey("city")) {
                            if(csvData.get(i)[4].equals(options.get("city"))) {
                                mapped.put("permalink", csvData.get(i)[0]);
                                mapped.put("company_name", csvData.get(i)[1]);
                                mapped.put("number_employees", csvData.get(i)[2]);
                                mapped.put("category", csvData.get(i)[3]);
                                mapped.put("city", csvData.get(i)[4]);
                                mapped.put("state", csvData.get(i)[5]);
                                mapped.put("funded_date", csvData.get(i)[6]);
                                mapped.put("raised_amount", csvData.get(i)[7]);
                                mapped.put("raised_currency", csvData.get(i)[8]);
                                mapped.put("round", csvData.get(i)[9]);
                            } else {
                                continue;
                            }
                        }

                        if(options.containsKey("state")) {
                            if(csvData.get(i)[5].equals(options.get("state"))) {
                                mapped.put("permalink", csvData.get(i)[0]);
                                mapped.put("company_name", csvData.get(i)[1]);
                                mapped.put("number_employees", csvData.get(i)[2]);
                                mapped.put("category", csvData.get(i)[3]);
                                mapped.put("city", csvData.get(i)[4]);
                                mapped.put("state", csvData.get(i)[5]);
                                mapped.put("funded_date", csvData.get(i)[6]);
                                mapped.put("raised_amount", csvData.get(i)[7]);
                                mapped.put("raised_currency", csvData.get(i)[8]);
                                mapped.put("round", csvData.get(i)[9]);
                            } else {
                                continue;
                            }
                        }

                        if(options.containsKey("round")) {
                            if(csvData.get(i)[9].equals(options.get("round"))) {
                                mapped.put("permalink", csvData.get(i)[0]);
                                mapped.put("company_name", csvData.get(i)[1]);
                                mapped.put("number_employees", csvData.get(i)[2]);
                                mapped.put("category", csvData.get(i)[3]);
                                mapped.put("city", csvData.get(i)[4]);
                                mapped.put("state", csvData.get(i)[5]);
                                mapped.put("funded_date", csvData.get(i)[6]);
                                mapped.put("raised_amount", csvData.get(i)[7]);
                                mapped.put("raised_currency", csvData.get(i)[8]);
                                mapped.put("round", csvData.get(i)[9]);
                            } else {
                                continue;
                            }
                        }


                        return mapped;
                    }

                    throw new NoSuchEntryException();
                }*/

            }

            class NoSuchEntryException extends Exception {}

       // }
    //}
