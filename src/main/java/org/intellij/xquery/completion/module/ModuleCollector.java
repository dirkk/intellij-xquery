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

package org.intellij.xquery.completion.module;

import com.intellij.codeInsight.lookup.LookupElement;

import java.util.Collections;
import java.util.List;

/**
 * User: ligasgr
 * Date: 07/08/13
 * Time: 15:08
 */
public class ModuleCollector {
    public ModuleCollector() {
    }

    public List<LookupElement> getProposedLookUpItems() {
        return Collections.emptyList();
    }
}
