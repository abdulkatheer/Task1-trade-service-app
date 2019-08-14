package org.katheer.tradeserviceapp.service;

import org.katheer.tradeserviceapp.operation.Operation;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TradeService {
   <T> T performOperation (Operation operation) throws Exception;
}
