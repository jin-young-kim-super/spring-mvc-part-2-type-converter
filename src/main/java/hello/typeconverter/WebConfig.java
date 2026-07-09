package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 스프링은 포맷터보다 컨버터를 더 우선 적용한다
        // -> MyNumberFormatter 또한 본질적으로는 String->Integer, Integer->String
        // 이기에 여기를 주석처리 하지 않으면 우선순위에 의해 MyNumberFormatter가 적용 안됨
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new IpPortToStringConverter());

        // 이것 또한 역시 ConversionService에 등록이 된다.
        registry.addFormatter(new MyNumberFormatter());

    }
}
