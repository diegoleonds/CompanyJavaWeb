package com.example.companias.view.servlet;

import com.example.companias.controller.CompanyController;
import com.example.companias.data.dao.CompanyDao;
import com.example.companias.data.model.Company;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        CompanyController controller = new CompanyController();
        List<Company> companies = controller.getEntities(0, 0);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + companies.size() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}