package clone.copycat.Moviehungry.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Arrays;


@Component
@Aspect
public class LoggingAspects {
    private static Logger LOG = LoggerFactory.getLogger(LoggingAspects.class);

    /**
     * This aspect will work on all the Movie packages
     * This aspect is used to log the method calls and their arguments, as well as the execution time of the method.
     * The aspect uses the Around advice type, which allows it to intercept method calls and execute code before and after the method call.
     * The aspect uses the ProceedingJoinPoint parameter to access information about the method call, such as the method name and arguments.
     * The aspect logs the method call and arguments using the SLF4J logging framework.
     * The aspect also logs the execution time of the method using the System.currentTimeMillis() method.
     * If the method call throws an exception, the aspect logs the exception using the SLF4J logging framework.
     * The aspect returns the result of the method call.
     */
    @Around("execution(* clone.copycat.Moviehungry.Movie.*.*(..))")
    public Object AroundLogger(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();
        LOG.info(methodName + " called with args: " + Arrays.toString(args));
        long start = System.currentTimeMillis();
        try {
            Object result = point.proceed();
            long end = System.currentTimeMillis();
            LOG.info("Execution time of the the method---->" + (end - start)+ "ms");
            LOG.info(methodName + " returned: " + result.toString());
            return result;
        } catch (Throwable th) {
            LOG.error(methodName + "thorws the error" + th);
        }
        return null;
    }
}
