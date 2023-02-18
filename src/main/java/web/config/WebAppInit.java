package web.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class[]{WebConfig.class};
    }
    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class[]{WebConfig.class};
    }
    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[]{"/"};
    }
    /*Метод-фильтр символов*/
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }
}
