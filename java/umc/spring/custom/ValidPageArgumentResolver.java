package umc.spring.custom;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

@Component
public class ValidPageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ValidPage.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String pageParam = Optional.ofNullable(webRequest.getParameter("page")).orElse("1");

        int page;
        try {
            page = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Page must be a valid integer.");
        }

        if (page < 1) {
            throw new IllegalArgumentException("Page must be greater than or equal to 1.");
        }
        return page - 1;
    }
}
