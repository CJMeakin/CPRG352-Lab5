package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import model.User;

/**
 *
 * @author Connor
 */
public class homeServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if((session.getAttribute("user") != null)){ //check if user has logged in already
            
            String operation = request.getParameter("logOperation");  
            
            if(operation != null && (operation.equals("logout"))){ //logout is requested
                
                session.invalidate(); //delete session
                response.sendRedirect(request.getContextPath() + "/login"); //redirect to login screen
                
            } else{ 
                 getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response); 
            }  
        }else{ //if user hasnt logged in redirect to login
             response.sendRedirect(request.getContextPath() + "/login"); 
        }
          
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
