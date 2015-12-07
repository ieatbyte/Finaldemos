package com.wh.finaldemos.demos.graphic2d.palletetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wh.finaldemos.App;
import com.wh.finaldemos.R;
import com.whlib.alib.Log.XLog;

import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PalleteCheckShineActivityFragment extends Fragment {

    XLog logger = new XLog(PalleteCheckShineActivityFragment.class, true, true, "check_shine");

    private View rootView;

    private ImageView imageView;

    private Context hostContext;

    private static int sid = 0;

    public PalleteCheckShineActivityFragment() {
        ++sid;
        logger.d("build fragment sid:" + sid);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //logger.d("onCreate " + PalleteCheckShineActivityFragment.this);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        logger.d("onAttach " + PalleteCheckShineActivityFragment.this + ", " + android.os.Process.myPid() + ", sid:" + sid);
        hostContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        logger.d("onDetach");
        hostContext = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logger.d("onDestroy " + PalleteCheckShineActivityFragment.this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_pallete_check_shine, container, false);
        imageView = (ImageView) rootView.findViewById(R.id.image_show);
        return rootView;
    }

    public void onImageBitmapGot(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    public void onImagePathGot(String bitmapPath) {
        new BitmapLoader(this).execute(new BitmapLoadRequest(bitmapPath));
    }

    public void onImageUriGot(Uri bitmapUri) {
        new BitmapLoader(this).execute(new BitmapLoadRequest(bitmapUri));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static class BitmapLoadRequest {
        String path;
        Uri uri;

        public BitmapLoadRequest(String path) {
            this.path = path;
        }

        public BitmapLoadRequest(Uri uri) {
            this.uri = uri;
        }
    }

    public static class BitmapLoader extends AsyncTask<BitmapLoadRequest, Void, Bitmap> {

        XLog logger = new XLog(PalleteCheckShineActivityFragment.class);

        private WeakReference<PalleteCheckShineActivityFragment> hostFragmentW;

        private BitmapLoader(PalleteCheckShineActivityFragment fragment) {
            hostFragmentW = new WeakReference<PalleteCheckShineActivityFragment>(fragment);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            logger.d("onPostExecute " + bitmap);
            if (bitmap != null) {
                logger.d("onPostExecute bitmap w:" + bitmap.getWidth() + ", H:" + bitmap.getHeight() + ", " + (bitmap.getWidth() * bitmap.getHeight()) + ", " + bitmap.getByteCount() + ", " + bitmap.getDensity());
                if (hostFragmentW != null) {
                    PalleteCheckShineActivityFragment hostFragment = hostFragmentW.get();
                    if (hostFragment != null) {
                        hostFragment.imageView.setImageBitmap(bitmap);
                    }
                }
                //analysisBitmap(bitmap);
                new BitmapParser().execute(bitmap);
            }
        }

        private void analysisBitmap(Bitmap bitmap) {
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    logger.d("Generated!");
                    List<Palette.Swatch> swatches = palette.getSwatches();
                    long totalPopulation = 0;
                    long lightPopulation = 0;
                    for (Palette.Swatch swatch : swatches) {
                        logger.d(swatch.toString());
                        totalPopulation += swatch.getPopulation();
                        float hslL = swatch.getHsl()[2];
                        if (hslL >= 0.8) {
                            lightPopulation += swatch.getPopulation();
                        }
                    }
                    float lightRatio = (float) lightPopulation / (float) totalPopulation;
                    logger.d("totalPopulation:" + totalPopulation + ", lightPopulation:" + lightPopulation);
//                    if (lightRatio > 0.5) {
//                        logger.d("light theme " + lightRatio);
//                    } else {
//                        logger.d("dark theme " + lightRatio);
//                    }
                }
            });
        }

        @Override
        protected Bitmap doInBackground(BitmapLoadRequest... params) {
            Bitmap bitmap = null;
            if (params != null && params.length > 0) {
                BitmapLoadRequest request = params[0];
                if (request != null) {
                    try {
                        if (!TextUtils.isEmpty(request.path)) {
                            bitmap = decodeFromPath(request.path);
                        } else {
                            bitmap = decodeFromUri(request.uri);
                        }
                    } catch (Exception e) {

                    }
                }
            }
            return bitmap;
        }

        private Bitmap decodeFromPath(String path) {
            logger.d("decode path:" + path);
            BitmapFactory.Options bfo = new BitmapFactory.Options();
            bfo.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, bfo);
            bfo.inJustDecodeBounds = false;
            bfo.inSampleSize = calculateInSampleSize(bfo, 200, 300);
            return BitmapFactory.decodeFile(path, bfo);
        }

        private Bitmap decodeFromUri(Uri uri) throws FileNotFoundException {
            logger.d("decode uri:" + uri);
            BitmapFactory.Options bfo = new BitmapFactory.Options();
            bfo.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(App.context.getContentResolver().openInputStream(uri), null, bfo);
            bfo.inJustDecodeBounds = false;
            bfo.inSampleSize = calculateInSampleSize(bfo, 200, 300);
            return BitmapFactory.decodeStream(App.context.getContentResolver().openInputStream(uri), null, bfo);
        }

        public static int calculateInSampleSize(
                BitmapFactory.Options options, int reqWidth, int reqHeight) {
            // Raw height and width of image
            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;

            if (height > reqHeight || width > reqWidth) {

                final int halfHeight = height / 2;
                final int halfWidth = width / 2;

                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while ((halfHeight / inSampleSize) > reqHeight
                        && (halfWidth / inSampleSize) > reqWidth) {
                    inSampleSize *= 2;
                }
            }

            return inSampleSize;
        }
    }

    public static class BitmapParseResult {
        int totalPixels;
        int whitePixels;

        @Override
        public String toString() {
            return String.format("BitmapParseResult{totalPixels:%d, whitePixels:%d}", totalPixels, whitePixels);
        }
    }

    public static class BitmapParser extends AsyncTask<Bitmap, Void, BitmapParseResult> {

        XLog logger = new XLog(PalleteCheckShineActivityFragment.class);

        private static final int DEFAULT_RESIZE_BITMAP_MAX_DIMENSION = 192;

        private static final int DETECT_REGIONS_COUNT = 8;

        private ArrayList<Rect> detectRegions;

        BitmapParser() {
            detectRegions = new ArrayList<Rect>(DETECT_REGIONS_COUNT);
        }

        @Override
        protected void onPostExecute(BitmapParseResult bitmapParseResult) {
            super.onPostExecute(bitmapParseResult);
            logger.d("BitmapParseResult:" + bitmapParseResult);
        }

        @Override
        protected BitmapParseResult doInBackground(Bitmap... params) {
            if (params != null && params.length >= 0) {
                Bitmap bitmap = params[0];
                if (bitmap != null) {
                    generateDetectRegions(bitmap);
                    //Bitmap sbitmap = scaleBitmapDown(bitmap, DEFAULT_RESIZE_BITMAP_MAX_DIMENSION);
                    Bitmap sbitmap = bitmap;
                    //modifyDetectRegionsWithScale(sbitmap, bitmap);
                    logger.d("BitmapParseResult doInBackground:" + bitmap.getWidth() + ", " + bitmap.getHeight());
                    for (int i = 0; i < DETECT_REGIONS_COUNT; ++i) {
                        Rect region = detectRegions.get(i);
                        logger.d("detect region:" + region + ", i:" + i);
                        boolean isShinning = startParse(getPixelsFromBitmap(sbitmap, region));
                        logger.d("isShinning:" + i + ", " + isShinning);
                    }
                    return null;
                }
            }
            return null;
        }

        private void generateDetectRegions(Bitmap bitmap) {
            int bitmapWidth = bitmap.getWidth();
            int bitmapHeight = bitmap.getHeight();
            int detectCornerSize = (int)((bitmapWidth > bitmapHeight ? bitmapHeight : bitmapWidth) / 4f);
            Log.d("wh_debug", "checkShine detect_region_corner_size:" + detectCornerSize + ", bitmap size:" + bitmap.getWidth() + ", " + bitmap.getHeight());
            int shortestEdgeSize = bitmapHeight > bitmapWidth ? bitmapWidth : bitmapHeight;
            if (shortestEdgeSize < detectCornerSize * 2) {
                detectCornerSize = shortestEdgeSize / 4;
            }
            detectRegions.clear();
            for (int i = 0; i < DETECT_REGIONS_COUNT; ++i) {
                Rect region = new Rect();
                if (i == 0) {
                    region.set(0, 0, detectCornerSize, detectCornerSize);
                } else if (i == 1) {
                    region.set(detectCornerSize, 0, bitmapWidth - detectCornerSize, detectCornerSize);
                } else if (i == 2) {
                    region.set(bitmapWidth - detectCornerSize, 0, bitmapWidth, detectCornerSize);
                } else if (i == 3) {
                    region.set(bitmapWidth - detectCornerSize, detectCornerSize, bitmapWidth, bitmapHeight - detectCornerSize);
                } else if (i == 4) {
                    region.set(bitmapWidth - detectCornerSize, bitmapHeight - detectCornerSize, bitmapWidth, bitmapHeight);
                } else if (i == 5) {
                    region.set(detectCornerSize, bitmapHeight - detectCornerSize, bitmapWidth - detectCornerSize, bitmapHeight);
                } else if (i == 6) {
                    region.set(0, bitmapHeight - detectCornerSize, detectCornerSize, bitmapHeight);
                } else if (i == 7) {
                    region.set(0, detectCornerSize, detectCornerSize, bitmapHeight - detectCornerSize);
                }
                detectRegions.add(region);
            }
        }

        private void modifyDetectRegionsWithScale(Bitmap scaledBitmap, Bitmap originBitmap) {
            // If we have a scaled bitmap and a selected region, we need to scale down the
            // region to match the new scale
            final float scale = scaledBitmap.getWidth() / (float) originBitmap.getWidth();
            for (int i = 0; i < DETECT_REGIONS_COUNT; ++i) {
                Rect region = detectRegions.get(i);
                region.left = (int) Math.floor(region.left * scale);
                region.top = (int) Math.floor(region.top * scale);
                region.right = (int) Math.floor(region.right * scale);
                region.bottom = (int) Math.floor(region.bottom * scale);
            }
        }

//        private int[] getPixelsFromBitmap(Bitmap bitmap) {
//            final int bitmapWidth = bitmap.getWidth();
//            final int bitmapHeight = bitmap.getHeight();
//            final int[] pixels = new int[bitmapWidth * bitmapHeight];
//
//            bitmap.getPixels(pixels, 0, bitmapWidth, 0, 0, bitmapWidth, bitmapHeight);
//            return pixels;
//        }

        private int[] getPixelsFromBitmap(Bitmap bitmap, Rect region) {
            final int bitmapWidth = bitmap.getWidth();
            final int bitmapHeight = bitmap.getHeight();
            final int[] pixels = new int[bitmapWidth * bitmapHeight];

            if (region == null) {
                // If we don't have a region, return all of the pixels
                bitmap.getPixels(pixels, 0, bitmapWidth, 0, 0, bitmapWidth, bitmapHeight);
                return pixels;
            } else {
                // If we do have a region, lets create a subset array containing only the region's
                // pixels
                final int regionWidth = region.width();
                final int regionHeight = region.height();

                final int[] subsetPixels = new int[regionWidth * region.height()];
                Bitmap subBitmap = Bitmap.createBitmap(bitmap, region.left, region.top, regionWidth, regionHeight);
                subBitmap.getPixels(subsetPixels, 0, subBitmap.getWidth(), 0, 0, subBitmap.getWidth(), subBitmap.getHeight());

                Bitmap cBitmap = Bitmap.createBitmap(subsetPixels, subBitmap.getWidth(), subBitmap.getHeight(), subBitmap.getConfig());


                // First read the pixels within the region
                bitmap.getPixels(pixels, 0, bitmapWidth, region.left, region.top,
                        regionWidth, regionHeight);
                Bitmap cBitmapFull = Bitmap.createBitmap(pixels, bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888);
                // pixels now contains all of the pixels, but not packed together. We need to
                // iterate through each row and copy them into a new smaller array
                final int[] subsetPixels2 = new int[regionWidth * region.height()];
                for (int row = 0; row < regionHeight; row++) {
                    System.arraycopy(pixels, (row * bitmapWidth),
                            subsetPixels2, row * regionWidth, regionWidth);
                }
                Bitmap cBitmap2 = Bitmap.createBitmap(subsetPixels2, regionWidth, region.height(), Bitmap.Config.ARGB_8888);

                int[] p3 = getBitmapPixels(bitmap, region.left, region.top,
                        regionWidth, regionHeight);
                Bitmap cBitmap3 = Bitmap.createBitmap(p3, regionWidth, regionHeight, Bitmap.Config.ARGB_8888);
                return subsetPixels2;
            }
        }

        public static int[] getBitmapPixels(Bitmap bitmap, int x, int y, int width, int height) {
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), x, y,
                    width, height);
            final int[] subsetPixels = new int[width * height];
            for (int row = 0; row < height; row++) {
                System.arraycopy(pixels, (row * bitmap.getWidth()),
                        subsetPixels, row * width, width);
            }
            return subsetPixels;
        }

        private boolean startParse(final int[] pixels) {
            BitmapParseResult result = new BitmapParseResult();
            int totalPixels = pixels.length;
            int whitePixels = 0;
            for (int i = 0; i < pixels.length; ++i) {
                if (isWhiteColor(pixels[i])) {
                    whitePixels++;
                }
            }
            result.totalPixels = totalPixels;
            result.whitePixels = whitePixels;
            logger.d("parsing:" + "totalPixels:" + totalPixels + ", whitePixels:" + whitePixels);
            //return whitePixels > 10;
            return whitePixels / (float)totalPixels > 0.1 && whitePixels > 10;
        }

        private boolean isWhiteColor(int pixel) {
            float[] hsl = new float[3];
            //Color.colorToHSV(pixel, hsv);
            ColorUtils.colorToHSL(pixel, hsl);
            //logger.d("isWhiteColor hsv:" + Arrays.toString(hsv));
            if (hsl[2] >= 0.9) {
                return true;
            }
            return false;
        }

        private static Bitmap scaleBitmapDown(Bitmap bitmap, final int targetMaxDimension) {
            final int maxDimension = Math.max(bitmap.getWidth(), bitmap.getHeight());

            if (maxDimension <= targetMaxDimension) {
                // If the bitmap is small enough already, just return it
                return bitmap;
            }

            final float scaleRatio = targetMaxDimension / (float) maxDimension;
            return Bitmap.createScaledBitmap(bitmap,
                    Math.round(bitmap.getWidth() * scaleRatio),
                    Math.round(bitmap.getHeight() * scaleRatio),
                    false);
        }
    }

}
