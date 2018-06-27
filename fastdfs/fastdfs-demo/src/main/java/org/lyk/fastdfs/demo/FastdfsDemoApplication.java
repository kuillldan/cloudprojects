package org.lyk.fastdfs.demo;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

//@SpringBootApplication
public class FastdfsDemoApplication
{

    public static void main(String[] args) throws Exception
    {
        ClassPathResource res = new ClassPathResource("fastdfs.conf");
        ClientGlobal.init(res.getClassLoader().getResource("fastdfs.conf").getPath());
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient client = new StorageClient(trackerServer, storageServer);
        System.out.println(client.delete_file("group1", "M00/00/00/wKgBaFr_gZuAN6ujAAC9qv1-DLY012.jpg"));
    }

    public static void getFileInfo() throws Exception
    {
        ClassPathResource res = new ClassPathResource("fastdfs.conf");
        ClientGlobal.init(res.getClassLoader().getResource("fastdfs.conf").getPath());
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient client = new StorageClient(trackerServer, storageServer);
        FileInfo fileInfo = client.get_file_info("group1", "M00/00/00/wKgBaFr_gZuAN6ujAAC9qv1-DLY012.jpg");
        System.out.println(fileInfo.getCreateTimestamp());
        System.out.println(fileInfo.getFileSize());
        System.out.println(fileInfo.getSourceIpAddr());
        trackerServer.close();
    }

    public static void saveFile() throws Exception
    {
        File imgFile = new File("C:\\D\\other\\liuyan1.jpg");
        String fileExtName = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
        ClassPathResource res = new ClassPathResource("fastdfs.conf");
        ClientGlobal.init(res.getClassLoader().getResource("fastdfs.conf").getPath());
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient client = new StorageClient(trackerServer, storageServer);
        NameValuePair[] metaList = new NameValuePair[3];
        metaList[0] = new NameValuePair("fileName", imgFile.getName());
        metaList[1] = new NameValuePair("fileExtName", fileExtName);
        metaList[2] = new NameValuePair("fileLength", String.valueOf(imgFile.length()));
        String[] fieldId = client.upload_file(imgFile.getPath(), fileExtName, metaList);
        System.out.println(Arrays.toString(fieldId));
        trackerServer.close();
    }
}
