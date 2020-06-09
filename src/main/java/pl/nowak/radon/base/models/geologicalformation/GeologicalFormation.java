package pl.nowak.radon.base.models.geologicalformation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.nowak.radon.base.models.district.District;

@Data
@AllArgsConstructor
@Builder
public class GeologicalFormation {
	
	private String formationDescription;
	private District district;
	private int formationId;
	
	public GeologicalFormation(String formationDescription, District district, int formationId) {
		super();
		this.formationDescription = formationDescription;
		this.district = district;
		this.formationId = formationId;
	}

	public String getFormationDescription() {
		return formationDescription;
	}

	public void setFormationDescription(String formationDescription) {
		this.formationDescription = formationDescription;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public int getFormationId() {
		return formationId;
	}

	public void setFormationId(int formationId) {
		this.formationId = formationId;
	}

	@Override
	public String toString() {
		return "GeologicalFormation [formationDescription=" + formationDescription + ", district=" + district
				+ ", formationId=" + formationId + "]";
	}
}
