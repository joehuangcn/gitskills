import business.service.JavaConfig;
import business.service.UseFunctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestJavaConfig {
    private static Logger logger= LoggerFactory.getLogger(TestJavaConfig.class);
    public static void main(String [] args){
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
//        UseFunctionService us=context.getBean(UseFunctionService.class);
//        System.out.println(us.Sayhi("good job java config"));
//        context.close();
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
