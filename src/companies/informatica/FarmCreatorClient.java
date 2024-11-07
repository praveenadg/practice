package companies.informatica;
public class FarmCreatorClient {
    public static class FarmCreator {
        public double totalValue = 0.0;// all these variables can be private
        public String farm = "";
        public int addLandCount = 100;// final static
        public int numCows = 0;
        public int numFish = 0;
        public int numCrops = 0;//have a constructor and initialize these variables

        public void createLand(String farmName, String farmType) {//farmType can be enum
            System.out.println("Creating land for " + farmName + " of type " + farmType);//replace this logger statement like info or debug
            int valueToAdd = 0;
            if (farmType == "Cattle") {// check for null and use .equals()
                valueToAdd += 5000;
                int count = this.addLandCount;
                while (count > 0) {// can be for loop too
                    farm += "cow cow cow";//stringbuilder instead of +
                    System.out.println("adding some cows ");//move it outside the loop
                    System.out.println("cow care");//move it outside the loop
                    numCows += 4;//if this can overflow int range then we can use long
                    System.out.println("total cows " + numCows);//can be moved outside the loop

                    count--;
                }
            } else if (farmType == "Fish") { //CattleFarmCreator FishFarmCreator .. extend FarmCreator
                valueToAdd += 2000;
                int count = this.addLandCount;
                while (count > 0) {
                    farm += "fish";
                    System.out.println("adding some cows");
                    numFish += 1;
                    count--;
                }
            } else if (farmType == "Crops") {
                valueToAdd += 1000;
                int count = this.addLandCount;
                while (count > 0) {
                    farm += "crops";
                    System.out.println("adding some crops");
                    System.out.println("water crops");
                    System.out.println("collect seeds");
                    numCrops += 2;
                    count--;
                }
            }
            valueToAdd -= 10;
            valueToAdd += valueToAdd * .3;//can valueToAdd be double?
            totalValue += valueToAdd;//possible lossy conversion
        }

        public void addPlants(String farmName, String farmType) {//param farmName not used
            if (farmType == "Cattle") {//null check and use .equal() or we can make it a enum
                System.out.println("planting grass");
            } else if (farmType == "Fish") {
                System.out.println("planting algae");
            } else if (farmType == "Crops") {
                System.out.println("Planting clover");//use loggers
            }
        }


        public String payTaxes(int payers) {//param not used
            // this.totalValue * .1
            String taxInfo = "sales:" + this.totalValue * .1 + ":"
                    + "property:" + this.totalValue * .2 + ":"
                    + "income:" + this.totalValue * .3 + ":"
                    + "total:" + this.totalValue * .6;// can be stringbuilder //use pojo to set these values

            return taxInfo;

        }


    }

//=====================================


   // public class FarmCreatorClient {


        public static void main(String[] args) {

            String firstFarmName = "Farm1";
            String secondFarmName = "Farm2";
            String thirdFarmName = "Farm3";

            final int numLand = 30;
            final int numPlants = 20;


            System.out.println("Creating number of lands: " + numLand + " num plants: " + numPlants);//logger.info(""{})
            FarmCreator farm1 = new FarmCreator();
            for (int i = 0; i < numLand; i++) {
                farm1.createLand(firstFarmName, "Cattle");
            }
            for (int i = 0; i < numPlants; i++) {
                farm1.addPlants(firstFarmName, "Cattle");
            }
            FarmCreatorClient.payTaxes(farm1);
            System.out.println("Created farm: " + farm1.farm);

            System.out.println(numLand + " , " + numPlants);
            FarmCreator farm2 = new FarmCreator();
            for (int i = 0; i < numLand; i++) {
                farm2.createLand(secondFarmName, "Fish");
            }
            for (int i = 0; i < numPlants; i++) {
                farm2.createLand(secondFarmName, "Fish");
            }
            FarmCreatorClient.payTaxes(farm2);// can be non-static
            System.out.println("Created farm: " + farm2.farm);


            System.out.println("Creating number of lands: " + numLand + " num plants: " + numPlants);//for consistency if it is really needed then add for form2 or remove from both the places
            FarmCreator farm3 = new FarmCreator();
            for (int i = 0; i < numLand; i++) {
                farm3.createLand(secondFarmName, "Crops");//should be thirdFarmName
            }
            for (int i = 0; i < numPlants; i++) {
                farm3.addPlants(secondFarmName, "Crops"); //should be thirdFarmName
            }
            FarmCreatorClient.payTaxes(farm3);
            System.out.println("Created farm: " + farm3.farm);


        }

        public static void payTaxes(FarmCreator farm) {//private
            System.out.println("paying taxes");

            String farmOutput = farm.payTaxes(5);//we are not using 5 //class TaxInfo{}
            String[] splitOutput = farmOutput.split(":");
        /* String taxInfo = "sales:" + this.totalValue * .1 +":"
                + "property:" + this.totalValue * .2 + ":"
                + "income:" + this.totalValue * .3 + ":"
                + "total:" + this.totalValue * .6;*/ //remove commented code
            String total = splitOutput[7];// create a pojo to hold these values sales, property.. and use getters and setters
            String propertyTax = splitOutput[3];//getProp
            System.out.println("Paying total tax: " + total + " property tax: " + propertyTax);
            System.out.println("Paid total tax: " + total + " property tax: " + propertyTax);

        }
    }





















