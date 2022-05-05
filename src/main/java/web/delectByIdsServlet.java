package web;

import com.alibaba.fastjson.JSON;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/delectByIdsServlet")
public class delectByIdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        int[] ints = JSON.parseObject(s, int[].class);
        BrandService brandService = new BrandService();
        brandService.delectByIds(ints);
        response.getWriter().write("gan");
        System.out.println("成功");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
