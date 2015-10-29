package es.upm.miw.demoretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import es.upm.miw.demoretrofit.models.Group;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ActividadPrincipal extends AppCompatActivity {

    static String API_BASE_URL = "http://tdw00.calamar.etsisi.upm.es/";

    static String LOG_TAG = "DemoRetrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        final TextView tvContenido = (TextView) findViewById(R.id.tvContenido);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TDWGroupAPIService apiService = retrofit.create(TDWGroupAPIService.class);

        Call<Group> call_async = apiService.getGroupById(19);

        // Asíncrona
        call_async.enqueue(new Callback<Group>() {
            @Override
            public void onResponse(Response<Group> response, Retrofit retrofit) {
                // recupero el grupo obtenido
                Group g = response.body();
                tvContenido.setText(g.toString());
                Log.i(LOG_TAG, "ASYNC => " + g.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(LOG_TAG, t.getMessage());
            }
        });

        // Síncrona... no aquí => NetworkOnMainThreadException
//        Call<Group> call_sync = apiService.getGroupById(2);
//        try {
//            Group g = call_sync.execute().body();
//            Log.i(LOG_TAG, "SYNC => " + g.toString());
//        } catch (IOException e) {
//            Log.e(LOG_TAG, e.getMessage());
//        }

    }
}