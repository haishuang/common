package com.hs.common.utils;

import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class KeyboardUtils {
    /**
     * 横屏时禁止输入法全屏
     * @param mEditText
     */
    public static void setKeyboardOpen(EditText mEditText){
        mEditText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        //在XML布局文件里的EditText设置
       //android:imeOptions="flagNoExtractUi"
    }
}
