package problems.java;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.print(5);
        parent = new Child();
        parent.print(2.2f);
        Child c = new Child();
        c.print(2.2f);
        c.print("2");

    }

    static class Parent {
        void print(int a) {
            System.out.println("int=" + a);
        }

        void print(String a) {
            System.out.println("String=" + a);
        }

        void print(float a) {
            System.out.println("parent-float=" + a);
        }
    }

    static class Child extends Parent {


        void print(String a) {
            System.out.println("child-String=" + a);
        }
    }

    class ApiResponse {
        int page;
        int per_page;
        int total;
        int total_pages;
        Data data;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    class Data {
        String name;
        String organized_by;
        List<Integer> ticket_prices;
        int capacity_left;
        int people_registered;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrganized_by() {
            return organized_by;
        }

        public void setOrganized_by(String organized_by) {
            this.organized_by = organized_by;
        }

        public List<Integer> getTicket_prices() {
            return ticket_prices;
        }

        public void setTicket_prices(List<Integer> ticket_prices) {
            this.ticket_prices = ticket_prices;
        }

        public int getCapacity_left() {
            return capacity_left;
        }

        public void setCapacity_left(int capacity_left) {
            this.capacity_left = capacity_left;
        }

        public int getPeople_registered() {
            return people_registered;
        }

        public void setPeople_registered(int people_registered) {
            this.people_registered = people_registered;
        }
    }
}
