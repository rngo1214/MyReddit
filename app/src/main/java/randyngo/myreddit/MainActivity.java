package randyngo.myreddit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import randyngo.myreddit.model.Feed;
import randyngo.myreddit.model.entry.Entry;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String BASE_URL = "https://reddit.com/r/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FeedAPI feedAPI = retrofit.create(FeedAPI.class);

        Call<Feed> call = feedAPI.getFeed();

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                //Log.d(TAG, "onResponse: feed: " + response.body().toString());
                Log.d(TAG, "onResponse: Server Response: " + response.toString());

                List<Entry> entrys = response.body().getEntrys();

                Log.d(TAG, "onResponse: entrys: " + response.body().getEntrys());

//                Log.d(TAG, "OnResponse: author: " + entrys.get(0).getAuthor().getName());
//                Log.d(TAG, "OnResponse: updated: " + entrys.get(0).getUpdated());
//                Log.d(TAG, "OnResponse: title: " + entrys.get(0).getTitle());

                for (int i = 0; i < entrys.size(); i++) {
                    ExtractXML extractXML1 = new ExtractXML(entrys.get(0).getContent(), "<a href=");
                    List<String> postContent = extractXML1.start();

                    ExtractXML extractXML2 = new ExtractXML(entrys.get(0).getContent(), "<img src=");

                    try {
                        postContent.add(extractXML2.start().get(0));
                    }
                    catch (NullPointerException e) {
                        postContent.add(null);
                        Log.e(TAG, "onResponse: NullPointerException(thumbnail): " + e.getMessage());
                    }
                    catch (IndexOutOfBoundsException e) {
                        postContent.add(null);
                        Log.e(TAG, "onResponse: IndexOutOfBoundsException(thumbnail): " + e.getMessage());
                    }

                }

            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.getMessage());
                Toast.makeText(MainActivity.this, "An Error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
