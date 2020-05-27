package pl.nowak.radon.base.models.district;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.nowak.radon.base.models.location.Location;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistrictStore {
	@Override
	public String toString() {
		return "DistrictStore [districts=" + districts + "]";
	}

	private ArrayList<District> districts = new ArrayList<District>();

	public Object[][] districtDataToString() {
		String elements;
		for (int i = 0; i < districts.size(); i++) {
		}
		return null;
	}

	public ArrayList<District> getDistricts() {
		return districts;
	}

//	public District getDistrictById(int id) {
//
//		for (Iterator<District> it = districts.iterator(); it.hasNext();) {
//			District f = it.next();
//			if (f.getDistrictId() == id)
//				return f;
//		}
//		return null;
//	}

	public void addDistrict(District district) {
		districts.add(district);
	}
}
