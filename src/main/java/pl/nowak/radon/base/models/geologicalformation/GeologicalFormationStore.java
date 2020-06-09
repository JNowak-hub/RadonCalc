package pl.nowak.radon.base.models.geologicalformation;

import java.util.ArrayList;
import java.util.Set;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.nowak.radon.base.models.district.District;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeologicalFormationStore {
	private ArrayList<GeologicalFormation> formations = new ArrayList<GeologicalFormation>();

	public String[] getFormationDescription() {
		String[] formationDescription = new String[formations.size()];

		for (int i = 0; i < formations.size(); i++) {
			formationDescription[i] = formations.get(i).getFormationDescription();
		}

		return formationDescription;
	}

	public ArrayList<District> getDistricts() {
		ArrayList<District> districts = new ArrayList<District>();

		for (GeologicalFormation formation : formations) {
			districts.add(formation.getDistrict());
		}
		return districts;
	}

	public ArrayList<GeologicalFormation> getGeologicalFormations() {
		return formations;
	}

	public void addFormation(GeologicalFormation formation) {
		formations.add(formation);
	}

	public ArrayList<GeologicalFormation> getFormations() {
		return formations;
	}

	public void setFormations(ArrayList<GeologicalFormation> formations) {
		this.formations = formations;
	}
	
	
}
