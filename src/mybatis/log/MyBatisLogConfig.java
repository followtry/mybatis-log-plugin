package mybatis.log;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;
import mybatis.log.action.gui.FilterSetting;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置项参数
 *
 * @author ob
 */
public class MyBatisLogConfig {
    public static PropertiesComponent properties;//filter setting
    public static FilterSetting settingDialog;
    public static Map<String, mybatis.log.ConfigVo> configMap = new HashMap<>();
    public static Map<String, ConsoleView> consoleViewMap = new HashMap<>();

    public static mybatis.log.ConfigVo getConfigVo(Project project) {
        mybatis.log.ConfigVo configVo = configMap.get(project.getBaseDir().getName());
        if(configVo == null) {
            //初始化参数设置
            configVo = new mybatis.log.ConfigVo();
            configVo.setRunning(false);
            configVo.setSqlFormat(false);
            configVo.setIndexNum(1);
            MyBatisLogConfig.setConfigVo(project, configVo);
        }
        return configVo;
    }

    public static void setConfigVo(Project project, mybatis.log.ConfigVo configVo) {
        configMap.put(project.getBaseDir().getName(), configVo);
    }
}
