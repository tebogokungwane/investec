package co.za.programming.tech.invest;

public class ProvinceOrState {
    private String code;
    private String name;

    public ProvinceOrState(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public ProvinceOrState() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
