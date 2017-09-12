package pl.bados.patryk.angularv2.dto;

public class BikeDto extends VehicleDto{

    private String vehicleName;

    public BikeDto(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public BikeDto(){}

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
