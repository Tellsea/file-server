package cn.tellsea.fileserver.common.exception;

/**
 * 系统异常
 *
 * @author: Tellsea
 * @date : 2020/3/4
 */
public class BaseException extends RuntimeException {

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }
}
