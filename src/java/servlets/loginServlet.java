
package servlets;

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
        
        request.setAttribute("welcomeMsg", "Hope your name is Barb or Abe.");
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(request.getParameter("operation") != null && request.getParameter("operation").equals("login")){
            
            User user = new User(request.getParameter("username"),request.getParameter("password"));
            AccountService AS = new AccountService();
            session.setAttribute("user", user);
            
            
            user = AS.login(user);
           
            if(user != null){ 
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home");               
            }else{
                
                request.setAttribute("welcomeMsg", "Hmm... Looks like your name isn't Barb or Abe.");
                request.setAttribute("errMsg", "Password or Username was incorrect, try again.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
            }
            
            
            
        }
        
        
        
        
        
    }
}
