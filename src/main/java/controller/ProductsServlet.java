package controller;

import controller.dto.ProductForm;
import model.EatableProduct;
import model.UneatableProduct;
import repository.CartRepository;
import repository.UserRepository;
import repository.impl.EatableProductRepositoryJdbcImpl;
import repository.impl.UneatableProductRepositoryJdbcImpl;
import service.CartService;
import service.ProductService;
import service.UserService;
import service.impl.CartServiceImpl;
import service.impl.EatableProductServiceImpl;
import service.impl.UneatableProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService eatableProductService = new EatableProductServiceImpl();
        ProductService uneatableProductService = new UneatableProductServiceImpl();

        ProductForm productForm = new ProductForm();
        productForm.setEatableProducts((Set<EatableProduct>) eatableProductService.getAllProducts());
        productForm.setUneatableProducts((Set<UneatableProduct>) uneatableProductService.getAllProducts());
        req.setAttribute("form", productForm);

        req.getRequestDispatcher("pages/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String name = (String) req.getSession().getAttribute(LoginServlet.VERIFIED_USER);
        cartService.addProduct(name, productId, amount);
        resp.sendRedirect("products");
    }
}
