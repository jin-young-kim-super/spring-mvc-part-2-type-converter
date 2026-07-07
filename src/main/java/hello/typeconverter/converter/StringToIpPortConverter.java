package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

// 이런 걸 만들어 두면, 클라이언트의 IpPort정보를 손쉽게 변환 가능
// -> 물론 이 컨버터를 스프링에 등록을 해야지 자동 형변환된다.
// 사실 지금은 이 컨버터의 강점이 와닿지가 않을 것이다.
// 이후에 이 기능이 어떤 막강한 역할을 하는지 알 게 될 것이니, 지금은 참아라
@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {
    @Override
    public IpPort convert(String source) {
      log.info("convert source={}",source);

        // ex: "127.0.0.1:8080"
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip,port);
    }
}
