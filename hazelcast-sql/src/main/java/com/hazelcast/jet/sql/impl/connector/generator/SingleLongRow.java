/*
 * Copyright 2021 Hazelcast Inc.
 *
 * Licensed under the Hazelcast Community License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://hazelcast.com/hazelcast-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.jet.sql.impl.connector.generator;

import com.hazelcast.sql.impl.row.Row;

import java.util.Objects;

/**
 * A row with a single long field.
 */
class SingleLongRow implements Row {

    private final long value;

    SingleLongRow(long value) {
        this.value = value;
    }

    @Override
    public <T> T get(int index) {
        if (index != 0) {
            throw new IndexOutOfBoundsException("SingleLongRow has one column");
        }
        return (T) Long.valueOf(value);
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SingleLongRow that = (SingleLongRow) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + value + "}";
    }
}