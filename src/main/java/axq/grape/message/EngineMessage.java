package axq.grape.message;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ace <arthur4it@gmail.com> on 26, 06, 2015.
 */
public class EngineMessage implements Serializable{
    String info;
    ArrayList<String> fileContent;
    public int getContentLineCount() {
        return fileContent.size();
    }
    public EngineMessage(InputStream inputStream) {
        this.fileContent= new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.add(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EngineMessage(String controlinfo){
        this.info=controlinfo;
    }
    public ArrayList<String> getFileContent() {
        return fileContent;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
