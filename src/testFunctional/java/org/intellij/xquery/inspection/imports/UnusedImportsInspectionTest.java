/*
 * Copyright 2013-2014 Grzegorz Ligas <ligasgr@gmail.com> and other contributors
 * (see the CONTRIBUTORS file).
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

package org.intellij.xquery.inspection.imports;

import com.intellij.codeInspection.LocalInspectionTool;
import org.intellij.xquery.BaseFunctionalTestCase;

import java.util.ArrayList;
import java.util.Collection;

public class UnusedImportsInspectionTest extends BaseFunctionalTestCase {

    @Override
    protected String getTestDataPath() {
        return "src/testFunctional/testData/org/intellij/xquery/inspection/imports";
    }

    public void testIncorrectFileType() {
        executeTest("IncorrectFileType.txt");
    }

    public void testImportWithDefaultNamespaceForFunctionCall() {
        executeTest();
    }

    public void testImportWithDefaultNamespaceForNamedFunctionRef() {
        executeTest();
    }

    public void testImportWithDefaultNamespaceForVariableRef() {
        executeTest();
    }

    public void testImportWithDefaultNamespaceUnused() {
        executeTest();
    }

    public void testImportWithoutPrefixWithDeclaredNamespace() {
        executeTest();
    }

    public void testImportWithoutPrefixWithoutDeclaredNamespace() {
        executeTest();
    }

    public void testImportWithPrefix() {
        executeTest();
    }

    private void executeTest(String... fileNames) {
        if (fileNames != null && fileNames.length > 0) {
            for (String filename : fileNames) {
                executeTest(filename);
            }
        } else {
            executeTest(getDefaultFileName());
        }
    }

    private void executeTest(String filename) {
        Collection<Class<? extends LocalInspectionTool>> inspections = new ArrayList<Class<? extends
                LocalInspectionTool>>();
        inspections.add(UnusedImportsInspection.class);
        myFixture.enableInspections(inspections);

        myFixture.testHighlighting(true, false, false, filename);
    }
}
