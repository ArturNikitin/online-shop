package controller;

import controller.dto.CartForm;
import model.Cart;
import model.Product;
import service.CartService;
import service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = (String) req.getSession().getAttribute(LoginServlet.VERIFIED_USER);
        if (userName == null) {
            resp.sendRedirect(req.getContextPath());
        }
        Map<Product, Integer> cart = cartService.getCartByUser(userName);
        CartForm cartForm = new CartForm();
        cartForm.setProducts(cart);
        req.setAttribute("cart", cartForm);
        req.getRequestDispatcher("pages/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
