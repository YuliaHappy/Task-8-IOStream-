package com.epam.javauniversity.utils.file;

import java.io.*;

public final class FileUtils {

    private FileUtils() {}

    public static void rewriteFromUTF16ToCp1251(String nameFileFrom, String nameFileTo) throws IOException {
        if (nameFileFrom.isEmpty() || nameFileTo.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFileFrom), "UTF-16"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFileTo), "windows-1251"));
            String str;
            if ((str = reader.readLine()) != null) {
                writer.write(str);
            }
            while ((str = reader.readLine()) != null) {
                writer.newLine();
                writer.write(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error rewrite file " + nameFileFrom + " to " + nameFileTo);
        } finally {
            if (reader !=  null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}