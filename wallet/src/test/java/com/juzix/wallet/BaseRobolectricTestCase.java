package com.juzix.wallet;



import com.juzhen.framework.network.ApiResponse;
import com.juzix.wallet.config.AppSettings;
import com.juzix.wallet.engine.NodeManager;
import com.juzix.wallet.entity.Node;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * 测试基类
 * 其他测试类需要的时候直接继承这个类，不需要每次去添加配置了
 *
 */
//@RunWith(RobolectricTestRunner.class)
//@Config(sdk = 27,manifest = Config.NONE)
public class BaseRobolectricTestCase {
//    @Mock
//    public NodeManager nodeManager;
//    @Mock
//    public Node node;
//
//    @Before
//    public void setup() throws Exception {
//        AppSettings appSettings = AppSettings.getInstance();
//        nodeManager = NodeManager.getInstance();
//        node = new Node.Builder().build();
//        nodeManager.setCurNode(node);
//        appSettings.init(RuntimeEnvironment.application);
//        ApiResponse.init(RuntimeEnvironment.application);
//    }
//    public Application getApplication() {
//        return RuntimeEnvironment.application;
//    }
//
//    public Context getContext() {
//        return RuntimeEnvironment.application;
//    }
//
//    public String getString(int id) {
//        return RuntimeEnvironment.application.getString(id);
//    }
//
//    public String getPkgName() {
//        return RuntimeEnvironment.application.getPackageName();
//    }
//
//    public <T extends Activity> T startActivity(Class<T> activityClass) {
//        return Robolectric.setupActivity(activityClass);
//    }
//
//    public void startFragment(Fragment fragment) {
//        SupportFragmentTestUtil.startFragment(fragment);
//    }


}