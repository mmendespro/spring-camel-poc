package net.local.poc.camel.aggregator.service.aggregators;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.util.json.JsonObject;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

public class DepartmentAggregator implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if(oldExchange == null) {
            return newExchange;
        }
        
        String organization = oldExchange.getIn().getBody(String.class);
        String departments = newExchange.getIn().getBody(String.class);
        
        JsonParser parser = JsonParserFactory.getJsonParser();
        JsonObject json = new JsonObject(parser.parseMap(organization));
        json.put("departments", parser.parseList(departments));
        
        oldExchange.getIn().setBody(json.toJson());
        return oldExchange;
    }
    
}
