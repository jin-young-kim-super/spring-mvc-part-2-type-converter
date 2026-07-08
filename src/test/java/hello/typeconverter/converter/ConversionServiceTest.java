package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * 여기서 컨터터의 강점이 가슴에 와닿는다.
 * -> 컨버터 서비스에 등록만 해놓으면 직접 컨버터 꺼낼 일도 없고, 자동으로 형변환이 된다.
 * 만약 이걸 사용하고 싶은 개발자는 conversionService 인터페이스를 어딘가에 정의하고 의존관계 주입을 받고 사용하기만 하면 된다.
 */

public class ConversionServiceTest {

    @Test
    void connversionService() {

        // 컨버터 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());


        // 컨버터 사용(등록된 컨버터 중에서 사용가능한 컨버터를 찾아서 자동 적용)
        Assertions.assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        Assertions.assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        Assertions.assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(new IpPort("127.0.0.1",8080));
        Assertions.assertThat(conversionService.convert(new IpPort("127.0.0.1",8080), String.class)).isEqualTo("127.0.0.1:8080");
    }






}
