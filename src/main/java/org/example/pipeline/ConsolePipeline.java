package org.example.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.example.util.TimeUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ConsolePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            String filePath = System.getProperty("user.dir") + "/src/main/resources/" + TimeUtil.getCurrentYear() + ".txt";
            System.out.println(filePath);
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            String json = entry.getValue().toString();
            JSONObject jsonObject = JSONObject.parseObject(json);
            for (Object value : jsonObject.values()) {
                JSONObject result = JSONObject.parseObject(value.toString());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(result.getString("name") + "\t");
                stringBuilder.append(result.getString("date") + "\t");
                stringBuilder.append(result.getString("holiday"));
                pw.println(stringBuilder.toString());
            }

        }
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}