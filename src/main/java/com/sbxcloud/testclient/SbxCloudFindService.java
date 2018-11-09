package com.sbxcloud.testclient;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@Service
public class SbxCloudFindService {


    private final WebClient webClient;

    @Value("classpath:json/query.json")
    Resource query;


    public SbxCloudFindService(WebClient.Builder webClientBuilder, @Value("${sbx.auth.token}") String sbxToken) {

        this.webClient = webClientBuilder.baseUrl("https://sbxcloud.com/api")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + sbxToken)
                .build();

    }


    public <T> Mono<T> loadPage(ParameterizedTypeReference<T> clazz) {
        // TODO: load the query from the resource.
        return webClient.post().uri("/data/v1/row/find")
                .body(BodyInserters.fromObject("{\"page\":1,\"size\":1000,\"where\":[{\"ANDOR\":\"AND\",\"GROUP\":[{\"ANDOR\":\"AND\",\"FIELD\":\"cart_box.purchase\",\"OP\":\"IS NOT\",\"VAL\":null},{\"ANDOR\":\"AND\",\"FIELD\":\"cart_box.grower\",\"OP\":\"=\",\"VAL\":\"e1c4b104-e46c-491c-9af8-bc89b6de39d4\"},{\"ANDOR\":\"AND\",\"FIELD\":\"cart_box.packing_date\",\"OP\":\"=\",\"VAL\":20181107}]}],\"domain\":129,\"row_model\":\"cart_box_item\",\"fetch\":[\"grower\",\"inventory.masterlist\",\"product_group\",\"variety.color\",\"uom\",\"stems_per_bunch\",\"cart_box.grade\",\"cart_box.customer\",\"cart_box.purchase\",\"cart_box.status\",\"cart_box.box\",\"cart_box.product_group\"]}\n")).retrieve()
                .bodyToMono(clazz);
    }


}

@Data
class CartBoxItem {
    @JsonProperty("_KEY")
    String key;
    String inventory;
    Inventory inventoryRef;
}


@Data
class Inventory {
    Integer quantity;
    Integer week;
    Integer endDate;
    String masterlist;
}

@Data
class Rows<T> {
    Boolean success;
    Integer rowCount;
    Integer totalPages;
    T[] results;
    Map<String, Object> fetchedResults;
}
