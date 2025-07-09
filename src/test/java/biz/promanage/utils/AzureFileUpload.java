package biz.promanage.utils;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class AzureFileUpload {

    public static final String cloudStoragePath = "DefaultEndpointsProtocol=https;" + "AccountName=lscdn;" + "AccountKey=VJaEkV1G5J21LkkUrfYekud70dlxhctYrotlMg/NLv4UQu2ZGEtWUvYbH5ff9ffMXCIoW2X/B2vQZ5YcoMRIgA==";

    public static void ScreenShot(File imagePath) {

        String blobDirectory = "Capshine";
        CloudStorageAccount storageAccount;
        CloudBlobClient blobClient;
        CloudBlobContainer container;
        CloudBlobDirectory dir;

        try {

            storageAccount = CloudStorageAccount.parse(cloudStoragePath);
            blobClient = storageAccount.createCloudBlobClient();
            container = blobClient.getContainerReference("jenkins");
            dir = container.getDirectoryReference(blobDirectory);

            BufferedImage image;
            image = ImageIO.read(imagePath);
            ImageIO.write(image, "png", imagePath);
            CloudBlockBlob blob = dir.getBlockBlobReference(imagePath.getName());
            blob.uploadFromFile(imagePath.getAbsolutePath());

        } catch (StorageException ex) {
            System.out.printf("Error returned from the service. Http code: %d and error code: %s%n", ex.getHttpStatusCode(), ex.getErrorCode());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Failed to upload file to Azure");
        }
    }
}
