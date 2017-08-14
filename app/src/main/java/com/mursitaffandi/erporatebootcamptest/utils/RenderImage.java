package com.mursitaffandi.erporatebootcamptest.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mursitaffandi on 13/08/17.
 */

public class RenderImage extends AsyncTask<String,Void,Bitmap> {
    private WeakReference<ImageView> imageview;
    public RenderImage(ImageView imv){
        imageview=new WeakReference<ImageView>(imv);
    }
    /** Background process
     * input:url
     * output: Bitmap image
     * It passed into onPostExecute method
     **/
    @Override
    protected Bitmap doInBackground(String... urls) {

        return getBitMapFromUrl(urls[0]);

    }
    /** This method called after the doINputBackground method
     * input:Bitmap image
     * output: image set into the image view
     * Image view  passed from RecyclerViewOperation to ShowImage class through constructor
     **/
    @Override
    protected void onPostExecute(Bitmap result) {
        if((imageview!=null)&&(result!=null)){
            ImageView imgview=imageview.get();


            if(imgview!=null){

                imgview.setImageBitmap(result);
            }
        }
    }
    /** This method called by doInBackground method
     * input:url
     * output: Bitmap image
     *
     **/
    private Bitmap getBitMapFromUrl( String imageuri){
        HttpURLConnection connection=null;

        try {
            URL url=new URL(imageuri);
            //  Log.d("bucky","bitmap" + imageuri);
            connection= (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream is=connection.getInputStream();
            Bitmap mybitmap= BitmapFactory.decodeStream(is);

            return mybitmap;


        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if(connection!=null) {
                connection.disconnect();
            }
        }
    }

}
