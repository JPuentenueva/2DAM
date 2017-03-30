package psp.filtroretrofit.interfaces;

import psp.filtroretrofit.pojo.Task;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by jmpuentenueva on 29/11/2016.
 */

public interface UserService {
    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })
    @GET("/tasks/{task_id}")
    Call<Task> getTask(@Path("task_id") long taskId);
}
