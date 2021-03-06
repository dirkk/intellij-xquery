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

package org.intellij.xquery.annotator.xqdoc;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static org.intellij.xquery.documentation.XQDocTransformer.XQ_DOC_TAGS;
import static org.intellij.xquery.highlighting.XQuerySyntaxHighlighter.DOC_COMMENT_TAG;
import static org.intellij.xquery.psi.XQueryBasicTypes.DOC_COMMENT_CONTENT;

/**
 * User: ligasgr
 * Date: 20/12/13
 * Time: 14:42
 */
public class XQDocHighlighter {

    private static void setHighlighting(@NotNull TextRange range, @NotNull AnnotationHolder holder,
                                        @NotNull TextAttributesKey key) {
        holder.createInfoAnnotation(range, null).setEnforcedTextAttributes(EditorColorsManager.getInstance()
                .getGlobalScheme().getAttributes(key));
    }

    public void highlightXQDocTags(PsiComment comment, AnnotationHolder holder) {
        IElementType tokenType = comment.getTokenType();
        if (tokenType == DOC_COMMENT_CONTENT) {
            String commentText = comment.getText();
            List<Pair<String, Integer>> wordsWithOffset = StringUtil.getWordsWithOffset(commentText);
            for (Pair<String, Integer> pair : wordsWithOffset) {
                Integer offset = pair.second;
                String tag = pair.first;
                if (XQ_DOC_TAGS.contains(tag)) {
                    TextRange range = TextRange.from(comment.getTextOffset() + offset, tag.length());
                    setHighlighting(range, holder, DOC_COMMENT_TAG);
                }
            }
        } else {
            return;
        }
    }
}
