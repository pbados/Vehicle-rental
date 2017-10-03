package pl.bados.patryk.angularv2.dto;

public class BikeDto extends VehicleDto{

    private String vehicleName;
    private Long id;
    private final String type = "Bike";

    public BikeDto(String vehicleName, Long id, String type) {
        this.vehicleName = vehicleName;
        this.id = id;
    }

    public BikeDto(){}

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
}
