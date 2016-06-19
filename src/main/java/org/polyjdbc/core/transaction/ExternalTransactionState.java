package org.polyjdbc.core.transaction;


import java.sql.ResultSet;
import java.sql.Statement;

public class ExternalTransactionState implements TransactionState {

    @Override
    public void registerStatement(Statement statement) {
        // logger.info("Register statement on unmanaged ExternalTransaction, ignoring.");
    }

    @Override
    public void registerCursor(ResultSet resultSet) {
        // logger.trace("Register cursor called on unmanaged ExternalTransaction, ignoring.");
    }

    @Override
    public void commit() {
        // logger.trace("Commit called on unmanaged ExternalTransaction, ignoring.");
    }

    @Override
    public void rollback() {
        // logger.trace("Rollback called on unmanaged ExternalTransaction, ignoring.");
    }

    @Override
    public void close() {
        // logger.trace("Close called on unmanaged ExternalTransaction, ignoring.");
    }
}
