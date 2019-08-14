package org.katheer.tradeserviceapp.service;

import org.katheer.tradeserviceapp.operation.Operation;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {

   @Override
   public final <T> T performOperation(Operation operation) throws Exception {
      return operation.perform();
   }
}