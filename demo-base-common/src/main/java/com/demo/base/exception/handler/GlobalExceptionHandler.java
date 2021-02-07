package com.demo.base.exception.handler;

import com.demo.base.exception.base.BaseException;
import com.demo.base.exception.bean.BusinessException;
import com.demo.base.exception.bean.DAOException;
import com.demo.base.response.bean.CommonResponse;
import com.demo.base.response.enums.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @InitBinder
//    public void initBinder(WebDataBinder binder) { }

    @ExceptionHandler({ Exception.class })
    public CommonResponse exceptionHandler(Exception e) {
        return getCommonResponse(ResponseEnum.SYSTEM_EXCEPTION.getCode(), e);
    }

    @ExceptionHandler({ BaseException.class })
    public CommonResponse baseExceptionHandler(BaseException e) {
        return getCommonResponse(ResponseEnum.SYSTEM_EXCEPTION.getCode(), e);
    }

    @ExceptionHandler({ BusinessException.class })
    public CommonResponse businessExceptionHandler(BusinessException e) {
        return getCommonResponse(e.getCode(), e);
    }

    @ExceptionHandler({ DAOException.class })
    public CommonResponse daoExceptionHandler(DAOException e) {
        return getCommonResponse(e.getCode(), e);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MissingServletRequestParameterException.class})
//    public CommonResult handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
//        return returnErr(ReturnCode.ERROR_400.getCode(), (Exception)e, ");
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({HttpMessageNotReadableException.class})
//    public CommonResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
//        return returnErr(ReturnCode.ERROR_400.getCode(), (Exception)e, ");
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public CommonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        StringBuilder errorMessage = new StringBuilder(");
//        if (null != bindingResult && !CollectionUtils.isEmpty(bindingResult.getFieldErrors())) {
//            String message = bindingResult.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
//            errorMessage.append(message);
//        }
//        return returnErr(ReturnCode.ERROR_400.getCode(), (Exception)e, ");
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({BindException.class})
//    public CommonResult handleBindException(BindException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        StringBuilder errorMessage = new StringBuilder(");
//        if (null != bindingResult && !CollectionUtils.isEmpty(bindingResult.getFieldErrors())) {
//            String message = bindingResult.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
//            errorMessage.append(message);
//        }
//        return returnErr(ReturnCode.ERROR_400.getCode(), (Exception)e, ");
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({ConstraintViolationException.class})
//    public CommonResult handleServiceException(ConstraintViolationException e) {
//        return returnErr(ReturnCode.ERROR_400.getCode(), (Exception)e, ");
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({ValidationException.class})
//    public CommonResult handleValidationException(ValidationException e) {
//        return returnErr(ReturnCode.ERROR_400.getCode(), (Exception)e, ");
//    }
//
//    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
//    public CommonResult handleHttpMediaTypeNotSupportedException(Exception e) {
//        return returnErr(ReturnCode.ERROR_400.getCode(), e, ");
//    }
//
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
//    public CommonResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        return returnErr(ReturnCode.ERROR_405.getCode(), (Exception)e, ");
//    }
//
//    @ExceptionHandler({WebException.class})
//    public CommonResult webErrorHandler(WebException e) throws Exception {
//        return returnErr(ReturnCode.ERROR_500.getCode(), (Exception)e);
//    }
//
//    @ExceptionHandler({DAOException.class})
//    public CommonResult daoErrorHandler(DAOException e) throws Exception {
//        return returnErr(ReturnCode.ERROR_500.getCode(), (Exception)e);
//    }
//
//    @ExceptionHandler({ServiceException.class})
//    public CommonResult serviceErrorHandler(ServiceException e) throws Exception {
//        return returnErr(ReturnCode.UN_SUCCESS.getCode(), (Exception)e);
//    }
//
//    @ExceptionHandler({IllegalParameterException.class})
//    public CommonResult illegalParameterErrorHandler(IllegalParameterException e) throws Exception {
//        return returnErr(ReturnCode.ERROR_500.getCode(), (Exception)e);
//    }
//
//    @ExceptionHandler({MaxSizeException.class})
//    public CommonResult illegalParameterErrorHandler(MaxSizeException e) throws Exception {
//        return returnErr(ReturnCode.ERROR_500.getCode(), (Exception)e);
//    }
//
//    @ExceptionHandler({UnauthorizedException.class})
//    public CollectionResult unauthorizedExceptionHandler(UnauthorizedException ex) {
//        ex.printStackTrace();
//        log.error("shiro, (Throwable)ex);
//        return CollectionResult.failed(ReturnCode.ERROR_4003.getCode(), ReturnCode.ERROR_4003.getMsg());
//    }
//
//    @ExceptionHandler({DataIntegrityViolationException.class})
//    public CollectionResult DataIntegrityViolationException(DataIntegrityViolationException ex) {
//        ex.printStackTrace();
//        log.error("sql, (Throwable)ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), ex.toString());
//    }
//
//    @ExceptionHandler({BadSqlGrammarException.class})
//    public CollectionResult DataIntegrityViolationException(BadSqlGrammarException ex) {
//        ex.printStackTrace();
//        log.error("sql, (Throwable)ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), "sql);
//    }
//
//    @ExceptionHandler({NullPointerException.class})
//    public CollectionResult nullPointerExceptionHandler(NullPointerException ex) {
//        ex.printStackTrace();
//        log.error(", ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), ex.toString());
//    }
//
//    @ExceptionHandler({ClassCastException.class})
//    public CollectionResult classCastExceptionHandler(ClassCastException ex) {
//        ex.printStackTrace();
//        log.error(", ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), ex.toString());
//    }
//
//    @ExceptionHandler({IOException.class})
//    public CollectionResult iOExceptionHandler(IOException ex) {
//        ex.printStackTrace();
//        log.error("IO, ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), ex.toString());
//    }
//
//    @ExceptionHandler({NoSuchMethodException.class})
//    public CollectionResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {
//        ex.printStackTrace();
//        log.error(", ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), ex.toString());
//    }
//
//    @ExceptionHandler({IndexOutOfBoundsException.class})
//    public CollectionResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
//        ex.printStackTrace();
//        log.error(", ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), ex.toString());
//    }
//
//    @ExceptionHandler({TypeMismatchException.class})
//    public CollectionResult requestTypeMismatch(TypeMismatchException ex) {
//        ex.printStackTrace();
//        log.error("TypeMismatchException,, (Throwable)ex);
//        return CollectionResult.failed(ReturnCode.ERROR_400.getCode(), ");
//    }
//
//    @ExceptionHandler({ConversionNotSupportedException.class, RuntimeException.class, HttpMessageNotWritableException.class})
//    public CollectionResult server500(Exception ex) {
//        ex.printStackTrace();
//        log.error(", ex);
//        return CollectionResult.failed(ReturnCode.ERROR_500.getCode(), ex.toString());
//    }

    private CommonResponse getCommonResponse(int code, Exception e) {
        log.error(e.getMessage(), e);
        CommonResponse resp = new CommonResponse();
        resp.setCode(code);
        resp.setMessage(e.getMessage());
        resp.setSystemTime(String.valueOf(System.currentTimeMillis()));
        return resp;
    }

//    private CommonResult returnErr(Exception e, String errMsg, int code) {
//        log.error(e.getMessage(), e);
//        CommonResult result = new CommonResult();
//        result.setCode(Integer.valueOf(code));
//        result.setMsg(e.getMessage());
//        result.setSysTime(String.valueOf(System.currentTimeMillis()));
//        return result;
//    }
//
//    private CommonResult returnErr(BaseException e, String errMsg) {
//        log.error(e.getMessage(), (Throwable)e);
//        CommonResult result = new CommonResult();
//        result.setCode(Integer.valueOf(e.getCode()));
//        result.setMsg(e.getMessage());
//        result.setSysTime(String.valueOf(System.currentTimeMillis()));
//        return result;
//    }
//
//    private CommonResult returnErr(String errMsg, int code, Exception e) {
//        log.error(e.getMessage(), e);
//        CommonResult result = new CommonResult();
//        result.setCode(Integer.valueOf(code));
//        result.setMsg(errMsg);
//        result.setSysTime(String.valueOf(System.currentTimeMillis()));
//        return result;
//    }
//
//    private CommonResult returnErr(int code, Exception e, String errMsg) {
//        log.error(e.getMessage(), e);
//        CommonResult result = new CommonResult();
//        result.setCode(Integer.valueOf(code));
//        result.setMsg(errMsg);
//        result.setSysTime(String.valueOf(System.currentTimeMillis()));
//        return result;
//    }
}