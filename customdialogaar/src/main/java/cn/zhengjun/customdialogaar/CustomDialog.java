package cn.zhengjun.customdialogaar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * OKLine(HangZhou) co.,Ltd.
 * Author  : Zheng Jun
 * Email   : zhengjun@okline.cn
 * Date    : 2017/3/30
 * Summary : 自定义的提示框
 */

public class CustomDialog extends Dialog {

    public static final int MODE_UNIVERSAL = 0;
    public static final int MODE_BLACK_BLUE = 1;
    public static final int MODE_INVALID_NETWORK = 2;
    public static final int MODE_EDIT_TEXT = 3;
    public static final int MODE_OKLINE2 = 10;

    public static enum CustomDialogStyle {
        ;
        
    }

    private final Context context;
    private final String title;
    private final String message;
    private final String negativeButtonText;
    private final String positiveButtonText;
    private final DialogClickListener listener;
    private final String submessage;
    private final int mode;

    public CustomDialog(Context context, String title, String message, String submessage, String negativeButtonText, String positiveButtonText, DialogClickListener listener, int mode) {
        super(context, R.style.customdialog);
        this.context = context;
        this.title = title;
        this.message = message;
        this.submessage = submessage;
        this.negativeButtonText = negativeButtonText;
        this.positiveButtonText = positiveButtonText;
        this.listener = listener;
        this.mode = mode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_public_dialog, null);
        setContentView(view);
        TextView tvPublicDialogTitle = (TextView) view.findViewById(R.id.tv_public_dialog_title);
        View vTitleDivider = view.findViewById(R.id.v_title_divider);
        TextView tvPublicDialogMessage = (TextView) view.findViewById(R.id.tv_public_dialog_message);
        final EditText et_public_dialog_message = (EditText) view.findViewById(R.id.et_public_dialog_message);
        TextView tvPublicDialogSubmessage = (TextView) view.findViewById(R.id.tv_public_dialog_submessage);
        TextView tvPublicDialogCancel = (TextView) view.findViewById(R.id.tv_public_dialog_cancel);
        View vButtonDivider = view.findViewById(R.id.v_button_divider);
        TextView tvPublicDialogConfirm = (TextView) view.findViewById(R.id.tv_public_dialog_confirm);
        ImageView ivCautions = (ImageView) view.findViewById(R.id.iv_cautions);
        LinearLayout llDialogbody = (LinearLayout) view.findViewById(R.id.ll_dialogbody);
        LinearLayout ll_bottom_container = (LinearLayout) view.findViewById(R.id.ll_bottom_container);

        if (title != null) {
            tvPublicDialogTitle.setVisibility(View.VISIBLE);
            vTitleDivider.setVisibility(View.VISIBLE);
            tvPublicDialogTitle.setText(title);
        }
        if (submessage != null) {
            tvPublicDialogSubmessage.setVisibility(View.VISIBLE);
            tvPublicDialogSubmessage.setText(submessage);
        }
        if (negativeButtonText == null) {
            tvPublicDialogCancel.setVisibility(View.GONE);
            vButtonDivider.setVisibility(View.GONE);

        } else {
            tvPublicDialogCancel.setText(negativeButtonText);
            tvPublicDialogCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNegtiveClick();
                    CustomDialog.this.dismiss();
                }
            });
        }
        tvPublicDialogConfirm.setText(positiveButtonText);
        tvPublicDialogConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPositiveClick(mode == MODE_EDIT_TEXT ? et_public_dialog_message.getText().toString().trim():null);
                CustomDialog.this.dismiss();
            }
        });
        tvPublicDialogMessage.setText(message);

        switch (mode) {
            case MODE_UNIVERSAL:

                break;
            case MODE_OKLINE2:
                tvPublicDialogSubmessage.setGravity(Gravity.CENTER);
                tvPublicDialogSubmessage.setTextColor(Color.parseColor("#7c7c7c"));
                tvPublicDialogCancel.setTextColor(Color.parseColor("#7c7c7c"));
                tvPublicDialogConfirm.setTextColor(Color.parseColor("#1f86ed"));
                ll_bottom_container.setBackgroundResource(R.drawable.background_f1f1f1);
                break;
            case MODE_BLACK_BLUE:
                et_public_dialog_message.setVisibility(View.GONE);
                tvPublicDialogCancel.setTextColor(Color.parseColor("#737373"));
                tvPublicDialogConfirm.setTextColor(Color.parseColor("#33aaff"));
                ll_bottom_container.setBackgroundResource(R.drawable.background_f1f1f1);
                break;
            case MODE_INVALID_NETWORK:
                ivCautions.setVisibility(View.VISIBLE);
                break;
            case MODE_EDIT_TEXT:
                vTitleDivider.setVisibility(View.GONE);
                tvPublicDialogTitle.setVisibility(View.VISIBLE);
                tvPublicDialogTitle.setText(title);
                et_public_dialog_message.setVisibility(View.VISIBLE);
                et_public_dialog_message.setHint(message);
                tvPublicDialogMessage.setVisibility(View.GONE);
                tvPublicDialogConfirm.setTextColor(Color.parseColor("#33aaff"));
                tvPublicDialogCancel.setTextColor(Color.parseColor("#737373"));
                ll_bottom_container.setBackgroundResource(R.drawable.background_f1f1f1);
                break;
            default:

                break;
        }

        setCanceledOnTouchOutside(false);

        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setAttributes(lp);
    }


    public interface DialogClickListener {
        void onPositiveClick(String manualContent);
        void onNegtiveClick();
    }
}
