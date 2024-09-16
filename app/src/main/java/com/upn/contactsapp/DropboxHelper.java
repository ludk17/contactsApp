package com.upn.contactsapp;

import android.net.Uri;
import android.util.Log;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.WriteMode;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.upn.contactsapp.factories.DropboxClientFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class DropboxHelper {

    public interface DropboxCallback {
        void onSuccess(String url);  // Llamado cuando se obtiene la URL
        void onError(String error);  // Llamado cuando ocurre un error
    }

    private static final String TAG = "DropboxHelper";

    public void uploadFileToDropbox(File file, String dropboxPath) {
        DbxClientV2 client = DropboxClientFactory.getClient();
        Thread thread = new Thread(() -> {
            try (InputStream in = Files.newInputStream(file.toPath())) {
                FileMetadata metadata = client.files().uploadBuilder(dropboxPath)
                        .withMode(WriteMode.OVERWRITE)
                        .uploadAndFinish(in);
                Log.d(TAG, "File uploaded: " + metadata.getPathLower());
            } catch (IOException | DbxException e) {
                Log.e(TAG, "Error uploading file to Dropbox: " + e.getMessage());
            }
        });
        thread.start();
    }

    public void uploadFileToDropbox(InputStream inputStream, String dropboxPath, DropboxCallback callback) {
        DbxClientV2 client = DropboxClientFactory.getClient();

        Thread thread = new Thread(() -> {

                try  {
                FileMetadata metadata = client.files().uploadBuilder(dropboxPath)
                        .withMode(WriteMode.OVERWRITE)
                        .uploadAndFinish(inputStream);
                Log.d(TAG, "File uploaded: " + metadata.getPathLower());

                SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings("/" + metadata.getName());
//                Log.d(TAG, "Shared link created: " + sharedLinkMetadata.getUrl());
                callback.onSuccess(sharedLinkMetadata.getUrl());
                } catch (IOException | DbxException e) {
                    Log.e(TAG, "Error uploading file to Dropbox: " + e.getMessage());
                }
        });

        thread.start();
    }
}
