package randyngo.myreddit;

import randyngo.myreddit.model.Feed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FeedAPI {

    String BASE_URL ="https://reddit.com/r/";

    //Non-static feed name
    @GET("{feed_name}/.rss")
    Call<Feed> getFeed(@Path("feed_name") String feed_name);
    //Static URL for testing purposes
//    @GET("earthporn/.rss")
//    Call<Feed> getFeed();
}
