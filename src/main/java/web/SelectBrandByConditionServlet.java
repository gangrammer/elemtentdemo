package web;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectBrandByConditionServlet")
public class SelectBrandByConditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        int status = brand.getStatus();
        String companyName = brand.getCompanyName();
        String brandName = brand.getBrandName();

        System.out.println(status);
        System.out.println(companyName);
        System.out.println(brandName);
        BrandService brandService = new BrandService();
        List<Brand> brands = brandService.selectBrandByCondition(status, companyName, brandName);
        String brands2 = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(brands2);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
