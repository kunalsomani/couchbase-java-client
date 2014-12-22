/**
 * Copyright (C) 2014 Couchbase, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALING
 * IN THE SOFTWARE.
 */
package com.couchbase.client.java.query;

import com.couchbase.client.java.document.json.JsonObject;

/**
 * The simplest form of N1QL {@link Query} with a plain un-parametrized {@link Statement}.
 *
 * @author Simon Baslé
 * @since 2.1
 */
public class SimpleQuery implements Query {

    private final Statement statement;

    /**
     * Create a new {@link Query} with a plain un-parametrized {@link Statement}.
     * @param statement the {@link Statement} to execute
     */
    public SimpleQuery(Statement statement) {
        this.statement = statement;
    }

    @Override
    public Statement statement() {
        return this.statement;
    }

    @Override
    public String toN1QL() {
        return JsonObject.create()
            .put("statement", this.statement.toString())
            .toString();
    }
}