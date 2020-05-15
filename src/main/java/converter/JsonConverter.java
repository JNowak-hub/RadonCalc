package converter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StackWalker.Option;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class JsonConverter<T> {

	private final String jsonFilename;
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private final Type type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	public JsonConverter(String jsonFilename) {this.jsonFilename = jsonFilename;}
	
	public void toJson(final T element) {
		try(FileWriter fileWriter = new FileWriter(jsonFilename, true)) {
			if(element == null) {
				throw new NullPointerException("ELEMENT IS EMPTY");
			}
			gson.toJson(element, fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public Optional<Object> fromJson() {
		try(FileReader fileReader = new FileReader(jsonFilename)){
			return Optional.of(gson.fromJson(fileReader, type));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
