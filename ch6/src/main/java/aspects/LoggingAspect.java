package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import services.Comment;
import interfaces.ToLog;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class LoggingAspect {
    private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around(value = "@annotation(ToLog)")
    public String log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // ALtering parameters
        Comment comment = new Comment();
        comment.setText("Some text");

        Object[] newArgs = {comment};

        Object result = joinPoint.proceed(newArgs);

        logger.info("Method executed and returned" + result);

        return "FAILED";
    }
}