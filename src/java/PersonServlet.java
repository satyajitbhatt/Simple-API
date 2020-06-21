import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.Person;
import com.example.DataStore;

import org.json.JSONObject;

public class PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring(requestUrl.lastIndexOf("/") + 1);
        Person person = DataStore.getInstance().getPerson(name);
        
        if(person != null) {
            String json = "{\n";
            json += "   \"name\": " + JSONObject.quote(person.getName()) + ",\n";
            json += "   \"about\": " + JSONObject.quote(person.getAbout()) + ",\n";
            json += "   \"birthYear\": " + person.getBirthYear() + "\n";
            json += "}";
            response.getOutputStream().println(json);
        }
        else {
            //That person wasn't found, so return an empty JSON object. We could also return an error.
            System.err.println("Empty JSON..!!!");
            response.getOutputStream().println("{}");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
	String about = request.getParameter("about");
	int birthYear = Integer.parseInt(request.getParameter("birthYear"));
		
	DataStore.getInstance().putPerson(new Person(name, about, birthYear));
        
    }

}