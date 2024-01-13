package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {
    int count;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        System.out.println(++count);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       System.out.println("doPost and doGet functions");
//        String parameter = req.getParameter("key");
//        String mes = req.getParameter("mes");
//        System.out.println(parameter);
//        System.out.println(mes);
        ServletConfig servletConfig = this.getServletConfig();
        String servletName = servletConfig.getServletName();
        String username = servletConfig.getInitParameter("username");
        Enumeration initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            System.out.println(initParameterNames.nextElement());
        }
//        System.out.println(servletName);
//        System.out.println(username);
        ServletContext servletContext = servletConfig.getServletContext();
        String servletContextName = servletContext.getServletContextName();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req,resp);
    }
}
