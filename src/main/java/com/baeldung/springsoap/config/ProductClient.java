package com.baeldung.springsoap.config;

import com.baeldung.springsoap.gen.GetProductRequest;
import com.baeldung.springsoap.gen.GetProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ProductClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(ProductClient.class);

    public GetProductResponse getProduct(String productnumber) {
        GetProductRequest request = new GetProductRequest();
        logger.info("Requesting information for " + productnumber);

        GetProductResponse response = (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(productnumber);
        return response;
    }

}
