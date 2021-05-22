import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class main {
    public static void main(String[] args) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        Process start ;
        start = runtime.exec("cmd /c netsh wlan connect name = NJUPT-CHINANET");
        reshow(start);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String url = "http://p.njupt.edu.cn:801/eportal/?c=ACSetting&a=Login&protocol=http%3A&hostname=p.njupt.edu.cn&iTermType=1&wlanuserip=10.165.148.230&wlanacip=10.255.252.150&wlanacname=XL-BRAS-SR8806-X&mac=00-00-00-00-00-00&ip=10.165.148.230&enAdvert=0&queryACIP=0&loginMethod=1";

        connect(url);
        start = runtime.exec("cmd /c TASKKILL /F /IM msedge.exe");
        reshow(start);
    }

    public static void connect(String url) throws IOException {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) realUrl.openConnection();

            System.out.println(conn.getResponseCode());
           

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); // POST


            conn.setRequestProperty("upass", "");
            conn.setRequestProperty("0MKKey", "");
            conn.setRequestProperty("DDDDD",",0, ");

            conn.connect();

            // getURLConnection
            out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
            // send request
            //out.write(param);
            // flush buffer
            out.flush();
            // 
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
        } catch (Exception e) {
            System.out.println("error"+e);
            e.printStackTrace();
        }
        //close
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }


    public static void reshow(Process start) throws IOException {
        InputStream inputStream = start.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
        int len = -1;
        char[] c = new char[1024];
        StringBuilder sb = new StringBuilder();
        while ((len = inputStreamReader.read(c)) != -1){
            sb.append(new String(c, 0, len));
        }
        System.out.println(sb);
    }

}


