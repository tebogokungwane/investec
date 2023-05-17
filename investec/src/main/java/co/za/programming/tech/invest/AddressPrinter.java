package co.za.programming.tech.invest;

import java.util.List;

public class AddressPrinter {

    public static String prettyPrintAddress(Address address) {
        StringBuilder sb = new StringBuilder();
        sb.append(address.getType().getName()).append(": ");
        if (address.getAddressLineDetail() != null) {
            sb.append(address.getAddressLineDetail().getLine1()).append(" - ");
            if (address.getCityOrTown() != null) {
                sb.append(address.getCityOrTown()).append(" - ");
            }
            if (address.getProvinceOrState() != null) {
                sb.append(address.getProvinceOrState().getName()).append(" - ");
            }
            sb.append(address.getPostalCode()).append(" - ");
        }
        sb.append(address.getCountry().getName());
        return sb.toString();
    }

    //  a. Type: Line details - city - province/state - postal code – country

//    Physical Address: Address 1 - City 1 - Eastern Cape - 1234 - South Africa
//    Postal Address: Lebanon
//    Business Address: Address 3 - City 3 - 3456 - South Africa



    public  void prettyPrintAllAddresses(List<Address> addresses) {
        for (Address address : addresses) {
            System.out.println(prettyPrintAddress(address));
        }
    }

    public  void validateAllAddresses(List<Address> addresses) {
        AddressValidator validator = new AddressValidator();
        for (Address address : addresses) {
            boolean isValid = validator.isValid(address);
            if (isValid) {
                System.out.println(prettyPrintAddress(address) + " is valid");
            } else {
                System.out.println(prettyPrintAddress(address) + " is invalid");
            }
        }
    }
}

