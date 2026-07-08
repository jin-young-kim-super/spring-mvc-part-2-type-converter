package hello.typeconverter.formatter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


// Number : Integer와 Long의 부모 클래스
// Formatter<Number> : 문자열 -> 숫자 객체, 숫자 객체 -> 문자열
@Slf4j
public class MyNumberFormatter implements Formatter<Number> {

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={} local={}",text, locale);

        // "1,000" -> 1000(문자열 -> 정수 객체)
        NumberFormat format = NumberFormat.getInstance(locale); // 날짜 숫자는 그 나라를 고려해서 만들어야 한다.
        Number parse = format.parse(text);
        return parse;
    }

    // 정수 객체 -> 문자열
    @Override
    public String print(Number object, Locale locale) {
        log.info("object={} local={}",object, locale);

        NumberFormat instance = NumberFormat.getInstance(locale);
        String format = instance.format(object);
        return format;
    }
}
