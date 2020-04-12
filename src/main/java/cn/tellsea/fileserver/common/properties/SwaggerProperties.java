package cn.tellsea.fileserver.common.properties;

import lombok.Data;

/**
 * swagger 属性
 *
 * @author Tellsea
 * @date 2020/3/5
 */
@Data
public class SwaggerProperties {

    /**
     * 标题
     */
    private String title;
    /**
     * 是否启用swagger
     */
    private boolean enabled;
    /**
     * 版本
     */
    private String version;
    /**
     * 作者
     */
    private String author;
    /**
     * 分享路径
     */
    private String url;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 描述
     */
    private String description;
    /**
     * 服务条款路径
     */
    private String termsOfServiceUrl;
    /**
     * 扫描控制层路径，多个用 , 隔开
     */
    private String controllerUrl;
}
