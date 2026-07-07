package hello.typeconverter.controller;


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

    // 스프링 사용 버전(@RequestParam)
    // -> 스프링이【문자열】인 쿼리 파마리터(쿼리 스트링)을 자동으로 int형으로 변환을 해줬다
    // -> @ModelAttribute, @PathVariable에서도 똑같이 형변환을 스프링이 해준다.(@PathVariable도 다 문자열임에 주의하자)
    // 클라이언트가 서버에 데이터를 넘기는 방법이 3가지 였다는 것을 떠올리자(1. 쿼리 스트링(@RequestParam), 2. HTML FORM(@ModelAttribute), 3. API )
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }
}
