package pl.nowak.radon.base.models.location;

import lombok.Builder;
import lombok.Data;
import pl.nowak.radon.base.models.district.District;
import pl.nowak.radon.base.models.geologicalformation.GeologicalFormation;

@Data
@Builder
public class Location {
	private String city;
	private District district;
	private String adress;
	private String placeOfMeasurement;
	private GeologicalFormation formation;
	private double radonConcentration;
	private double error_Rn;
	
	
	
	public Location(String city, String adress, double radonConcentration, double error_Rn) {
		super();
		this.city = city;
		this.adress = adress;
		this.radonConcentration = radonConcentration;
		this.error_Rn = error_Rn;
	}



	@Override
	public String toString() {
		return "Location [city=" + city + ", district=" + district + ", adress=" + adress + ", placeOfMeasurement="
				+ placeOfMeasurement + ", formation=" + formation + ", radonConcentration=" + radonConcentration
				+ ", error_Rn=" + error_Rn + "]";
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public District getDistrict() {
		return district;
	}



	public void setDistrict(District district) {
		this.district = district;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public String getPlaceOfMeasurement() {
		return placeOfMeasurement;
	}



	public void setPlaceOfMeasurement(String placeOfMeasurement) {
		this.placeOfMeasurement = placeOfMeasurement;
	}



	public GeologicalFormation getFormation() {
		return formation;
	}



	public void setFormation(GeologicalFormation formation) {
		this.formation = formation;
	}



	public double getRadonConcentration() {
		return radonConcentration;
	}



	public void setRadonConcentration(double radonConcentration) {
		this.radonConcentration = radonConcentration;
	}



	public double getError_Rn() {
		return error_Rn;
	}



	public void setError_Rn(double error_Rn) {
		this.error_Rn = error_Rn;
	}
	

}
