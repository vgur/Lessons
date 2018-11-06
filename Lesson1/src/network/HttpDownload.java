package network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Semaphore;

public class HttpDownload {
    private static final int BUFFER_SIZE = 4096;

    public static void downloadFile(String fileURL, String saveDir) throws IOException {

        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {

            String fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            String saveFilePath = saveDir + File.separator + fileName;

            InputStream inputStream = httpConn.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("Файл " + fileName + " загружен!");
        } else {
            System.out.println("Ошибка загрузки. Код сервера : " + responseCode);
        }
        httpConn.disconnect();
    }

}

class DownloadtThread implements Runnable {
    Semaphore sem;
    String url;
    String destinationFile;

    public DownloadtThread(String url, Semaphore sem, String destinationFile) {
        this.sem = sem;
        this.url = url;
        this.destinationFile = destinationFile;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            HttpDownload.downloadFile(url, destinationFile);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}