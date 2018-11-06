package network;

import java.util.concurrent.Semaphore;

public class TestDownload {

    public static void main(String[] args) throws Exception {

        Semaphore sem = new Semaphore(2);

        String imageUrl = "https://catspaw.ru/wp-content/uploads/2017/03/Seryiy-kot-Daniel-Felicia.jpg";
        String destinationFile = "C:/TEMP";
        new Thread(new DownloadtThread(imageUrl, sem, destinationFile)).start();
        imageUrl = "https://static.probusiness.io/720x480c/n/03/d/38097027_439276526579800_2735888197547458560_n.jpg";
        new Thread(new DownloadtThread(imageUrl, sem, destinationFile)).start();
        imageUrl = "https://cdn2.img.ria.ru/images/148393/86/1483938656.jpg";
        new Thread(new DownloadtThread(imageUrl, sem, destinationFile)).start();
        imageUrl = "https://icdn.lenta.ru/images/2018/09/07/09/20180907092850529/pic_32874ef1a26ef118dd32a33a72f277af.jpg";
        new Thread(new DownloadtThread(imageUrl, sem, destinationFile)).start();

    }

}
