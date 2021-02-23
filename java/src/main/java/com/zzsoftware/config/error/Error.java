package com.zzsoftware.config.error;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.zzsoftware.utils.result.CodeMsg;
import com.zzsoftware.utils.result.Result;

/*
 * 功能:统一异常处理
 * 注意:这类异常一般由于程序设计不稳定造成，不建议把具体信息返回到客户端，可存放数据库做排错处理
 * */
//@RestControllerAdvice
public class Error {
	@ExceptionHandler(value = { Exception.class })
	public Object handleOtherExceptions(final Exception ex) {
		return Result.error(CodeMsg.SERVER_EXCEPTION);
	}
}