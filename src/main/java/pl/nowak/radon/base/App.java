package pl.nowak.radon.base;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

import javax.swing.JFileChooser;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.JsonObject;

import converter.JsonConverter;
import converter.districtConverter.DistrictStoreJsonConverter;
import converter.geologicalFormationConverter.GeologicalFormationStoreJsonConverter;
import converter.locationConverter.LocationJsonConverter;
import converter.locationConverter.LocationStoreJsonConverter;
import pl.nowak.radon.base.models.district.District;
import pl.nowak.radon.base.models.district.DistrictStore;
import pl.nowak.radon.base.models.geologicalformation.GeologicalFormation;
import pl.nowak.radon.base.models.geologicalformation.GeologicalFormationStore;
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

		
		
		
/*
 *  					TEST OF JSON Converter
 */
		
//
//		GeologicalFormationStore s = new GeologicalFormationStore();
//		DistrictStoreJsonConverter c = new DistrictStoreJsonConverter("C:\\Users\\nowak\\OneDrive\\Dokumenty\\EclipseProjects\\base\\Districts");
//		GeologicalFormationStoreJsonConverter gc = new GeologicalFormationStoreJsonConverter("GeologicalFormations");
//		System.out.println(((DistrictStore)c.fromJson().get()).getDistricts().get(0).toString());
//		
//		GeologicalFormation f = new GeologicalFormation("pierwsz formacja", ((DistrictStore)c.fromJson().get()).getDistricts().get(0) ,1);
//		System.out.println(f.toString());
//				
//		s.addFormation(f);
//		s.addFormation(new GeologicalFormation("druga formacja", ((DistrictStore)c.fromJson().get()).getDistricts().get(1) ,2));
//		s.addFormation(new GeologicalFormation("trzecia formacja", ((DistrictStore)c.fromJson().get()).getDistricts().get(2) ,3));
//		s.addFormation(new GeologicalFormation("czwarta formacja", ((DistrictStore)c.fromJson().get()).getDistricts().get(3) ,4));
//		s.addFormation(new GeologicalFormation("piąta formacja", ((DistrictStore)c.fromJson().get()).getDistricts().get(0) ,5));
//		s.addFormation(new GeologicalFormation("szósta formacja", ((DistrictStore)c.fromJson().get()).getDistricts().get(2) ,6));
//
//		gc.toJson(s);
		
//		DistrictStore s = new DistrictStore();
//		
//		District one = new District("Ochojce",1);
//		District two = new District("Pioiro",2);
//		District three = new District("Miko",3);
//		
//		s.addDistrict(one);
//		s.addDistrict(two);
//		s.addDistrict(three);
//		
//		DistrictStoreJsonConverter c = new DistrictStoreJsonConverter("Districts");
//		c.toJson(s);
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
//		System.out.println(s.getLocations().toArray().toString());

		
//		LocationStoreJsonConverter converter = new LocationStoreJsonConverter("test2");
//		converter.toJson(s);
	}
}
