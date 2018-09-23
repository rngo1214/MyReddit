package randyngo.myreddit;

import randyngo.myreddit.model.Feed;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FeedAPI {
    String BASE_URL ="https://reddit.com/r/";
    //Static URL for testing purposes
    @GET("earthporn/.rss")
    Call<Feed> getFeed();
}
