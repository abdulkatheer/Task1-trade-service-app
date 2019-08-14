package org.katheer.tradeserviceapp.operation;

public interface Operation {
   public <T> T perform() throws Exception;
}
