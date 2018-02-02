package mybatis.log.action;

import com.intellij.ide.BrowserUtil;
import com.intellij.ide.CopyProvider;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.util.text.StringUtil;

import java.awt.datatransfer.DataFlavor;
import java.net.URLEncoder;

/**
 * Translate with Google
 * @author ob
 */
public class GoogleTranslateAction extends AbstractSearchAction {
    public GoogleTranslateAction() {
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        DataContext dataContext = event.getDataContext();
        CopyProvider copyProvider = PlatformDataKeys.COPY_PROVIDER.getData(dataContext);
        if (copyProvider != null) {
            copyProvider.performCopy(dataContext);
            String contents = CopyPasteManager.getInstance().getContents(DataFlavor.stringFlavor);
            if (StringUtil.isNotEmpty(contents)) {
                BrowserUtil.browse("https://translate.google.com/#en/zh-CN/" + URLEncoder.encode(contents));
            }
        }
    }

    @Override
    public void update(AnActionEvent event) {
        super.doUpdate(event);
    }
}