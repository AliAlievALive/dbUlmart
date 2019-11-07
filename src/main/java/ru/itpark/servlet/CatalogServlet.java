package ru.itpark.servlet;

import ru.itpark.service.ShopService;
import ru.itpark.service.FileService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CatalogServlet extends HttpServlet {
    private ShopService shopService;
    private FileService fileService;

    @Override
    public void init() throws ServletException {
        InitialContext context = null;
        try {
            context = new InitialContext();
            shopService = (ShopService) context.lookup("java:/comp/env/bean/shop-service");
            fileService = (FileService) context.lookup("java:/comp/env/bean/file-service");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("items", shopService.getAll());
            req.getRequestDispatcher("/WEB-INF/catalog.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            var login = req.getParameter("login");
            var name = req.getParameter("name");
            var part = req.getPart("image");

            var image = fileService.writeFile(part);

            shopService.create(login, name, image);
            resp.sendRedirect(String.join("/", req.getContextPath(), req.getServletPath()));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
