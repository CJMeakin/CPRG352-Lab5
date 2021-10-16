
package servlets;

import services.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Connor
 */
public class loginServlet extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();  
        
        if(session.getAttribute("user") != null){ // check if the user alread has a session that they are logged into
             getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response); 
        }else{ //if not logged in laready send to login page
            request.setAttribute("welcomeMsg", "Hope your name is Barb or Abe.");   
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }           
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(request.getParameter("logOperation") != null && request.getParameter("logOperation").equals("login")){ //login button pressed
            
            User user = new User(request.getParameter("username"),request.getParameter("password")); //new user obj with login info from login page
            AccountService AS = new AccountService();
                       
            
            user = AS.login(user);    // return user obj with password destroyed, or obj as null is login was wrong 
            
            if(user != null){  //check if login was sucessful
                session.setAttribute("user", user); 
                response.sendRedirect(request.getContextPath() + "/home");  
                
            }else{ //login failed  
                request.setAttribute("welcomeMsg", "Hmm... Looks like your name isn't Barb or Abe.");
                request.setAttribute("errMsg", "Password or Username was incorrect, try again.");
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
                
            }            
        }        
    }
}
