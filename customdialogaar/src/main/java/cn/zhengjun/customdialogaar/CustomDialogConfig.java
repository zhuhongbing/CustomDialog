package cn.zhengjun.customdialogaar;

public class CustomDialogConfig {
    private final String mTitle;
    private final String mMessage;
    private final String mSubmessage;
    private final String mNegativeButtonText;
    private final String mPositiveButtonText;
    private final CustomDialog.DialogClickListener mListener;
    @CustomDialog.CSStyle
    private final int mMode;

    public CustomDialogConfig(String pTitle, String pMessage, String pSubmessage, String pNegativeButtonText, String pPositiveButtonText, CustomDialog.DialogClickListener pListener, int pMode) {
        mTitle = pTitle;
        mMessage = pMessage;
        mSubmessage = pSubmessage;
        mNegativeButtonText = pNegativeButtonText;
        mPositiveButtonText = pPositiveButtonText;
        mListener = pListener;
        mMode = pMode;
    }


    String getTitle() {
        return mTitle;
    }

    String getMessage() {
        return mMessage;
    }

    String getSubmessage() {
        return mSubmessage;
    }

    String getNegativeButtonText() {
        return mNegativeButtonText;
    }

    String getPositiveButtonText() {
        return mPositiveButtonText;
    }

    CustomDialog.DialogClickListener getListener() {
        return mListener;
    }

    int getMode() {
        return mMode;
    }
}
