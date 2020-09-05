import java.io.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.google.gson.*;
import com.google.appengine.api.datastore.*;

@WebServlet("/create-post")
public class CreatePostServlet extends HttpServlet{
    public ArrayList<String> posts = new ArrayList<String>();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = getParameter(request, "text", "");
        String location = getParameter(request, "location", "");
        Entity postEntity = new Entity("Post");
        postEntity.setProperty("text", text);
        postEntity.setProperty("location", location);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(postEntity);
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect("/news.html");
        response.getWriter().println(postEntity);
    }
    
    // method to get http parameters
    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }
}