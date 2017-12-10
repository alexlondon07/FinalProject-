package io.github.alexlondon07.finalproject.helper;

/**
 * Created by alexlondon07 on 9/16/17.
 */

public class Constants {

    public  final static String TAG_APP = "***** MVP *****";
    public final static String URL_BASE_TESTING  = "https://shoppingproducts.herokuapp.com/";
    public final static int TIME_OUT = 6;
    public static final String REQUEST_TIMEOUT_ERROR_MESSAGE = "La solicitud está tardando demasiado. Por favor inténtalo nuevamente.";
    public static final int DEFAULT_ERROR_CODE = 0;
    public static final String DEFAULT_ERROR = "Ha ocurrido un error, intentalo nuevamente.";
    public static final int UNAUTHORIZED_ERROR_CODE = 401;
    public static final int NOT_FOUND_ERROR_CODE = 404;

    //DATABASE
    public  static final String DATABASE_NAME = "";
    public  static final int DATABASE_VERSION = 3;

    public static final String URL_XML_BASE = "http://trailers.apple.com/trailers/home/xml/";
    public static final String ITEM_RECORD = "RECORDS";
    public static final String LIST_CINEMA = "LIST_CINEMA";


    public static final int GALLERY_KIT_KAT = 19;
    public static final int GALLERY = 20;
    public static final String PREFIX_FILE_IMAGE = "JPEG_";
    public static final String FORMAT_DATE_FILE = "yyyyMMdd_HHmmss";
    public static final String SUFFIX_FILE_IMAGE = ".jpg";
    public static final String SUFFIX_FILE_AUDIO = ".mp3";
    public static final String PREFIX_FILE_AUDIO = "audioRecord";
    public static final int MAX_DURATION = 30000;
    public static final int INTERVAL = 1000;
    public static final int REQUEST_VIDEO_CAPTURE = 22;

    public static final int CAMERA_CAPTURE = 21;
    public static int REQUEST_CODE_PERMISSION = 2;

}
