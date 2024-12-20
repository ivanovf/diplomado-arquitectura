package com.example;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Comparator;
import java.util.Map;



public class CurrencyReactor {

    private static final String API_URL = "https://api.frankfurter.dev/v1/latest?base=USD";

    public static void main(String[] args) {
        WebClient webClient = WebClient.create();

        @SuppressWarnings("unchecked")
        Mono<Map<String, Double>> currencyRatesMono = webClient.get()
                .uri(API_URL)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (Map<String, Double>) response.get("rates"));

        currencyRatesMono.flatMapMany(map -> Flux.fromIterable(map.entrySet()))
                .filter(entry -> entry.getValue() < 1.5) // Filter currencies closer to the dollar
                .sort(Comparator.<Map.Entry<String, Double>, Double>comparing(Map.Entry::getValue).reversed()) // Sort in descending order
                .doOnNext(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()))
                .collectList()
                .map(entries -> entries.stream().mapToDouble(Map.Entry::getValue).average().orElse(0.0)) // Calculate average
                .doOnNext(avg -> System.out.println("Average: " + avg))
                .block();
    }
}