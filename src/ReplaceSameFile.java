import com.sun.xml.internal.ws.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReplaceSameFile {

    public static void main(String[] args) throws IOException {
        //文件内容：localization_en.src
        String fileName = "F:\\Project\\Code\\EXT-TEST\\LeagView-202110SP-TEST\\ItWeb5.0\\src\\com\\cnunisoft\\uma\\localization_en.src";
        String replaceFileName = "F:\\Project\\GitCode\\LeagView-202210SP-Ext\\ItWeb5.0-new\\src\\main\\java\\com\\cnunisoft\\uma\\localization_en.src";
        BufferedWriter out = new BufferedWriter(new FileWriter("F:\\localization_en.src"));

//        String fileName = "F:\\Project\\Code\\EXT-TEST\\LeagView-202110SP-TEST\\ItWeb5.0\\src\\com\\cnunisoft\\uma\\localization.src";
//        String replaceFileName = "F:\\Project\\GitCode\\LeagView-202210SP-Ext\\ItWeb5.0-new\\src\\main\\java\\com\\cnunisoft\\uma\\localization.src";
//        BufferedWriter out = new BufferedWriter(new FileWriter("F:\\localization.src"));

        Map<String, String> oldMap = getValueMap(fileName);

        String content = "";
        try (Scanner sc = new Scanner(new FileReader(replaceFileName))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                String line = sc.nextLine();
                if(line != null && !"".equals(line) && line.contains("=")){
                    String[] strings = line.split("=", 2);
                    String key = strings[0].replace(" ","");
                    if("uploadAssAction.devuselesstime".equals(key) || "upShareFileAndCopytoShare".equals(key)){
                        System.out.println("替换失败=========== "+ line);
                    }
                    if(oldMap.containsKey(key)) {
                        if(strings.length == 2) {
                            line = key + " = " + strings[1].replace(strings[1], oldMap.get(key));
                        } else {
                            System.out.println("替换失败=========== "+ line);
                        }
                    }

                }
                content += line + System.lineSeparator();
            }
        }

        //文件写入

        out.write(content);
        out.close();
        System.out.println("成功替换=========== ");
    }

    private static  Map<String, String> getValueMap(String fileName) {
        Map<String, String> keyAndValue = new HashMap<>();
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                String line = sc.nextLine();
                if(line != null && !"".equals(line) && line.contains("=")) {
                    String[] strings = line.split("=", 2);
                    if(strings.length == 2){
                        keyAndValue.put(strings[0].replace(" ",""), strings[1]);
                    } else {
                        System.out.println(line);
                    }

                    if(strings[0].equals("Thirdparty_employeesinfo8")){
                        System.out.println( strings[1]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return keyAndValue;
    }
}
