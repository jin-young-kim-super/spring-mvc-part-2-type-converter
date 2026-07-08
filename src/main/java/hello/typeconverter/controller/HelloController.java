package hello.typeconverter.controller;


import hello.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 스프링 미사용 버전
    // -> 【문자열】인 쿼리 스트링을 int형으로 개발자가 명시적으로 형변환을 해줘야 한다.
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    // 사실 컨버터를 등록하기 전에도 이 부분은 잘 실행이 되었다. 왜냐하면 스프링은 이미 우리가 상상 가능한 모든 컨버터를
    // 이미 등록시켜놨기 때문이다. 그러나 로그를 보면 알겠지만 우리가 만든 StringToInteger 컨버터가 작동한다.
    // 그 이유는 스프링은 개발자가 직접 수동 등록한 컨버터를 우선순위에 두기 때문이다.
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort data) {
        System.out.println("ip = " + data.getIp());
        System.out.println("port = " + data.getPort());
        return "ok";
    }

}
