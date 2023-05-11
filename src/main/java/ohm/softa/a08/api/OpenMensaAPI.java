package ohm.softa.a08.api;

import java.util.List;

import ohm.softa.a08.model.Meal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Peter Kurfer on 11/19/17.
 */

public interface OpenMensaAPI {


	/**
	 * Get meals of a specific date. 265 is Insel Schütt
	 *
	 * @param date date for which the meals should be retrieved
	 * @return Retrofit Call wrapper object
	 * @remark results in a call like this GET /canteens/265/days/2017-11-22/meals
	 */
	@GET("canteens/269/days/{date}/meals")
	Call<List<Meal>> getMeals(@Path("date") String date);
}
