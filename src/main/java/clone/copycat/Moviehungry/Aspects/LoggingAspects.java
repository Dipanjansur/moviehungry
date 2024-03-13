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
