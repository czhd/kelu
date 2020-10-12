package pro.kelu.missyou.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.kelu.missyou.core.configuration.ExceptionConfigConfiguration;
import pro.kelu.missyou.exception.http.HttpException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice {
    @Autowired
    private ExceptionConfigConfiguration exceptionConfigConfiguration;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        System.out.println(e);
        return new UnifyResponse(9999, "服务器异常", this.request(req));
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> httpException(HttpServletRequest req, HttpException e) {
        UnifyResponse res = new UnifyResponse(e.getCode(), exceptionConfigConfiguration.getMessage(e.getCode()), this.request(req));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        return new ResponseEntity<>(res, httpHeaders, httpStatus);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidation(HttpServletRequest req, MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = this.formatAllErrorMessage(errors);
        return new UnifyResponse(10001, message, this.request(req));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintException(HttpServletRequest req, ConstraintViolationException e) {
        //自定制化返回
//        for (ConstraintViolation error: e.getConstraintViolations()) {
//
//        }
        return new UnifyResponse(10001, e.getMessage(), this.request(req));
    }


    private String formatAllErrorMessage(List<ObjectError> errors) {
        StringBuffer errorMessage = new StringBuffer();
        errors.forEach(error ->
                errorMessage.append(error.getDefaultMessage()).append(";")
        );
        return errorMessage.toString();
    }


    private String request(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        return method + " " + requestURI;
    }
}
