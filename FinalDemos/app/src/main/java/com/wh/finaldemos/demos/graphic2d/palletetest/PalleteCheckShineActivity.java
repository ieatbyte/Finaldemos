package com.wh.finaldemos.demos.graphic2d.palletetest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wh.finaldemos.R;
import com.whlib.alib.Log.XLog;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PalleteCheckShineActivity extends AppCompatActivity {

    XLog logger = new XLog(PalleteCheckShineActivityFragment.class, true, true, "check_shine");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallete_check_shine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AlertDialog.Builder getImageFrom = new AlertDialog.Builder(PalleteCheckShineActivity.this);
        getImageFrom.setTitle("Select:");
        final CharSequence[] opsChars = {"Take a photo", "Select from gallery"};
        getImageFrom.setItems(opsChars, new android.content.DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    dispatchTakePictureIntentFull();
                } else if (which == 1) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent,
                            "from gallery"), SELECT_PICTURE);
                }
                dialog.dismiss();
            }
        });
        final AlertDialog dialog = getImageFrom.create();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(null);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("From Gallery", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//
//                            }
//                        }).show(); //.setAction("From Camera", null)
                dialog.show();
                //dispatchTakePictureIntent();
                //dispatchTakePictureIntentFull();
            }
        });
//        Intent intent = getPackageManager().getLaunchIntentForPackage("com.qihoo.camera");
//        XLog.d("intent:" + intent);
//        startActivity(intent);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    static final int REQUEST_TAKE_PHOTO = 2;

    static final int SELECT_PICTURE = 3;

    private void dispatchTakePictureIntentFull() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logger.d("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logger.d("onRestoreInstanceState");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            XLog.d("xlog", "onActivityResult :" + mCurrentPhotoPath + ", requestCode:" + requestCode + ", resultCode:" + resultCode);
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
            if (fragment != null && fragment instanceof PalleteCheckShineActivityFragment) {
                switch (requestCode) {
                    case REQUEST_TAKE_PHOTO: {
                        if (data != null) {
                            XLog.d("xlog", "onActivityResult data not null");
                            Bundle extras = data.getExtras();
                            if (extras != null) {
                                XLog.d("xlog", "onActivityResult extras not null");
                                Bitmap imageBitmap = (Bitmap) extras.get("data");
                                ((PalleteCheckShineActivityFragment) fragment).onImageBitmapGot(imageBitmap);
                            }
                        } else if (mCurrentPhotoPath != null) {
                            ((PalleteCheckShineActivityFragment) fragment).onImagePathGot(mCurrentPhotoPath);
                        }
                        break;
                    }
                    case SELECT_PICTURE: {
                        Uri selectedImage = data.getData();
                        ((PalleteCheckShineActivityFragment) fragment).onImageUriGot(selectedImage);
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(mCurrentPhotoPath)) {
                galleryAddPic();
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
