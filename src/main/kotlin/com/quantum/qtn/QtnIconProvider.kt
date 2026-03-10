package com.quantum.qtn

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import javax.swing.Icon

class QtnIconProvider : IconProvider() {
    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        if (element is PsiFile && element.virtualFile?.extension == "qtn") {
            return QtnIcons.QTN_FILE
        }
        return null
    }
}
