package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String name = "";
        String description = "";
        double price = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amit", "user", "tatasky123");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id = ?");
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                name = rs.getString("name");
                description = rs.getString("description");
                price = rs.getDouble("price");
            } else {
                request.setAttribute("errorMessage", "Product not found!");
            }

            request.setAttribute("name", name);
            request.setAttribute("description", description);
            request.setAttribute("price", price);

            request.getRequestDispatcher("productDetails.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
