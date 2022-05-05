package web;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BrandService brandService = new BrandService();
        //用于读取JSON的序列化数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //JSON对象化数据
        Brand brand = JSON.parseObject(s, Brand.class);
        brandService.add(brand);
        response.getWriter().write("gan");
        System.out.println("***************");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
