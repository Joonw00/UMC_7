package umc.spring.custom;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ValidPageArgumentResolver validPageArgumentResolver;

    public WebConfig(ValidPageArgumentResolver validPageArgumentResolver) {
        this.validPageArgumentResolver = validPageArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(validPageArgumentResolver);
    }
}