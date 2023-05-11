package ohm.softa.a08.service;

import com.google.gson.Gson;
import ohm.softa.a08.api.OpenMensaAPI;
import ohm.softa.a08.model.Meal;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class OpenMensaAPIService implements OpenMensaAPI {

	private static final OpenMensaAPIService instance = new OpenMensaAPIService();
	private static OpenMensaAPI mensaApiInstance;

	private OpenMensaAPIService(){
		Retrofit retrofit = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("http://openmensa.org/api/v2/")
			.build();

		/* create OpenMensaAPI instance */
		mensaApiInstance = retrofit.create(OpenMensaAPI.class);
	}

	public static OpenMensaAPIService getInstance(){
		return instance;
	}

	public OpenMensaAPI getApi(){
		return mensaApiInstance;
	}

	@Override
	public Call<List<Meal>> getMeals(String date) {
		return this.getInstance().getApi().getMeals(date);
	}
}
