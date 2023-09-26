package com.myweatherradar.app;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.myweatherradar.app.ipma_client.CityForecast;
import com.myweatherradar.app.ipma_client.IpmaCityForecast;
import com.myweatherradar.app.ipma_client.IpmaService;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Argument error! Please specify a city ID as the only argument.");           
            System.exit(1);
        }

        int cityCode =0;

        try {
            cityCode = Integer.parseInt(args[0]);
        } catch(NumberFormatException e) {
            System.err.println("Argument error! Expected and integer value.");
            System.exit(1);
        }

        // get a retrofit instance, loaded with the Gson library to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityCode);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null && forecast.getData() != null && !forecast.getData().isEmpty()) {
                // Print the forecast information for the first day
                CityForecast firstDay = forecast.getData().get(0);
                System.out.printf("******************************************************************************************\n");
                System.out.printf("Weather forecast for Latitude: %s, Longitude: %s:%n", firstDay.getLatitude(), firstDay.getLongitude());
                System.out.printf("Data: %s%n", firstDay.getForecastDate());
                System.out.printf("Max Temperature: %.1f°C, Min Temperature: %.1f°C%n", Double.parseDouble(firstDay.getTMax()), Double.parseDouble(firstDay.getTMin()));
                System.out.printf("Probability of precipitation: %s%n", firstDay.getPrecipitaProb());
                System.out.printf("Wind Speed: %.1f km/h%n", (double) firstDay.getClassWindSpeed());
                System.out.printf("Weather Type: %s%n", firstDay.getPredWindDir());
                System.out.printf("******************************************************************************************\n");
            } else {
                System.out.println("No results for this request or invalid city code!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
