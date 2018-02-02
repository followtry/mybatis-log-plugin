package mybatis.log.action;

import com.intellij.ide.CopyProvider;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;

/**
 * @author jingzhongzhi
 * @since 2018/2/2
 */
public abstract class AbstractSearchAction extends AnAction implements DumbAware {

    protected void doUpdate(AnActionEvent event) {
        Presentation presentation = event.getPresentation();
        DataContext dataContext = event.getDataContext();
        CopyProvider copyProvider = PlatformDataKeys.COPY_PROVIDER.getData(dataContext);
        boolean var5 = copyProvider != null && copyProvider.isCopyEnabled(dataContext) && copyProvider.isCopyVisible(dataContext);
        presentation.setEnabled(var5);
        presentation.setVisible(var5);
    }
}
