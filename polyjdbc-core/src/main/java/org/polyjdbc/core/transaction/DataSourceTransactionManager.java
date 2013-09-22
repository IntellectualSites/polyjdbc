/*
 * Copyright 2013 Adam Dubiel, Przemek Hertel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.polyjdbc.core.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.polyjdbc.core.dialect.Dialect;
import org.polyjdbc.core.exception.PolyJdbcException;

/**
 *
 * @author Adam Dubiel
 */
public class DataSourceTransactionManager implements TransactionManager {

    private Dialect dialect;

    private DataSource dataSource;

    public DataSourceTransactionManager(Dialect dialect, DataSource dataSource) {
        this.dialect = dialect;
        this.dataSource = dataSource;
    }

    @Override
    public Transaction openTransaction() {
        return openTransaction(false);
    }

    @Override
    public Transaction openTransaction(boolean autoCommit) {
        Connection connection;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(autoCommit);
            return new Transaction(dialect, connection);
        } catch (SQLException e) {
            throw new PolyJdbcException("OPEN_CONNECTION_ERROR", "Failed to obtain connection from datasource.", e);
        }
    }
}
