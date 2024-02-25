//package com.personal.assisent.Hub.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
//
//@Configuration
//public class ElasticsearchConfig extends ElasticsearchConfiguration {
//    @Value("${spring.data.elasticsearch.cluster-nodes}")
//    private String host;
//
//    @Override
//    public ClientConfiguration clientConfiguration() {
//        return ClientConfiguration.builder().connectedTo(host).build();
//    }
//}
