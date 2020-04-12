package cn.tellsea.fileserver.common.entity;

import cn.tellsea.fileserver.common.enums.BaseEnums;
import cn.tellsea.fileserver.common.enums.FileEnums;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 公共返回结果集
 *
 * @author Tellsea
 * @date 2020/3/3
 */
@Slf4j
@Data
@Accessors(chain = true)
public class ResponseResult implements Serializable {

    private int code;

    private String message;

    private int count;

    private Object data;

    public static ResponseResult success() {
        return new ResponseResult().setCode(FileEnums.OK.getCode())
                .setMessage(FileEnums.OK.getInfo());
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult().setCode(FileEnums.OK.getCode())
                .setMessage(FileEnums.OK.getInfo())
                .setData(data);
    }

    public static ResponseResult successMsg(String message) {
        return new ResponseResult().setCode(FileEnums.OK.getCode())
                .setMessage(message);
    }

    public static ResponseResult success(BaseEnums baseEnums) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo());
    }

    public static ResponseResult success(BaseEnums baseEnums, Object data) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo())
                .setData(data);
    }

    // 失败

    public static ResponseResult error() {
        return new ResponseResult().setCode(FileEnums.SERVER_ERROR.getCode())
                .setMessage(FileEnums.SERVER_ERROR.getInfo());
    }

    public static ResponseResult error(Object data) {
        return new ResponseResult().setCode(FileEnums.SERVER_ERROR.getCode())
                .setMessage(FileEnums.SERVER_ERROR.getInfo())
                .setData(data);
    }

    public static ResponseResult errorMsg(String message) {
        return new ResponseResult().setCode(FileEnums.SERVER_ERROR.getCode())
                .setMessage(message);
    }

    public static ResponseResult error(BaseEnums baseEnums) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo());
    }

    public static ResponseResult error(BaseEnums baseEnums, Object data) {
        return new ResponseResult().setCode(baseEnums.getCode())
                .setMessage(baseEnums.getInfo())
                .setData(data);
    }

    public static ResponseResult build(int code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }
}
