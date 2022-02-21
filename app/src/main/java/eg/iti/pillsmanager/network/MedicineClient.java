package eg.iti.pillsmanager.network;

public class MedicineClient implements RemoteSource {
    final static String BASE_URL = "https://api.androidhive.info/";

    private static MedicineClient medicineClient;

    private MedicineClient() {
    }

    public static MedicineClient getMedicineClientInstance() {
        if (medicineClient == null) {
            medicineClient = new MedicineClient();
        }
        return medicineClient;
    }

    @Override
    public void enqueue(NetworkDelegate networkDelegate) {
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit
//                .Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();

//        Api_interface api_interface = retrofit.create(Api_interface.class);

//        Call<ArrayList<Movie>> call = api_interface.getMovies();

//        call.clone().enqueue(new Callback<ArrayList<Movie>>() {
    }

    public static class getMovieClientInstance implements RemoteSource {
        @Override
        public void enqueue(NetworkDelegate networkDelegate) {

        }
    }
//            @Override
//            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
//                networkDelegate.onSuccessResult(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {
//                networkDelegate.onFailureResult(t.getCause().getMessage());
//            }
//        });
//    }
//
}