package me.kktrkkt.springboot.rest_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-------------------RestTemplate--------------------");
        restTemplate();
        System.out.println("-------------------WebClient--------------------");
        webClient();

    }

    private void webClient() {
        WebClient webClient = webClientBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        webClient.get().uri("/hello")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(s -> {
                    System.out.println(s);
                    if(stopWatch.isRunning()){
                        stopWatch.stop();
                    }
                    System.out.println(stopWatch.prettyPrint());
                    stopWatch.start();
                });

        webClient.get().uri("/world")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(s -> {
                    System.out.println(s);
                    if(stopWatch.isRunning()){
                        stopWatch.stop();
                    }
                    System.out.println(stopWatch.prettyPrint());
                    stopWatch.start();
                });
    }

    private void restTemplate() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String helloResult = restTemplate.getForObject("/hello", String.class);
        System.out.println(helloResult);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        stopWatch.start();

        String worldResult = restTemplate.getForObject("/world", String.class);
        System.out.println(worldResult);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
