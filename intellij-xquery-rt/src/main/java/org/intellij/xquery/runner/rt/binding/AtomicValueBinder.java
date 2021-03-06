/*
 * Copyright 2013 Grzegorz Ligas <ligasgr@gmail.com> and other contributors (see the CONTRIBUTORS file).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.xquery.runner.rt.binding;

import org.intellij.xquery.runner.rt.XQJType;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQItemType;
import javax.xml.xquery.XQPreparedExpression;

/**
 * User: ligasgr
 * Date: 11/10/13
 * Time: 16:35
 */
public class AtomicValueBinder implements TypeBinder {
    @Override
    public void bind(XQPreparedExpression expression, XQConnection connection, QName name, String value,
                                 String type) throws Exception {
        expression.bindAtomicValue(name, value, getType(connection, type));
    }

    private XQItemType getType(XQConnection connection, String type) throws Exception {
        return connection.createAtomicType(XQJType.getXQJTypeForDescription(type));
    }
}
