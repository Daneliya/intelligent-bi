package com.xxl.intelligent.manager;

import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.springframework.stereotype.Service;

/**
 * 阿里百炼
 *
 * @Author: xxl
 * @Date: 2025/2/4 22:13
 */
@Service
public class BailianManager {

    public static void appCall(String message) throws ApiException, NoApiKeyException, InputRequiredException {
        ApplicationParam param = ApplicationParam.builder()
                // 若没有配置环境变量，可用百炼API Key将下行替换为：.apiKey("sk-xxx")。但不建议在生产环境中直接将API Key硬编码到代码中，以减少API Key泄露风险。
                .apiKey("sk-e9add5896dd84ba49d0f142dab6383d9")
                .appId("ec098451f85f49f08f97f4a299a5a9a4")
                .prompt(message)
                .build();

        Application application = new Application();
        ApplicationResult result = application.call(param);

        System.out.printf("text: %s\n", result.getOutput().getText());
    }

    public static String appCallSynch(String message) {
        try {
            ApplicationParam param = ApplicationParam.builder()
                    // 若没有配置环境变量，可用百炼API Key将下行替换为：.apiKey("sk-xxx")。但不建议在生产环境中直接将API Key硬编码到代码中，以减少API Key泄露风险。
                    .apiKey("sk-e9add5896dd84ba49d0f142dab6383d9")
                    .appId("ec098451f85f49f08f97f4a299a5a9a4")
                    .prompt(message)
                    .build();

            Application application = new Application();
            ApplicationResult result = application.call(param);

//            System.out.printf("text: %s\n", result.getOutput().getText());
            System.out.println("=============");
//            System.out.printf(result.getOutput().getText());
            return result.getOutput().getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

//    public static void main(String[] args) {
//        try {
//            appCall();
//        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
//            System.err.println("message：" + e.getMessage());
//            System.out.println("请参考文档：https://help.aliyun.com/zh/model-studio/developer-reference/error-code");
//        }
//        System.exit(0);
//    }
}
