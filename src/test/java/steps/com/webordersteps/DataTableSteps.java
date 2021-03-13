package steps.com.webordersteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataTableSteps {

    @Given("the user print product titles")
    public void the_user_print_product_titles(DataTable dataTable) {

        // or public void user_print_credentials(DataTable dataTable) --> public void user_print_credentials(List<String> productInfo)
        List<String> productInfo= dataTable.asList();  // converting DataTable to List of String
        for(String info:productInfo){
            System.out.println(info);
        }
    }

    @Then("user print credentials")
    public void user_print_credentials(DataTable dataTable) { // Key - value style
        Map<String,String> credentials=dataTable.asMap(String.class,String.class); // type object

        Set<String> keys=credentials.keySet();  // to get all the keys from Set via keySet() method. KeySet
        for(String key:keys){
            System.out.println("Key: "+key+"Value: "+credentials.get(key));
        }
    }

    @Then("the user print product info")
    public void the_user_print_product_info(List<List<String>> products) { // List of List

      // print out the values from data table
        // the output will looks like data table
//         | MyMoney     | 4        | Techtorial  | 2200 E Devon | Chicago     |
//         | FamilyAlbum | 2        | Academy     | 2200 E Devon | Austin      |


        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.get(0).size(); j++) {
                System.out.print("| "+products.get(i).get(j)+" ");
            }
            System.out.println();

        }
//
//        for(List<String>row : products){
//            for(String detail : row){
//                System.out.println("| "+detail);;
//                System.out.println(" | ");
//                System.out.println();
//            }
//        }
    }

    @Then("the user print product details")
    public void the_user_print_product_details(DataTable dataTable) {
       List<Map<String, String>> details=dataTable.asMaps();

       /*
       we will have 2 maps in a List. For each map first row will be our keys and second row will be values

        */
        for(Map<String, String> detail:details){
            for(String key:detail.keySet()){
                System.out.println("Key: "+key+" Value: "+detail.get(key));
            }
            System.out.println("============");
        }
    }

}

