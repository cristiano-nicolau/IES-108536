package IpmaApiClient;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Response;

public class IpmaApiClient {
    private Retrofit retrofit;
    private IpmaService service;

    public IpmaApiClient() {
        retrofit = new Retrofit.Builder()
            .baseUrl("http://api.ipma.pt/open-data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        service = retrofit.create(IpmaService.class);
    }

    private List<String> CidadesDisponiveis() {
        Cities cities = getCitiesData();
        List<String> cityList = new ArrayList<String>();
        ListIterator<City> citiesIterator = cities.getData().listIterator();
        while (citiesIterator.hasNext()) {
            cityList.add(citiesIterator.next().getLocal());
        }

        return cityList;
    }

    public void PrintCidades() {
        List<String> cityList = CidadesDisponiveis();

        System.out.println();
        System.out.println("--- Available Cities ---");
        for(String s : cityList) {
            System.out.println(" - " + s);
        }
        System.out.println();
    }

    private IpmaCityForecast getCityForecast(String NomeCidade) {
        IpmaCityForecast forecast = null;
        Cities cities = getCitiesData();
        ListIterator<City> citiesIterator = cities.getData().listIterator();

        int cityCode = 0;
        while(citiesIterator.hasNext()) {
            City city = citiesIterator.next();
            if(city.getLocal().matches(NomeCidade)) {
                cityCode = city.getGlobalIdLocal();
                break;
            }
        }

        if(cityCode == 0) return null;

        forecast = getCityForecastFromId(cityCode);

        return forecast;
    }

    public void displayCityForecast(String NomeCidade) {
        IpmaCityForecast forecast = getCityForecast(NomeCidade);
        if(forecast == null) {
            System.out.println("That city is not available.");
            return;
        }

        List<CityForecast> forecastList = forecast.getData();
        
        System.out.println();
        System.out.printf("******************************************************************************************\n");
        System.out.println("--- Weather Forecast for " + NomeCidade + " ---");
        for(CityForecast c : forecastList) {

            System.out.println("    --- " + c.getForecastDate() + " ---");
            System.out.printf("MaxTemp: %4.1f ºC%n", Double.parseDouble(c.getTMax()));
            System.out.printf("MinTemp: %4.1f ºC%n", Double.parseDouble(c.getTMin()));
            System.out.printf("ProbPrecip: %2.1f %% %n", Double.parseDouble(c.getPrecipitaProb()));
            System.out.println("WeatherType: " + c.getIdWeatherType());
            System.out.printf("ClassWindSpeed: %s %n", c.getClassWindSpeed());

            System.out.println();
        }
        System.out.printf("******************************************************************************************\n");
    }

    private Cities getCitiesData() {
        Call<Cities> callCities = service.getDistritsIslands();
        Cities cities = null;

        try {
            Response<Cities> responseCities = callCities.execute();
            cities = responseCities.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }

    private IpmaCityForecast getCityForecastFromId(int cityId) {
        Call<IpmaCityForecast> callForecast = service.getForecastForACity(cityId);
        IpmaCityForecast forecast = null;

        try  {
            Response<IpmaCityForecast> responseForecast = callForecast.execute();
            forecast = responseForecast.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return forecast;
    }
    public static void main(String[] args) {
        IpmaApiClient client = new IpmaApiClient();
  
        //client.PrintCidades(); //Dar Print de todas as cidades.
        client.displayCityForecast("Aveiro");
        client.displayCityForecast("Viana do Castelo");
        client.displayCityForecast("Madeira");

    }


}