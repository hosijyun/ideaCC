package org.gark87.idea.javacc.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class SectionManipulator extends AbstractElementManipulator<Identifier> {
    @Override
    public Identifier handleContentChange(Identifier identifier, TextRange range, String newContent)
            throws IncorrectOperationException {
        final String oldText = identifier.getText();
        String newText = oldText.substring(0, range.getStartOffset()) + newContent +
                oldText.substring(range.getEndOffset());
        return (Identifier) identifier.replaceWithText(newText);
    }
}
