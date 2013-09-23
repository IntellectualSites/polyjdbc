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
package org.polyjdbc.core.test.assertions;

import java.util.List;
import org.fest.assertions.api.AbstractAssert;
import org.fest.assertions.api.Assertions;
import org.polyjdbc.core.mapper.EmptyMapper;
import org.polyjdbc.core.query.QueryFactory;
import org.polyjdbc.core.query.QueryRunner;

/**
 *
 * @author Adam Dubiel
 */
public class DatabaseAssert extends AbstractAssert<DatabaseAssert, QueryRunner> {

    private DatabaseAssert(QueryRunner actual) {
        super(actual, DatabaseAssert.class);
    }

    public static DatabaseAssert assertThat(QueryRunner actual) {
        return new DatabaseAssert(actual);
    }

    public DatabaseAssert contains(String name) {
        boolean exists = actual.queryExistence(QueryFactory.select().query("select * from test where name = :name").withArgument("name", name));
        Assertions.assertThat(exists).isTrue();
        return this;
    }

    public DatabaseAssert hasItems(int count) {
        List<Object> items = selectAllItems();
        Assertions.assertThat(items).hasSize(count);
        return this;
    }

    public DatabaseAssert hasNoItems() {
        List<Object> items = selectAllItems();
        Assertions.assertThat(items).isEmpty();
        return this;
    }

    private List<Object> selectAllItems() {
        List<Object> items = actual.queryList(QueryFactory.select().query("select * from test"), new EmptyMapper());
        return items;
    }

    public void close() {
        actual.close();
    }
}