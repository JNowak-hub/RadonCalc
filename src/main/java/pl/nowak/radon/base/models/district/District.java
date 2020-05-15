package pl.nowak.radon.base.models.district;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class District {
	private String districtName;
	private int districtId;
	
	public District(String districtName, int districtId) {
		super();
		this.districtName = districtName;
		this.districtId = districtId;
	}

	@Override
	public String toString() {
		return "District [districtName=" + districtName + ", districtId=" + districtId + "]";
	}
	
}
