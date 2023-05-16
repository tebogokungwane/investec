package co.za.programming.tech.invest;

public class AddressValidator {
    public boolean isValid(Address address) {
        if (address.getPostalCode() == null || !address.getPostalCode().matches("\\d+")) {
            return false;
        }
        if (address.getCountry() == null) {
            return false;
        }
        if (address.getAddressLineDetail() == null || (address.getAddressLineDetail().getLine1() == null && address.getAddressLineDetail().getLine2() == null)) {
            return false;
        }
        if ("ZA".equals(address.getCountry().getCode()) && address.getProvinceOrState() == null) {
            return false;
        }
        return true;
    }
}
