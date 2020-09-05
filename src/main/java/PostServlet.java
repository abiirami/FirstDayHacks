import java.io.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.google.gson.*;
import com.google.appengine.api.datastore.*;

@WebServlet("/posts")
public class PostServlet extends HttpServlet{
    public ArrayList<String> posts = new ArrayList<String>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Query query = new Query("Post");
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery results = datastore.prepare(query);
        List<Post> posts = new ArrayList<>();

        for (Entity entity : results.asIterable()) {
            String location = (String) entity.getProperty("location");
            String text = (String) entity.getProperty("text");
            Post postObject = new Post(text, location);
            posts.add(postObject);
        }
        System.out.println(posts);
        Gson gson = new Gson();
        String json = gson.toJson(posts);
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }
}