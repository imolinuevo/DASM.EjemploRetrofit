package es.upm.miw.demoretrofit;

import java.util.List;

import es.upm.miw.demoretrofit.models.Group;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface TDWGroupAPIService {

    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("/TDW_UserApi/v1/group")
    Call<List<Group>> getGroups();

    @GET("/TDW_UserApi/v1/group/groupname/{groupname}")
    Call<Group> getGroupByGroupname(@Path("groupname") String groupname);

    @GET("/TDW_UserApi/v1/group/{groupId}")
    Call<Group> getGroupById(@Path("groupId") int groupId);

}
