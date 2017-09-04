package pl.bados.patryk.angularv2.dto;

public class BikeDto {

    private String vehicleName;

    public BikeDto(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public BikeDto(){}

    @Override
    public String toString() {
        return "BikeDto{" +
                "vehicleName='" + vehicleName + '\'' +
                '}';
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
