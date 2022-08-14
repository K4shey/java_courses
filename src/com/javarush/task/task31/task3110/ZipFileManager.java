package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ZipFileManager {

    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory)) {
            Files.createDirectories(zipDirectory);
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
        ) {

            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path fileName : fileNames) {
                    addNewZipEntry(zipOutputStream, source, fileName);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        try (InputStream inputStream = Files.newInputStream(filePath.resolve(fileName));) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        List<FileProperties> filePropertiesList = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                copyData(zipInputStream, byteArrayOutputStream);
                FileProperties fileProperties = new FileProperties
                        (zipEntry.getName(), zipEntry.getSize(), zipEntry.getCompressedSize(), zipEntry.getMethod());
                filePropertiesList.add(fileProperties);
            }
        }
        return filePropertiesList;
    }

    public void extractAll(Path outputFolder) throws Exception {

        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        if (Files.notExists(outputFolder)) {
            Files.createDirectories(outputFolder);
        }

        ZipEntry nextEntry = null;
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            while ((nextEntry = zipInputStream.getNextEntry()) != null) {
                processZipEntry(nextEntry, outputFolder, zipInputStream);
            }
        }
    }

    private void processZipEntry(ZipEntry zipEntry, Path outputFolder, ZipInputStream zipInputStream) throws Exception {

        Path absPath = outputFolder.resolve(zipEntry.getName());
        if (Files.notExists(absPath.getParent())) {
            Files.createDirectories(absPath.getParent());
        }
        OutputStream outputStream = Files.newOutputStream(absPath);
        copyData(zipInputStream, outputStream);
        outputStream.close();
    }

    public void removeFiles(List<Path> pathList) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        Path tempZipFile = Files.createTempFile(null, null);

        ZipEntry nextEntry = null;
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));
             ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZipFile));) {
            while ((nextEntry = zipInputStream.getNextEntry()) != null) {
                if (pathList.contains(Paths.get(nextEntry.getName()))) {
                    ConsoleHelper.writeMessage(String.format("Файл %s удалён из архива", nextEntry.getName()));
                } else {
                      zipOutputStream.putNextEntry(nextEntry);
                      copyData(zipInputStream, zipOutputStream);
                }
            }
        }
        Files.move(tempZipFile, zipFile, REPLACE_EXISTING);
    }

    public void removeFile(Path path) throws Exception {
        List<Path> singletonList = Collections.singletonList(path);
        removeFiles(singletonList);
    }
}





























