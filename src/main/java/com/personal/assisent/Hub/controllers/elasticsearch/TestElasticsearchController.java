//package com.personal.assisent.Hub.controllers;
//
//import com.personal.assisent.Hub.entity.es.Question;
//import com.personal.assisent.Hub.model.Testing;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.client.elc.NativeQuery;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.query.Query;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/")
//public class TestController {
//
//    private final ElasticsearchOperations elasticsearchOperations;
//    @Autowired
//    public TestController(ElasticsearchOperations elasticsearchOperations) {
//        this.elasticsearchOperations = elasticsearchOperations;
//    }
//
//    @GetMapping("testing")
//    public Testing testing() {
//
//        Query query = NativeQuery.builder()
//                .withQuery(q ->
//                        q.bool( b -> b
//                                .should(s -> s.term(t ->
//                                        t.field("questionName").value("testing"))
//                        ))
//                ).build();
////        System.out.println(query.toString());
////        System.out.println(query.getQuery());
//        SearchHits<Question> searchHits = elasticsearchOperations.search(query, Question.class);
//
//        System.out.println(searchHits);
//        searchHits.forEach(x -> System.out.println(x.getContent().toString()));
//        Testing testing = new Testing();
//        testing.setHello("hello");
//        return testing;
//    }
//
//
//}
