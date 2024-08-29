import com.xxx.entity.Brand;
import com.xxx.mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandMapperTest {

    @Test
    public void testSelectAll() throws IOException {

        // 1.
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2.
        SqlSession sqlSession = sessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brandList = brandMapper.selectAll();

        System.out.println(brandList);

        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {

        int id = 1;
        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);

        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装查询对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        // 封装查询参数
        Map map = new HashMap<>();
        // map.put("status",status);
        map.put("brandName", brandName);
        //map.put("companyName",companyName);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行SQL方法
        // List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装查询对象
        Brand brand = new Brand();
        //brand.setStatus(status);
        // brand.setBrandName(brandName);
        // brand.setCompanyName(companyName);

        // 封装查询参数
        Map map = new HashMap<>();
        // map.put("status",status);
        //map.put("brandName", brandName);
        //map.put("companyName",companyName);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行SQL方法
        // List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        // List<Brand> brands = brandMapper.selectByCondition(map);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {

        int status = 1;
        String companyName = "VIVO技术有限公司";
        String brandName = "VIVO";
        int ordered = 30;
        String description = "vivo是一家以设计驱动创造伟大产品，以智能终端和智慧服务为核心的科技公司。";


        // 封装查询对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
        // SqlSession sqlSession = sessionFactory.openSession();
        SqlSession sqlSession = sessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行SQL方法
        brandMapper.add(brand);

        // 5、提交事务
        // sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {

        int status = 1;
        String companyName = "VIVO技术有限公司";
        String brandName = "VIVO";
        int ordered = 30;
        String description = "vivo是一家以设计驱动创造伟大产品，以智能终端和智慧服务为核心的科技公司。";


        // 封装查询对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
         SqlSession sqlSession = sessionFactory.openSession();
        // SqlSession sqlSession = sessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行SQL方法
        brandMapper.add(brand);


        System.out.println(brand.getId());

        // 5、提交事务
        // sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {

        int id = 10;
        String brandName = "realme";
        String companyName = "realme技术有限公司";
        String description = "“敢越级” (Make it Real.) 的品牌态度是驱使我们为全球年轻人构建万物互联智能潮玩生活的原动力。在短短三年时间里，真我realme 成为史上最快达到1 亿台销量的智能手机品牌，并首次跃居全球第六，极速占据主流智能手机品牌之列。";
        int ordered = 50;
        int status = 1;


        // 封装查询对象
        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // SqlSession sqlSession = sessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行SQL方法
        int update = brandMapper.update(brand);

        System.out.println(update);

        // 5、提交事务
        sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {

        int id = 10;
//        String brandName = "realme";
//        String companyName = "realme技术有限公司";
//        String description = "“敢越级” (Make it Real.) 的品牌态度是驱使我们为全球年轻人构建万物互联智能潮玩生活的原动力。在短短三年时间里，真我realme 成为史上最快达到1 亿台销量的智能手机品牌，并首次跃居全球第六，极速占据主流智能手机品牌之列。";
//        int ordered = 50;
//        int status = 1;


        // 封装查询对象
//        Brand brand = new Brand();
//        brand.setId(id);
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // SqlSession sqlSession = sessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行SQL方法
        brandMapper.deleteById(id);

        // 5、提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {

        int [] ids = new int[]{1,2,3};

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 2. 获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // SqlSession sqlSession = sessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行SQL方法
        brandMapper.deleteByIds(ids);

        // 5、提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
