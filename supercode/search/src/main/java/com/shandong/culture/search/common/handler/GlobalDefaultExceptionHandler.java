package com.shandong.culture.search.common.handler;


import com.shandong.culture.search.common.constant.CodeEnum;
import com.shandong.culture.search.model.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
* @Description:    全局异常处理类,拦截所有RequestMapping注解方法抛出的异常
 * 如果使用的是rest方式,此类需要注释
* @Author:         moon
* @CreateDate:     2019/5/5 0005 14:41
* @UpdateUser:     moon
* @UpdateDate:     2019/5/5 0005 14:41
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseVO handleException(final HttpServletRequest request, final Exception e) {
        logger.error("========拦截Exception=======", e);
        String message = StringUtils.isBlank(e.getMessage()) ?  CodeEnum.FAILURE.getMessage() : e.getMessage();
        return ResponseVO.failure(CodeEnum.FAILURE.getCode(), message);
    }

}
