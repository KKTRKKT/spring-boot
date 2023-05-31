package me.kktrkkt.springboot.test.slice_test;

import me.kktrkkt.springboot.test.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// jackson의 데이터 바인딩이 기대하는대로 작동하는지 확인하는 테스트
@JsonTest
class SampleJsonTest {

    @Autowired
    private JacksonTester<Sample> json;

    @Test
    void serialize() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        Sample value = new Sample("sample", now);
        assertThat(this.json.write(value)).hasJsonPathStringValue("@.name");
        assertThat(this.json.write(value)).extractingJsonPathStringValue("@.name").isEqualTo("sample");
        assertThat(this.json.write(value)).extractingJsonPathStringValue("@.dateTime")
                .isEqualTo(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    void deserialize() throws Exception {
        String content = "{\"name\":\"sample\",\"dateTime\":\"2023-05-30 17:37:00\"}";
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MAY, 30, 17, 37, 0);
        assertEquals(this.json.parse(content).getObject().getName(), "sample");
        assertEquals(this.json.parse(content).getObject().getDateTime().toString(), dateTime.toString());
    }
}