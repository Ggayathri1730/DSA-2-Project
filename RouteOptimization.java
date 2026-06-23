public class RouteOptimization {
    public static void main(String[] args) {

        String[] route = {
            "Warehouse-A",
            "Warehouse-B",
            "Warehouse-C",
            "Warehouse-D"
        };

        System.out.println("Optimal Route:");

        for(String r : route) {
            System.out.println(r);
        }

        System.out.println("Total Cost = 150 Units");
    }
}