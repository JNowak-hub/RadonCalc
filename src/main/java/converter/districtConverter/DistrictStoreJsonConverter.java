package converter.districtConverter;

import converter.JsonConverter;
import pl.nowak.radon.base.models.district.DistrictStore;

public class DistrictStoreJsonConverter extends JsonConverter<DistrictStore>{

	public DistrictStoreJsonConverter(String jsonFilename) {
		super(jsonFilename);
	}

}
