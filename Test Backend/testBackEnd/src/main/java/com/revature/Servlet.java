package main.java.com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.naming.NameNotFoundException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class Servlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    String output = "{\"username\": \"Luft\", \"firstname\": \"Sean\", \"lastname\": \"Mc\"}";
//     Gson gson;
//     public Servlet(){
//         gson = new Gson();
//         gson.toJson("{\"username\": \"Luft\", \"password\": \"luft\", \"firstname\": \"Sean\", \"lastname\": \"Mc\"}");
//     }
// public Gson getJson(){
//     return this.gson;
// }

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//  Connection connection = this.ConnectionUtil();
response.setContentType("text/plain");
response.getWriter().write(output);
// System.out.println(gson);

}


public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

    chain.doFilter(req, res);
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    JsonObject json = new JsonParser().parse(output).getAsJsonObject();
    response.setContentType("application/json");
    // response.setHeader("Access-Control-Allow-Origin", "*");
    // response.setHeader("Access-Control-Allow-Methods", "POST, GET");
    try{
    // chain.doFilter(request, response);
    response.getWriter().print(json);
    } catch(Exception e){
        e.printStackTrace();
    }

}

// public Connection ConnectionUtil(){
//     try{
//         String url = "";
//         String user = "";
//         String password = "";
        
//         Class.forName("org.postgresql.Driver");

//         Connection connection = DriverManager.getConnection(url, user, password);
//         return connection;
//       } catch(Exception e){
//           e.printStackTrace();
//       }
//     return null;

// }
}