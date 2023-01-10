package com.function.demo;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */
    @FunctionName("HttpExample")
    public void run(
            @BlobTrigger(
                name = "file",
                dataType = "binary",
                path = "demoblobtrigger/{name}.csv",
                connection = "DemoStorageAccountAppSetting") byte[] file,
            @BindingName("name") String filename,
            final ExecutionContext context) {

        context.getLogger().info("Java HTTP trigger processed a request.");

        context.getLogger().info("CSV arrived | Name: " + filename + " Size: " + file.length + " bytes");
    }
}
