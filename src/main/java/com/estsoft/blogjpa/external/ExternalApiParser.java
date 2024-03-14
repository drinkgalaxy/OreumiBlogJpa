//package com.estsoft.blogjpa.external;
//
//import com.estsoft.blogjpa.dto.AddArticleRequest;
//import com.estsoft.blogjpa.service.BlogService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//@Slf4j
//@Component
//public class ExernalApiParser {
//    // 외부 API 호출 -> json 받아오기
////    private final RestTemplate restTemplate;
////    public ExternalApiParser(RestTemplate restTemplate) {
////        this.restTemplate = restTemplate;
////    }
//    public ExternalApiParser(BlogService service) {
//        this.service = service;
//    }
//
//    public void parserAndSave() {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://jsonplaceholder.typicode.com/posts";
//        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
//
//        if (response.getStatusCode().is2xxSuccessful()) { // 만약 이 값이 200으로 성공한다면!
//            log.info("body : "+ response.getBody());
//            List<LinkedHashMap<String, Object>> list = response.getBody();
//            List<AddArticleRequest> insertList = new ArrayList<>();
//            // title, body
//            for (LinkedHashMap<String, Object> map : list) {
//                String title = (String) map.get("title");
//                String content = (String) map.get("body");
//
//                service.save(new AddArticleRequest(title, content));
//
//            }
//        }
//    }
//}
