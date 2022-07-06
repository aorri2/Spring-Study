package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    void stringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void stringToIpPort(){
        IpPortToStringConverter con = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1",8080);
        String result = con.convert(ipPort);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString(){
        StringToIpPortConverter conver = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = conver.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));
    }
}
