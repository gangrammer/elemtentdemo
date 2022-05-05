package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.Brand;

import java.util.List;

public interface BrandMapper {

     List<Brand>selectAll();

     void add(Brand brand);

     void delectByIds(@Param("ids") int [] ids);



     List<Brand>selectByPage(@Param("being") int being,@Param("pagecount") int pagecount);

     int count();

     List<Brand> selectBrandByCondition(@Param("status") int status ,@Param("companyName") String companyName, @Param("brandName") String brandName);
}
