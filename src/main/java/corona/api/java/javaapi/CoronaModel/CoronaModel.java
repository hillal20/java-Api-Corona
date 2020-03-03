package corona.api.java.javaapi.CoronaModel;


public class CoronaModel {

    private String  country ;
    private  String  latestStats;
    private String province;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatestStats() {
        return latestStats;
    }

    public void setLatestStats(String latestStats) {
        this.latestStats = latestStats;
    }

    @Override
    public String toString() {
        return "CoronaModel{" +
                "province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", latestStats='" + latestStats + '\'' +
                '}';
    }
}
