package pl.nowak.radon.base;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.JsonObject;

import converter.JsonConverter;
import converter.locationConverter.LocationJsonConverter;
import converter.locationConverter.LocationStoreJsonConverter;
import pl.nowak.radon.base.models.district.District;
import pl.nowak.radon.base.models.geologicalformation.GeologicalFormation;
import pl.nowak.radon.base.models.location.Location;
import pl.nowak.radon.base.models.location.LocationStore;
import pl.nowak.radon.base.userinterface.mainmenu.MainMenu;
import pl.nowak.radon.base.userinterface.mainmenu.MainMenu2;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		
		
		try {
			MainMenu2 window = new MainMenu2();
			window.getFrame().setVisible(true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
//		LocationStore s = new LocationStore();
//
//		Location location = new Location("Katowice", "Krótka 32", 442, 12);
//		location.setDistrict(new District("Ochojec", 1));
//		location.setFormation(new GeologicalFormation("descr", location.getDistrict(), 1));
//
//		System.out.println(location);
//		
//		Location location2 = new Location("Brynow", "Kdada 32", 442, 12);
//		location2.setDistrict(new District("dda", 3));
//		location2.setFormation(new GeologicalFormation("descr", location.getDistrict(), 1));
//
//		Location location3 = new Location("Katowice", "Krótka 2", 442, 12);
//		location3.setDistrict(new District("dadad", 4));
//		location3.setFormation(new GeologicalFormation("descr", location.getDistrict(), 1));
//
//		s.addLocation(location);
//		s.addLocation(location2);
//		s.addLocation(location3);
//
//		LocationStoreJsonConverter converter = new LocationStoreJsonConverter("test2");
//		converter.toJson(s);
	}
}
