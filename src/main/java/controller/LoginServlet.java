package controller;


import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final String VERIFIED_USER = "verifiedUser";
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(VERIFIED_USER) == null) {
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        }
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (userService.validateUser(name, password)) {
            req.getSession().setAttribute(VERIFIED_USER, name);
        }
        req.getRequestDispatcher("pages/products.jsp");
    }
}
