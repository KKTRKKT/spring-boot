package me.kktrkkt.springboot.mvc.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;
/*
* https://spring.io/guides/gs/rest-hateoas/
* */
public class HateoasResponse extends RepresentationModel<HateoasResponse> {

    private String prefix;

    private String text;

    @JsonCreator
    public HateoasResponse(@JsonProperty("prefix") String prefix, @JsonProperty("prefix") String text) {
        this.prefix = prefix;
        this.text = text;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return prefix + " " + text;
    }
}
