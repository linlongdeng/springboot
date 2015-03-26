package boot;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CustomerPageableHandlerMethodArgumentResolver extends
		PageableHandlerMethodArgumentResolver {

	@Override
	public Pageable resolveArgument(MethodParameter methodParameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) {
		System.out.println("开始结束Page参数");
		return super.resolveArgument(methodParameter, mavContainer, webRequest,
				binderFactory);
	}

}
