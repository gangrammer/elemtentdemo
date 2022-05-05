package web;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import pojo.pageBean;
import service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByPageServlet")
public class selectByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        System.out.println(_currentPage);
        System.out.println(_pageSize);
        int begin = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        BrandService brandService = new BrandService();
        pageBean<Brand> brandpageBean = brandService.selectPageBean(begin, pageSize);
        String s = JSON.toJSONString(brandpageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
