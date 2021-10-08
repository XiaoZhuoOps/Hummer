# Hummer 开发日志

## 注解配置
@Dependence -> BeanDefinition -> bean
配置扫描包位置，扫描所有的带有@Dependence注解的类，结合@Value和@Inject，创建BeanDefinition并注册

@Inject --> getBean --> 
@Value