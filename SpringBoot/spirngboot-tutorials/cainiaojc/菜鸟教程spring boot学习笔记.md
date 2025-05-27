## hello world项目创建并运行

## 常用注解有哪些

@Required

@Autowired

@Bean

@Component

@Controller

@Service

@Repository

@SpringBootApplication 

@ EnableAutoConfiguration

@ ComponentScan

@Configuration

@RequestMapping

@GetMapping

@PostMapping

@PutMapping

@DeleteMapping

@PatchMapping

@RequestBody

@ResponseBody

@PathVariable

@RequestParam

@RequestHeader

@RestControlle

@RequestAttribute

## 依赖管理方式

maven parent标签继承spring-boot-starter-parent

maven dependencyManagement 标签管理，不使用parent标签

## 配置属性有哪些

[通用应用程序属性 :: Spring Boot - Spring 框架](https://docs.springframework.org.cn/spring-boot/appendix/application-properties/index.html#appendix.application-properties.data)

## starters

### 官方和三方starter的区别

### 怎么自定义starter

## 热部署DevTools

### IDEA开发工具怎么开启热部署

## 多模块项目管理

### maven项目继承与项目聚合的区别是什么

## 打包springboot应用程序

怎么打成jar包、war包？

## 自动装配

自动装配原理是什么？

怎么禁用自动装配？

## 应用部署

怎么把springboot应用以war包形式部署到tomcat？

## AOP

Aspect

Pointcut

Join point

Advice

- Before Advice，@Before
- After Advice，@After
- Around Advice，@Around
- After Throwing Advice，@AfterThrowing
- After Returning Advice，@AfterReturning

Target object

Weaving

### SpringAOP和AspectJ的使用与区别

## Spring Boot JPA 

## Spring Boot Thymeleaf

## Spring Boot 缓存

缓存中间件：EhCache、Redis、Caffeine

### 注解

@EnableCaching

@CacheConfig

@Caching

 @CachePut 

@CacheEvict

@Cacheable

## Spring Boot 更改端口

- 使用 application.properties 文件
- 使用 application.yml 文件
- 使用 EmbeddedServletContainerCustomizer 接口
- 使用 WebServerFactoryCustomizer 界面
- 使用命令行参数

## Spring Boot REST API 

## Spring Boot Web 开发

web容器

- tomcat
- jetty
- undertow

## Spring Boot Actuator

## Spring Boot Test

## Spring Boot JDBC template

连接池有哪些？怎么使用？

## Spring Boot CRUD 示例（JPA)

## Spring Boot H2 

## Spring Boot Derby 