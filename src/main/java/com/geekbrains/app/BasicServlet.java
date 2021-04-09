package com.geekbrains.app;

import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet" )
public class BasicServlet extends HttpServlet {
    private static Logger logger = (Logger) LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        logger.info("Поступил GET запрос");
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "соль", 55));
        products.add(new Product(2,"перец", 77));
        products.add(new Product(3,"щоколадка", 98));
        products.add(new Product(4,"арбуз", 33));
        products.add(new Product(5,"рис", 91));
        products.add(new Product(6,"конфеты", 21));

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Products List</h1>");
        out.println("<br>");
        out.println("<div>");
        out.println("<div>ID Name Price</div>");
        products.stream()
                .map(Product -> (String.format("<div>%d %s %.2f%n</div>")))
                .forEach(out::println);
        out.println("</div>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println("<h1>Servlet content</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

}
//, Product.getID(), Product.getTitle(), Product.getCost()