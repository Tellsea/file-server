package cn.tellsea.fileserver.common.handler;

import cn.tellsea.fileserver.common.entity.ResponseResult;
import cn.tellsea.fileserver.common.enums.FileEnums;
import cn.tellsea.fileserver.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Tellsea
 * @date 2020/3/5
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleException(Exception e) {
        log.error("Exception：{}", "服务器错误");
        e.printStackTrace();
        return ResponseResult.error(FileEnums.SERVER_ERROR);
    }

    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleBaseException(BaseException e) {
        log.error("BaseException：{}", e.getMessage());
        return ResponseResult.errorMsg(e.getMessage());
    }
}
