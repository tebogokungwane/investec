package co.za.programming.tech.invest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddressServiceTest {

    private List<Address> addresses;
    private Address address;

    @Before
    public void setup(){
        address = new Address();
        addresses = new ArrayList<>();

        Address address1 = new Address(
                "1", new Type("1","Physical Address"),
                new AddressLineDetail("Address 1", "Line 2"),
                new ProvinceOrState("5","Eastern Cape"),
                "City 1",
                new Country("ZA","South Africa"),
                "1234",
                "2017-06-21T00:00:00.000Z"
        );

        Address address2 = new Address("2", new Type("2","Postal Address"),
                null,
                null,
                "City 2",
                new Country("LB","Lebanon"),
                "1234",
                "2017-06-21T00:00:00.000Z"
        );

        Address address3 = new Address(
                "1", new Type("1","Physical Address"),
                new AddressLineDetail("Address 1", "Line 2"),
                new ProvinceOrState("5","Eastern Cape"),
                "City 1",
                new Country("ZA","South Africa"),
                "1234",
                "2017-06-21T00:00:00.000Z"
        );

        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
    }

    @Test
    public void testPrettyPrintAddress(){
        address.setId("1");
        Type type = new Type();
        type.setCode("1");
        type.setName("Physical Address");
        address.setType(type);

        AddressLineDetail addressLineDetail = new AddressLineDetail();
        addressLineDetail.setLine1("Address 1");
        addressLineDetail.setLine2("Line 2");
        address.setAddressLineDetail(addressLineDetail);

        ProvinceOrState provinceOrState = new ProvinceOrState();
        provinceOrState.setCode("0");
        provinceOrState.setName("Eastern Cape");
        address.setProvinceOrState(provinceOrState);
        address.setCityOrTown("City 1");

        Country country = new Country();
        country.setCode("ZA");
        country.setName("South Africa");
        address.setCountry(country);
        address.setPostalCode("1234");
        address.setLastUpdated("2015-06-21T00:00:00.000Z");

        AddressPrinter addressPrinter1 = new AddressPrinter();

        String prettyPrintAddress = addressPrinter1.prettyPrintAddress(address);
        assertThat(prettyPrintAddress, is("Physical Address: Address 1 - City 1 - Eastern Cape - 1234 - South Africa"));

    }

    @Test
    public void testPrettyPrintAddress_NegativeScenario(){
        address = new Address();
        AddressPrinter addressPrinter = new AddressPrinter();

        address.setId("1");
        Type type = new Type();
        type.setCode("1");
        type.setName("Physical Address");
        address.setType(type);

        AddressLineDetail addressLineDetail = new AddressLineDetail();
        addressLineDetail.setLine1("Address 1");
        addressLineDetail.setLine2("Line 2");
        address.setAddressLineDetail(addressLineDetail);

        ProvinceOrState provinceOrState = new ProvinceOrState();
        provinceOrState.setCode("0");
        provinceOrState.setName("Cape Town");
        address.setProvinceOrState(provinceOrState);
        address.setCityOrTown("City 1");

        Country country = new Country();
        country.setCode("ZA");
        country.setName("South Africa");
        address.setCountry(country);
        address.setPostalCode("1234");
        address.setLastUpdated("2015-06-21T00:00:00.000Z");


        String prettyPrintAddress = addressPrinter.prettyPrintAddress(address);

        assertThat(prettyPrintAddress, Matchers.not("Physical Address: Address 1 - City 1 - Eastern Cape - 1234 - South Africa"));

}
