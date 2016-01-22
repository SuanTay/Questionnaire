package fr.limos.util;

import android.os.Environment;
import android.util.Log;

import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by taysuan on 19/01/2016.
 */


public class DownloadDatabase {
    String s = "/";

    final int TIMEOUT_CONNECTION=50000;
    final int TIMEOUT_SOCKET=50000;

    public void DownloadDatabase(String downloadUrl, String folder, String fileName) {
        try {
            //luieu ou télécharge la base
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            File root = Environment.getDataDirectory();
            File localdir = new File(root.getAbsolutePath() + "/data/fr.limos.questionnaire/databases");
            if (localdir.exists() == false) localdir.mkdirs();

            URL url = null;
            url=new URL(downloadUrl+folder+s+fileName);
            File file = new File(localdir, fileName);

            long startTime = System.currentTimeMillis();
            Log.d("DownloadManager", "download url:" + url);
            Log.d("DownloadManager", "download file name:" + fileName);

            URLConnection uconn = url.openConnection();
            uconn.setReadTimeout(TIMEOUT_CONNECTION);
            uconn.setConnectTimeout(TIMEOUT_SOCKET);

            InputStream is = uconn.getInputStream();
            BufferedInputStream bufferinstream = new BufferedInputStream(is);

            ByteArrayBuffer baf = new ByteArrayBuffer(5000);
            int current = 0;
            while ((current = bufferinstream.read()) != -1) {
                baf.append((byte) current);
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baf.toByteArray());
            fos.flush();
            fos.close();
            Log.d("DownloadManager", "download ready in" + ((System.currentTimeMillis() - startTime) / 1000) + "sec");
            int dotindex = fileName.lastIndexOf('.');
            if (dotindex >= 0) {
                fileName = fileName.substring(0, dotindex);

            }
        } catch (IOException e) {
            Log.d("DownloadManager IOEX", "Error:" + e);
        }

    }

    /** copie le fichier source dans le fichier resultat
    * retourne vrai si cela réussit
    */
    public static boolean copyFile(File source, File dest){
        try{
            // Declaration et ouverture des flux
            java.io.FileInputStream sourceFile = new java.io.FileInputStream(source);

            try{
                java.io.FileOutputStream destinationFile = null;

                try{
                    destinationFile = new FileOutputStream(dest);

                    // Lecture par segment de 0.5Mo
                    byte buffer[] = new byte[512 * 1024];
                    int nbLecture;

                    while ((nbLecture = sourceFile.read(buffer)) != -1){
                        destinationFile.write(buffer, 0, nbLecture);
                    }
                } finally {
                    destinationFile.close();
                }
            } finally {
                sourceFile.close();
            }
        } catch (IOException e){
            e.printStackTrace();
            return false; // Erreur
        }

        return true; // Résultat OK
    }


}


