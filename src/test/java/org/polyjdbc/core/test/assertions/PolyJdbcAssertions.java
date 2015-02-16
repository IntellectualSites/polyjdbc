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

import org.assertj.core.api.Assertions;
import org.polyjdbc.core.PolyJDBC;
import org.polyjdbc.core.exception.PolyJdbcException;

/**
 *
 * @author Adam Dubiel
 */
public final class PolyJdbcAssertions extends Assertions {

    private PolyJdbcAssertions() {
    }

    public static PolyJdbcExceptionAssert assertThat(PolyJdbcException actual) {
        return PolyJdbcExceptionAssert.assertThat(actual);
    }

    public static DatabaseAssert assertThat(PolyJDBC actual) {
        return DatabaseAssert.assertThat(actual);
    }
}
