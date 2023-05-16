package co.za.programming.tech.invest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static co.za.programming.tech.invest.AddressPrinter.prettyPrintAddress;

public class AddressService {

    public static void main(String[] args) {

        AddressPrinter addressPrinter = new AddressPrinter();
        String fileName = "addresses.json";
        try {
            List<Address> addresses = readAddressesFromFile(fileName);

            // pretty print all addresses
            System.out.println("All Addresses:");
            for (Address address : addresses) {
                System.out.println(prettyPrintAddress(address));
            }

            System.out.println("\nAll address");
            addressPrinter.prettyPrintAllAddresses(addresses);

            System.out.println("\n Validate address");
            addressPrinter.validateAllAddresses(addresses);


        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
    }
    public void displayAddress(){

    }


    /**
     * Read list of addresses from a JSON file
     *
     * @param fileName name of JSON file
     * @return list of Address objects
     * @throws IOException
     * @throws JSONException
     */
    public static List<Address> readAddressesFromFile(String fileName) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        JSONArray json = new JSONArray(content);
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < json.length(); i++) {
            JSONObject obj = json.getJSONObject(i);
            Address address = new Address();
            address.setId(obj.getString("id"));

            JSONObject typeObj = obj.getJSONObject("type");
            Type type = new Type();
            type.setCode(typeObj.getString("code"));
            type.setName(typeObj.getString("name"));
            address.setType(type);

            JSONObject addressLineObj = obj.optJSONObject("addressLineDetail");
            if (addressLineObj != null) {
                AddressLineDetail addressLineDetail = new AddressLineDetail();
                addressLineDetail.setLine1(addressLineObj.optString("line1"));
                addressLineDetail.setLine2(addressLineObj.optString("line2"));
                address.setAddressLineDetail(addressLineDetail);
            }

            JSONObject provinceOrStateObj = obj.optJSONObject("provinceOrState");
            if (provinceOrStateObj != null) {
                ProvinceOrState provinceOrState = new ProvinceOrState();
                provinceOrState.setCode(provinceOrStateObj.getString("code"));
                provinceOrState.setName(provinceOrStateObj.getString("name"));
                address.setProvinceOrState(provinceOrState);
            }

            address.setCityOrTown(obj.optString("cityOrTown"));

            JSONObject countryObj = obj.getJSONObject("country");
            Country country = new Country();
            country.setCode(countryObj.getString("code"));
            country.setName(countryObj.getString("name"));
            address.setCountry(country);

            address.setPostalCode(obj.optString("postalCode"));
            address.setSuburbOrDistrict(obj.optString("suburbOrDistrict"));
            address.setLastUpdated(obj.optString("lastUpdated"));

            addresses.add(address);
        }
        return addresses;
    }
}
class AddressUtil{
    public static Address fromJsom(JSONObject obj) throws JSONException{
        Address address = new Address();
        return address;
    }
}