package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        session.setAttribute("user", session.getAttribute("user"));
        User user = (User)session.getAttribute("user");
        
            String operation = request.getParameter("operation");  
            System.out.println(request.getParameter("operation"));
            if(operation != null && operation.equals("logout")){

                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
            }       
            
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response); 
        
        
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
